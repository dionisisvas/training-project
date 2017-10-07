package com.iri.training.web.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.Post;
import com.iri.training.model.interfaces.IPostable;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Service
public final class VerificationServiceImpl implements VerificationService {

	private static final Logger logger = Logger.getLogger(VerificationService.class);

	@Autowired
	CommentService commentService;
	@Autowired
	PostService postService;

	@Override
	public final boolean verifyPostable(final IPostable postable) {

		logger.debug("ENTERED verifyPostable for " + postable.getClass() + ": " + postable + ". Verification success.");

		if (postable.getContent() == null) {
			logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Content is null.");

			return false;
		}

		if (postable instanceof Post) {
			if (((Post) postable).getTitle() != null) {
				if (((Post) postable).getTitle().length() > 80) {
					logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Title exceeds allowed length.");
					logger.debug("here we are");
					return false;
				}
			}

			if (postable.getContent().length() > 800) {
				logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Content exceeds allowed length.");

				return false;
			}
		}
		else if (postable instanceof Comment) {
			if (postable.getContent().length() > 200) {
				logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Content exceeds allowed length.");

				return false;
			}
		}
		else {
			logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Unsupported IPostable implementation.");

			return false;
		}

		logger.debug("EXITING verifyPostable for " + postable.getClass() + ": " + postable + ". Verification success.");

		return true;
	}

	@Override
	public final boolean verifyAddRights(final IPostable postable, final String authHeader) {

		logger.debug("ENTERED verifyAddRights for " + postable.getClass() + ": " + postable);

		final String token = authHeader.substring(7);
		final Claims claims;

		try {
			claims = Jwts.parser().setSigningKey(PropertiesConfig.JWT_KEY)
				.parseClaimsJws(token).getBody();
		} catch (final SignatureException e) {
			logger.debug("EXITING verifyAddRights, couldn't parse the token. Exception: " + e);

			return false;
		}

		if ((postable.getSubjectType() !=  SubjectType.USER) &&
			(postable.getSubjectType() !=  SubjectType.POST)) {
			logger.debug("EXITING verifyAddRights, currently you can only post and comment in user profiles.");

			return false;
		}

		final long requesterId = Long.parseLong(claims.getSubject());

		logger.debug("EXITING verifyAddRights, user with id: " + requesterId + " has sufficient rights to post.");

		return true;
	}

	@Override
	public final boolean verifyDeleteRights(final SubjectType postableType, final long postableId, final String authHeader) {

		logger.debug("ENTERED verifyDeleteRights for " + postableType + " with id: " + postableId);

		final String token = authHeader.substring(7);
		final Claims claims;
		final IPostable postableFromDB;

		try {
			claims = Jwts.parser().setSigningKey(PropertiesConfig.JWT_KEY)
				.parseClaimsJws(token).getBody();
		} catch (final SignatureException e) {
			logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
				". JWT parsing failed: " + e);

			return false;
		}

		final long requesterId = Long.parseLong(claims.getSubject());

		try {
			if (postableType == SubjectType.POST) {
				postableFromDB = postService.getPostById(postableId, false);
			}
			else if (postableType == SubjectType.COMMENT) {
				postableFromDB = commentService.getCommentById(postableId, false);
			}
			else {
				logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
					". Unsupported IPostable implementation.");

				return false;
			}
		} catch (SQLException e) {
			logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
				". Getting post from the DB failed: " + e);

			return false;
		}

		if (postableFromDB == null) {
			logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
				". DB entry is null.");

			return false;
		}

		// Poster is the same one requesting to delete
		if (postableFromDB.getPosterId() == requesterId) {
			logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
				". Sufficient rights to delete.");

			return true;
		}

		// Postable is a post on the profile of the one requesting to delete
		if (postableFromDB instanceof Post &&
				postableFromDB.getSubjectId() == requesterId) {
			logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
					". Sufficient rights to delete.");

			return true;
		}

		// Postable is a comment on the profile of the one requesting to delete
		if (postableFromDB instanceof Comment) {

			// Depth 1 comment (post reply)
			if ((postableFromDB.getSubjectType() == SubjectType.POST)) {
				try {

					final Post parentPost = postService.getPostById(postableFromDB.getSubjectId(), false);

					if ((parentPost.getSubjectType() == SubjectType.USER) && // First check should be redundant but fail-safe
							(parentPost.getSubjectId() == requesterId)) {
						logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
								". Sufficient rights to delete.");

						return true;
					}
				} catch (SQLException e) {
					logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
							". Getting parent post from the DB failed: " + e);

					return false;
				}
			}

			// Depth 2 comment (comment reply)
			if (postableFromDB.getSubjectType() == SubjectType.COMMENT) {
				try {
					final Comment parentComment = commentService.getCommentById(postableFromDB.getSubjectId(), false);

					if (parentComment.getSubjectType() == SubjectType.POST) { // This check should be redundant but fail-safe
						try {

							final Post parentPost = postService.getPostById(postableFromDB.getSubjectId(), false);

							if ((parentPost.getSubjectType() == SubjectType.USER) && // First check should be redundant but fail-safe
									(parentPost.getSubjectId() == requesterId)) {
								logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
										". Sufficient rights to delete.");

								return true;
							}
						} catch (SQLException e) {
							logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
									". Getting parent post from the DB failed: " + e);

							return false;
						}
					}
				} catch (SQLException e) {
					logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
							". Getting parent comment from the DB failed: " + e);

					return false;
				}
			}
		}

		logger.debug("EXITING verifyDeleteRights for " + postableType + " with id: " + postableId +
			". Insufficient rights.");

		return false;
	}

	@Override
	public final boolean verifyEditRights(final IPostable postable, final String authHeader) {

		logger.debug("ENTERED verifyEditRights for " + postable.getClass() + " with id: " + postable.getId());

		final String token = authHeader.substring(7);
		final Claims claims;
		final IPostable postableFromDB;

		try {
			claims = Jwts.parser().setSigningKey(PropertiesConfig.JWT_KEY)
				.parseClaimsJws(token).getBody();
		} catch (final SignatureException e) {
			logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
				". JWT parsing failed: " + e);

			return false;
		}

		final long requesterId = Long.parseLong(claims.getSubject());

		try {
			if (postable instanceof Post) {
				postableFromDB = postService.getPostById(postable.getId(), false);
			}
			else if (postable instanceof Comment) {
				postableFromDB = commentService.getCommentById(postable.getId(), false);
			}
			else {
				logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
					". Unsupported IPostable implementation.");

				return false;
			}
		} catch (SQLException e) {
			logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
				". Getting post from the DB failed: " + e);

			return false;
		}

		if (postable.getContent() == null) {
			logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
				". New post content is null.");

			return false;
		}

		if (postableFromDB.getPosterId() == requesterId) {
			logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
				". Sufficient rights to edit.");

			return true;
		}

		logger.debug("EXITING verifyEditRights for " + postable.getClass() + " with id: " + postable.getId() +
			". Insufficient rights.");

		return false;
	}
}

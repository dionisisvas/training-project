package com.iri.training.model;

public class UserComment {

		private String description;
		private String commentDate;
		private int commentID;
	    private int userID;


		public String getDescription() {
			return this.description;
		}

		public void setDescription(final String description) {
			this.description = description;
		}

	    public String getDate() {
		return this.commentDate;
	}

	    public void setDate(final String commentDate) {
		this.commentDate = commentDate;
	}

		public int getCommentID() {
		return this.commentID;
	}

		public void setCommID(final int commentID) {
		this.commentID = commentID;
	}

		public int getUserID() {
		return userID;
	}

		public void setUserID(final int userID) {
		this.userID = userID;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("UserComment{");
		sb.append("commentID=");
		sb.append(commentID);
		sb.append(", userId=");
		sb.append(userID);
		sb.append('}');

		return sb.toString();
	}
}



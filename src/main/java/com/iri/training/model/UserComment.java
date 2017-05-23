package com.iri.training.model;

public class UserComment {



		private String description;
		private String commentDate;
		private int commentID;
	    private int userID;


		public String getDescription(final String description) {
			return this.description;
		}

		public void setDescription(final String description) {
			this.description = description;
		}

	    public String getDate(final String commentDate) {
		return this.commentDate;
	}

	    public void setDate(final String commentDate) {
		this.commentDate = commentDate;
	}

		public int getCommID(final int commentID) {
		return this.commentID;
	}

		public void setCommID(final int commentID) {
		this.commentID = commentID;
	}

		public int getUserID(final int userID) {
		return userID;
	}

		public void setUserID(final int userID) {
		this.userID = userID;
	}
		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();
			builder.append("description=");
			builder.append(description);
			builder.append("commentID=");
			builder.append(commentID);
			builder.append("commentDate=");
			builder.append(commentDate);
			builder.append("userID=");
			builder.append(userID);


			return builder.toString();
		}

}



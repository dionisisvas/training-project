package com.iri.training.model;

public class UserComment {



		private String description;
		private String comdate;
	    private int commID;
	    private int userID;


		public String getDescription() {
			return description;
		}

		public void setDescription(final String description) {
			this.description = description;
		}

	    public String getDate() {
		return comdate;
	}

	    public void setDate(final String comdate) {
		this.comdate = comdate;
	}

		public int getCommID() {
		return commID;
	}

		public void setCommID(final int commID) {
		this.commID = commID;
	}

		public int getUserID() {
		return commID;
	}

		public void setUserID(final int userID) {
		this.userID = userID;
	}
		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();
			builder.append("description=");
			builder.append(description);
			builder.append("commID=");
			builder.append(commID);
			builder.append("comdate=");
			builder.append(comdate);
			builder.append("userID=");
			builder.append(userID);


			return builder.toString();
		}

}



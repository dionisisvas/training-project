package com.iri.training.model;

import java.sql.Date;
import java.sql.Time;

public class UserComment {



		private String description;
		private Date date;
	    private Time time;


		public String getDescription() {
			return description;
		}

		public void setDescription(final String description) {
			this.description = description;
		}

		public Time getTime() {
			return time;
		}

		public void setTime(final Time time) {
			this.time = time;
		}

	    public Date getDate() {
		return date;
	}

	    public void setDate(final Date date) {
		this.date = date;
	}


		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();
			builder.append("description=");
			builder.append(description);
			builder.append("time=");
			builder.append(time);
			builder.append("date=");
			builder.append(date);



			return builder.toString();
		}

}



package com.iri.training.model;

import com.iri.training.enums.EducationLevel;

public class Education {

	private long userId;
	private String schoolName;
	private EducationLevel educationLevel;
	private boolean graduated;
	private boolean droppedOut;
	private int startYear;
	private int endYear;

	public long getUserId() {

		return userId;
	}

	public void setUserId(final long userId) {

		this.userId = userId;
	}

	public String getSchoolName() {

		return schoolName;
	}

	public void setSchoolName(final String schoolName) {

		this.schoolName = schoolName;
	}

	public EducationLevel getEducationLevel() {

		return educationLevel;
	}

	public void setEducationLevel(final EducationLevel educationLevel) {

		this.educationLevel = educationLevel;
	}

	public boolean isGraduated() {

		return graduated;
	}

	public void setGraduated(final boolean graduated) {

		this.graduated = graduated;
	}

	public boolean isDroppedOut() {

		return droppedOut;
	}

	public void setDroppedOut(final boolean droppedOut) {

		this.droppedOut = droppedOut;
	}

	public int getStartYear() {

		return startYear;
	}

	public void setStartYear(final int startYear) {

		this.startYear = startYear;
	}

	public int getEndYear() {

		return endYear;
	}

	public void setEndYear(final int endYear) {

		this.endYear = endYear;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Education{");
		sb.append("userId='");
		sb.append(userId);
		sb.append('\'');
		sb.append(", schoolName='");
		sb.append(schoolName);
		sb.append('\'');
		sb.append(", educationLevel='");
		sb.append(educationLevel);
		sb.append('\'');
		sb.append(", graduated='");
		sb.append(graduated);
		sb.append('\'');
		sb.append(", droppedOut='");
		sb.append(droppedOut);
		sb.append('\'');
		sb.append(", startYear='");
		sb.append(startYear);
		sb.append('\'');
		sb.append(", endYear='");
		sb.append(endYear);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}

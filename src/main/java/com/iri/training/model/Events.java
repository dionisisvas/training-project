package com.iri.training.model;

import java.time.LocalDate;

public class Events {

	private Long userId;
	private Long eventId;
	private LocalDate dateOfEvent;
	private String title;
	private String description;

	public Long getUserId() {

		return userId;
	}

	public Long getEventId() {

		return eventId;
	}

	public LocalDate getDateOfEvent() {

		return dateOfEvent;
	}

	public String getTitle() {

		return title;
	}

	public String getDescription() {

		return description;
	}


	public void setUserId(final Long userId) {

		this.userId = userId;
	}

	public void setEventId(final Long eventId) {

		this.eventId = eventId;
	}

	public void setDateOfEvent(final LocalDate dateOfEvent) {

		this.dateOfEvent = dateOfEvent;
	}

	public void setTitle(final String title) {

		this.title = title;
	}

	public void setDescription(final String description) {

		this.description = description;
	}

	@Override public String toString() {

		return "Events{" +
			"userId=" + userId +
			", eventId=" + eventId +
			", dateOfEvent=" + dateOfEvent +
			", title='" + title + '\'' +
			", description='" + description + '\'' +
			'}';
	}
}
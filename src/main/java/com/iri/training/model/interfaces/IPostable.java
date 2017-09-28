package com.iri.training.model.interfaces;

import java.time.LocalDateTime;

import com.iri.training.enums.SubjectType;

public interface IPostable {

	long getId();

	long getPosterId();

	SubjectType getSubjectType();

	long getSubjectId();

	String getContent();

	LocalDateTime getCreationDate();
}

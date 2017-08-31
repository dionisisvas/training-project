package com.iri.training.model.interfaces;

import java.time.LocalDateTime;

public interface IPostable {

	long getId();

	long getPosterId();

	String getContent();

	LocalDateTime getCreationDate();
}

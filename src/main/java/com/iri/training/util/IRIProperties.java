package com.iri.training.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class IRIProperties extends Properties {

	private static final Logger logger = Logger.getLogger(IRIProperties.class);

	private final File file;

	public IRIProperties(String fileName) {
		this(new File(fileName));
	}

	public IRIProperties(File file) {
		this.file = file;

		try (FileInputStream fis = new FileInputStream(file)) {

		}
		catch (Exception e) {
			logger.warn("exception: " + e);
		}
	}
}

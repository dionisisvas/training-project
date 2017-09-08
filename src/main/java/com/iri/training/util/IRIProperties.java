package com.iri.training.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class IRIProperties extends Properties {

	private static final Logger logger = Logger.getLogger(IRIProperties.class);

	public IRIProperties(File file) {

		this(file.getName());
	}

	public IRIProperties(String fileName) {

		try (final InputStream is = IRIProperties.class.getResourceAsStream(fileName)) {
			super.load(is);
			is.close();

			logger.info(fileName + " file loaded.");
		}
		catch (Exception e) {
			logger.warn("Failed to load " + fileName + ": " + e);
		}
	}

	public Byte getByte(String key) {

		return this.getByte(key, null);
	}

	public Byte getByte(String key, Byte defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Byte.parseByte(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public Short getShort(String key) {

		return this.getShort(key, null);
	}

	public Short getShort(String key, Short defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Short.parseShort(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public Integer getInt(String key) {

		return this.getInt(key, null);
	}

	public Integer getInt(String key, Integer defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Integer.parseInt(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public Long getLong(String key) {

		return this.getLong(key, null);
	}

	public Long getLong(String key, Long defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Long.parseLong(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public Float getFloat(String key) {

		return this.getFloat(key, null);
	}

	public Float getFloat(String key, Float defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Float.parseFloat(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public Double getDouble(String key) {

		return this.getDouble(key, null);
	}

	public Double getDouble(String key, Double defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Double.parseDouble(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}

	public String getString(String key) {

		return this.getString(key, null);
	}

	public String getString(String key, String defaultValue) {

		String value = super.getProperty(key);

		return value == null ? defaultValue : value;
	}

	public Boolean getBoolean(String key) {

		return this.getBoolean(key, null);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {

		String value = super.getProperty(key);

		if (value == null) {
			return defaultValue;
		}
		else try {
			return Boolean.parseBoolean(value);
		}
		catch(NumberFormatException e) {
			return defaultValue;
		}
	}
}

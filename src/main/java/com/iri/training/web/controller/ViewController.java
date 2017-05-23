package com.iri.training.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

	@RequestMapping(value = "")
	public String index() {
		return "app";
	}

	@RequestMapping(value = "*")
	public String notFound() {
		return "app";
	}

}

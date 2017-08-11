package com.iri.training.web.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ImageController.class)
public class ImageControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new ImageController()).build();
	}

	@Test
	public void testGetAllUserImages() throws Exception {
		this.mockMvc.perform(get("api/image/user/{userId}", 0L).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetImage() throws Exception {
		this.mockMvc.perform(get("api/image/{imgId}", 0L).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetUserProfileImage() throws Exception {
		this.mockMvc.perform(get("api/image/user/{userId}/profile", 0L).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
	}
}
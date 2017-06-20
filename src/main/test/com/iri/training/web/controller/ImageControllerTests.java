package com.iri.training.repository.test.web.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(ImageController.class)
public class ImageControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new ImageController()).build();
	}

	@Test
	public void testGetAllUserImages() throws Exception {

	}

	@Test
	public void testGetUserImage() throws Exception {

	}

	@Test
	public void testGetUserProfileImage() throws Exception {

	}
}
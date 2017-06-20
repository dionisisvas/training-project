package com.iri.training.repository.test.web.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new CommentController()).build();
	}

	@Test
	public void testGetCommentsByUserId() throws Exception {

	}

	@Test
	public void testCreateUserComment() throws Exception {

	}
}
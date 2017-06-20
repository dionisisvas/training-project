package com.iri.training.repository.test.web.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorld.class)
public class CommentControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {

	}

	@Test
	public void testGetCommentsByUserId() throws Exception {

	}

	@Test
	public void testCreateUserComment() throws Exception {

	}
}
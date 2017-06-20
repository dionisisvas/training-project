package com.iri.training.repository.test.web.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new UserController()).build();
	}

	}
	@Test
	public void testGetAllUsers() throws Exception {

	}

	@Test
	public void testGetUser() throws Exception {

	}

	@Test
	public void testCreateUser() throws Exception {

	}
}
package com.iri.training.repository.test.web.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(HobbyController.class)
public class HobbyControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new HobbyController()).build();
	}

	@Test
	public void testGetAllHobbies() throws Exception {

	}

	@Test
	public void testGetHobby() throws Exception {

	}

	@Test
	public void testGetAllUserHobbies() throws Exception {

	}
}
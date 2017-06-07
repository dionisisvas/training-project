package com.iri.training.repository.test;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import com.iri.training.repository.UserCommentRepositoryImpl;

public class UserRepositoryImplTest {

	private static final Logger logger = Logger.getLogger(UserRepositoryImplTest.class);

	@Mock
	private UserRepositoryImplTest target;
	
	
	@Test
	public void getUserByIdTest() {
		
		logger.info("TEST getUserByIdTest");
		
		
	}

}

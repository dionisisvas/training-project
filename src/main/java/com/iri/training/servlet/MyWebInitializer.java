package com.iri.training.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.iri.training.config.SpringWebConfig;

public class MyWebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Filter temporarily disabled
	/*@Override
	public void onStartup(ServletContext servletContext)
		throws ServletException {
		servletContext
			.addFilter("jwtFilter",
				new JwtFilter())
			.addMappingForUrlPatterns(null, false, "/api/*");

		super.onStartup(servletContext);
	}*/
}
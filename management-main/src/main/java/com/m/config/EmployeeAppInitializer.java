package com.m.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EmployeeAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		@SuppressWarnings("rawtypes")
		Class[] configFiles = { EmployeeAppConfig.class };

		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {

		String[] mappings = { "/" };

		return mappings;
	}

}

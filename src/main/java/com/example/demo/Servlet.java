package com.example.demo;


	import org.springframework.boot.builder.SpringApplicationBuilder;
	import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

	public abstract class Servlet extends SpringBootServletInitializer {

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
		{
			return application.sources(NimapCurdOperationApplication.class);
		}



	
	}



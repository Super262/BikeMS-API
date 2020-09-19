package com.imooc;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.imooc.mapper")
@ComponentScan(basePackages= {"com.imooc", "org.n3r.idworker"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public TomcatEmbeddedServletContainerFactory webServerFactory() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
			@Override
			public void customize(Connector connector) {
				connector.setProperty("relaxedQueryChars", "|{}[]");
			}
		});
		return factory;
	}

}

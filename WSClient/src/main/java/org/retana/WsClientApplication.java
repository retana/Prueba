package org.retana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class WsClientApplication {

	/*		@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/webapp");
        resolver.setSuffix(".html");
        return resolver;
    }
@Bean
	  public ViewResolver viewResolver() {
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setTemplateMode("XHTML");
	    templateResolver.setPrefix("/resources/templates/");
	    templateResolver.setSuffix(".html");
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setTemplateResolver(templateResolver);

	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(engine);
	    return viewResolver;
	  }*/
	public static void main(String[] args) {
		SpringApplication.run(WsClientApplication.class, args);
	}
}

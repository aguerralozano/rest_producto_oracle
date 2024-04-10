package com.aguerra.testgh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * Clase que configura la generación de documentación OpenAPI 
 * 
 * @author Angel Guerra
 */
@Configuration
public class OpenAPIConfig {
	
  @Bean
  public OpenAPI myOpenAPI() {
	  Contact contact = new Contact();
	  contact.setEmail("aguerralozano@gmail.com");
	  contact.setName("Angel Guerra");
	  contact.setUrl("https://www.linkedin.com/in/aguerralozano/");

	  Info info = new Info()
	          .title("PRUEBA TÉCNICA - Rest Post Producto")
	          .version("1.0")
	          .contact(contact)
	          .description("Esta API expone los siguientes endpoints.");

	  return new OpenAPI().info(info);
  }
}

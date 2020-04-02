package br.com.efc.jstokrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value="classpath:/package/hsqldb_cfg.xml")
public class JstokrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JstokrestApplication.class, args);
	}

}

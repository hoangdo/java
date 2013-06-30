package phx.em.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import phx.em.model.Customer;

@Configuration
public class RestExporterConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Customer.class);
	}
}

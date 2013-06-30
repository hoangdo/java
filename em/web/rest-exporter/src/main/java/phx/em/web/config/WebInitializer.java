package phx.em.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import phx.em.service.config.ApplicationConfig;

/**
 * @author Jon Brisbin
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {

		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(ApplicationConfig.class, MvcConfig.class, RestExporterConfig.class);

		ctx.addListener(new ContextLoaderListener(rootCtx));

		ServletRegistration.Dynamic reg = ctx.addServlet("service", new DispatcherServlet(rootCtx));
		reg.setLoadOnStartup(1);
		reg.addMapping("/service/*");

		ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", new DispatcherServlet(rootCtx));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/web/*");
	}
}

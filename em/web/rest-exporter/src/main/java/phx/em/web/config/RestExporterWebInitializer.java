package phx.em.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.data.rest.webmvc.RepositoryRestExporterServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import phx.em.service.config.ApplicationConfig;

/**
 * @author Jon Brisbin
 */
public class RestExporterWebInitializer implements WebApplicationInitializer {

  @Override public void onStartup(ServletContext ctx) throws ServletException {

    AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
    rootCtx.register(ApplicationConfig.class);

    ctx.addListener(new ContextLoaderListener(rootCtx));

    RepositoryRestExporterServlet exporter = new RepositoryRestExporterServlet();

    ServletRegistration.Dynamic reg = ctx.addServlet("rest-exporter", exporter);
    reg.setLoadOnStartup(1);
    reg.addMapping("/*");

  }
}

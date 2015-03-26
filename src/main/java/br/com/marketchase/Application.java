package br.com.marketchase;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer{

	private final String PACKAGE                          = "br.com.marketchase.config"; 
	private final String MAPPING                          = "/*";
	private final String SERVLET_NAME                     = "appServlet";
	private final String URL_PATTERNS                     = "/";
	private final String FILTER_NAME                      = "openEntityManagerInViewFilter";
	private final String ENTITY_MANAGER_FACTORY_BEAN_NAME = "entityManagerFactory";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		Dynamic appServlet = servletContext.addServlet(SERVLET_NAME, new DispatcherServlet(applicationContext));
		//Deve passar o applicationContext para o servlet, caso contr�rio ele ir� procurar o
		//XML referente ao contexto, recebendo o erro:
		//Could not open ServletContext resource [/WEB-INF/appServlet-servlet.xml]		
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping(MAPPING);
		servletContext.addListener(new ContextLoaderListener(applicationContext)); 
		FilterRegistration.Dynamic filter = servletContext.addFilter(FILTER_NAME, buildOpenEntityManagerFilter());
		
		/*filter.setInitParameter("entityManagerFactoryBeanName","persistence.EntityManagerFactory");
		filter.setInitParameter(FILTER_NAME, "entityManagerFactory");
		filter.setInitParameter("singleSession", "true");
		filter.setInitParameter("flushMode", "AUTO");*/
		
		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, URL_PATTERNS);
	}

	private AnnotationConfigWebApplicationContext buildApplicationContext(){
		AnnotationConfigWebApplicationContext webApplicationcontext = new AnnotationConfigWebApplicationContext();
		webApplicationcontext.setConfigLocation(PACKAGE);
		return webApplicationcontext;
	}
	
	private OpenEntityManagerInViewFilter buildOpenEntityManagerFilter() {
		OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
		openEntityManagerInViewFilter.setEntityManagerFactoryBeanName(ENTITY_MANAGER_FACTORY_BEAN_NAME);
		return openEntityManagerInViewFilter;
	}
		
	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
		}
	
}

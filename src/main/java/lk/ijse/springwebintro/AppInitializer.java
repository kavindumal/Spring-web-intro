package lk.ijse.springwebintro;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lk.ijse.springwebintro.config.WebAppConfig;
import lk.ijse.springwebintro.config.WebAppRootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }
}
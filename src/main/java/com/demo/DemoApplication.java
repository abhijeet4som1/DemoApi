package com.demo;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.conf.ConfigurationModule;
import com.demo.conf.DemoConf;
import com.demo.exception.DemoExceptionMapper;
import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * starting point for the application. here all the bundle are registered.
 * 
 * @author Abhijeet
 *
 */
public class DemoApplication extends Application<DemoConf> {

    // logger
    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    // guice injector for dependency injection.
    private GuiceBundle<DemoConf> guiceBundel;

    /**
     * Initializing the application.
     */
    @Override
    public void initialize(Bootstrap<DemoConf> bootstrap) {
        guiceBundel = GuiceBundle.<DemoConf> newBuilder().addModule(new ConfigurationModule())
                .enableAutoConfig(getClass().getPackage().getName()).setConfigClass(DemoConf.class).build();
        bootstrap.addBundle(guiceBundel);
    }

    /**
     * all the resource,healthChecks,Module registration is done automatically
     * by the guice injector hence not required to registe it manually.
     */
    @Override
    public void run(DemoConf touristExchangeConf, Environment environment) throws Exception {

        // changing the jersy filter default setting
        Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter(CrossOriginFilter.EXPOSED_HEADERS_PARAM,
                "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,Location");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
                "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,Location,X-XSRF-TOKEN,X-Bid,X-TOKEN-TYPE");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // exception mapper
        environment.jersey().register(new DemoExceptionMapper());

    }

    /**
     * Main method to run the command line argument.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            /**
             * setting time zone to UTC for this application any date being
             * stored or read will be UTC timezone
             */
            new DemoApplication().run(args);

        } catch (Exception e) {
            DemoApplication.LOG.error("Exception occurred while executing command line argument.", e);
        }
    }

}

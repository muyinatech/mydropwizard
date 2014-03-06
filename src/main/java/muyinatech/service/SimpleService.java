package muyinatech.service;

import muyinatech.config.SimpleServiceConfiguration;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import muyinatech.health.SimpleHealthCheck;
import muyinatech.resources.SimpleResource;

/**
 *
 * @author Tosin
 */
public class SimpleService extends Service<SimpleServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new SimpleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SimpleServiceConfiguration> bootstrap) {
        bootstrap.setName("hello-world"); // set service name
    }

    @Override
    public void run(SimpleServiceConfiguration configuration,
            Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new SimpleResource(template, defaultName));
        environment.addHealthCheck(new SimpleHealthCheck(template));
    }
}

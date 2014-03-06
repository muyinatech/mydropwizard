package muyinatech.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.RollingPolicy;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import muyinatech.config.SimpleServiceConfiguration;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import muyinatech.health.SimpleHealthCheck;
import muyinatech.resources.SimpleResource;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tosin
 */
public class SimpleService extends Service<SimpleServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new SimpleService().run(args);
        createLoggerFor(Logger.ROOT_LOGGER_NAME, "simpleService.log");
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
    
    
   private static Logger createLoggerFor(String string, String file) {
          LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
                    
          RollingFileAppender<ILoggingEvent> rfAppender = new RollingFileAppender<ILoggingEvent>();
          rfAppender.setFile(file);
          rfAppender.setContext(lc);
          
          PatternLayoutEncoder ple = new PatternLayoutEncoder();
          ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
          ple.setContext(lc);
          ple.start();
          
          TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy();
          rollingPolicy.setFileNamePattern("simpleService-%d{yyyy-MM-dd}.log");
          rollingPolicy.setParent(rfAppender);
          rollingPolicy.setContext(lc);
          rollingPolicy.start();
          
          rfAppender.setRollingPolicy(rollingPolicy);
          rfAppender.setEncoder(ple);
          rfAppender.start();
          
          Logger logger = (Logger) LoggerFactory.getLogger(string);
          logger.addAppender(rfAppender);
          logger.setLevel(Level.DEBUG);
          logger.setAdditive(false);
          return logger;              
    }    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muyinatech;

import io.dropwizard.testing.junit.DropwizardAppRule;
import muyinatech.config.SimpleServiceConfiguration;
import muyinatech.service.SimpleService;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.FailureStrategy;
import org.jbehave.core.failures.SilentlyAbsorbingFailure;
import org.junit.ClassRule;
import org.junit.Test;

/**
 *
 * @author Tosin
 */
public class RunAllStoriesTest {
    
        @ClassRule
    public static final DropwizardAppRule testRule = new DropwizardAppRule<SimpleServiceConfiguration>(SimpleService.class, "C:\\dev\\projects\\mydropwizard\\mydropwizard-tests\\src\\test\\resources\\config.yml");
            
     @Test
    public void runClasspathLoadedStoriesAsJUnit() throws Throwable {
        // Embedder defines the configuration and candidate steps
        RESTStories embedder = new RESTStories();
     

     //   embedder.useConfiguration(new MostUsefulConfiguration().useFailureStrategy(new SilentlyAbsorbingFailure()));
        embedder.run();
    }
    
}

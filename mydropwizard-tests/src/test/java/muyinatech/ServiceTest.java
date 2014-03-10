/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muyinatech;

import com.sun.jersey.api.client.Client;
import io.dropwizard.testing.junit.DropwizardAppRule;
import java.util.Map;
import muyinatech.config.SimpleServiceConfiguration;
import muyinatech.service.SimpleService;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 *
 * @author Tosin
 */
public class ServiceTest {

   /* @ClassRule
    public static final DropwizardAppRule testRule = new DropwizardAppRule<SimpleServiceConfiguration>(SimpleService.class, "C:\\dev\\projects\\mydropwizard\\mydropwizard-service\\src\\main\\resources\\config.yml");

    @Test
    public void test() throws Exception {

        final Map<String, Object> content = new Client().resource("http://localhost:9000/simple-service").get(Map.class);

        Assert.assertEquals("Hello, Stranger!", content.get("content"));
    }*/
}

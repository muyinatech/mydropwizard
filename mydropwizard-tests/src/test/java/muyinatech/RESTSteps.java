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

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.io.ResourceLoader;
import org.jbehave.core.io.rest.RESTClient.Type;
import org.jbehave.core.io.rest.Resource;
import org.jbehave.core.io.rest.ResourceIndexer;
import org.jbehave.core.io.rest.ResourceUploader;
import org.jbehave.core.io.rest.redmine.IndexFromRedmine;
import org.jbehave.core.io.rest.redmine.LoadFromRedmine;
import org.jbehave.core.io.rest.redmine.UploadToRedmine;
import org.junit.Assert;
import org.junit.ClassRule;

public class RESTSteps {

	private String providerName;
	private String index;

	@Given("REST provider is $name")
	public void givenRESTProvider(String name) {
		this.providerName = name;
	}

	@When("index is retrieved from $uri")
	public void indexIsRetrieved(String uri) {
                        final Map<String, Object> content = new Client().resource(uri).get(Map.class);

       index = content.get("content").toString();
       System.out.println("ewrwerwer"+index);
	}

	@Then("the index is not empty")
	public void indexIsNotEmpty() {
            Assert.assertFalse(index.isEmpty());
	}
        
}
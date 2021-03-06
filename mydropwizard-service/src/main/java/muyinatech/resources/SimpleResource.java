/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muyinatech.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import muyinatech.core.Saying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tosin
 */
@Path("/simple-service")
@Produces(MediaType.APPLICATION_JSON)
public class SimpleResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SimpleResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        Logger logger = LoggerFactory.getLogger(SimpleResource.class);
        logger.warn("test");
        return new Saying(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
}
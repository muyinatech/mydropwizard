package muyinatech.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This subclass of the Configuration class is used to specify environment specific parameters.
 * The parameters are specified in a YAML configuration file which is deserialized to an instance of
 * the service's configuration class and validated.
 * and open the template in the editor.
 */
public class SimpleServiceConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }
}

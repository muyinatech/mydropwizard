/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muyinatech.health;

import com.yammer.metrics.core.HealthCheck;
/**
 *
 * @author Tosin
 */
public class SimpleHealthCheck extends HealthCheck {
    private final String template;

    public SimpleHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}

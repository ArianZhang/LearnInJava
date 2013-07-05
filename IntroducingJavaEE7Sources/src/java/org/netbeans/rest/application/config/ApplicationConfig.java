/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Juneau
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Do not modify this method. It is automatically generated by NetBeans REST support.
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(org.javaee7.chapter08.JobsService.class);
        resources.add(org.javaee7.chapter08.MyProvider.class);
        resources.add(org.javaee7.chapter08.ProductService.class);
        resources.add(org.javaee7.chapter08.service.UsersFacadeREST.class);
        resources.add(org.javaee7.services.AlertFilter.class);
        resources.add(org.javaee7.services.GenericResource.class);
        resources.add(org.javaee7.services.LongRunningService.class);
        resources.add(org.javaee7.services.SimpleAcmeResource.class);
        resources.add(org.javaee7.services.SimpleRest.class);
        // following code can be used to customize Jersey 2.0 JSON provider:
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.moxy.json.MoxyJsonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.jettison.JettisonFeature");
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return resources;
    }
    
}

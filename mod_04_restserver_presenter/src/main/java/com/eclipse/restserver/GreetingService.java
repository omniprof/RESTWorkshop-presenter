package com.eclipse.restserver;

import com.eclipse.restserver.bean.RestBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import java.time.LocalDateTime;

/**
 * This RESTful service takes the "name" you supplied when you called upon the
 * service and adds the date and time along with a String with the name of this
 * service and stores this in a Java Bean.
 * 
 * curl http://localhost:8080/Mod_04_RestServer_presenter/services/hello
 *
 * @author Ken Fogel
 */
@Path("hello")
public class GreetingService {

    @Inject
    private RestBean restBean;

    /**
     * If a JavaBean style object is returned then it will be formatted as a JSON string. No need for
     * @Produces({MediaType.APPLICATION_JSON})    
     * 
     * @param name
     * @return a RestBean object
     */
    @GET
    @Produces({APPLICATION_JSON})
    public RestBean hello(@QueryParam("name") String name) {
//        RestBean restBean = new RestBean();
        if ((name == null) || name.trim().isEmpty()) {
            name = "Anonymous";
        }
        restBean.setName(name);
        restBean.setTheTime(LocalDateTime.now());
        restBean.setServiceSource("GreetingService");
        return restBean;
    }
}


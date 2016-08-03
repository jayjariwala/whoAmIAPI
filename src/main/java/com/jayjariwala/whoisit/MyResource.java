package com.jayjariwala.whoisit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import model.model;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	model model=new model();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public model getIpaddress(@Context HttpHeaders httpHeaders)
    {
		String host=httpHeaders.getRequestHeader("host").get(0);
		String agent=httpHeaders.getRequestHeader("User-agent").get(0);
		String language=httpHeaders.getRequestHeader("accept-language").get(0);
		model.setIpaddress(host);
		model.setLanguage(language);
		model.setSoftware(agent);
		return model;
    	
    }
}

package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sample.conf.ContextInject;
import com.sample.conf.CustomContext;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class RestResource {

  @ContextInject
  private CustomContext customContext;

  @GET
  @Path("custom-context")
  public String getResource(@Context CustomContext customContext) {
    return customContext == null ? "context is null" : customContext.getParam();
  }

  @GET
  @Path("custom-context-inject")
  public String getResourceInject() {
    return this.customContext == null ? "context is null" : this.customContext.getParam();
  }
}

package com.sample.conf;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

import org.glassfish.hk2.api.Factory;

public class ContextFactory implements Factory<CustomContext> {

  private final ContainerRequestContext context;

  @Inject
  public ContextFactory(ContainerRequestContext context) {
    this.context = context;
  }

  @Override
  public CustomContext provide() {
    CustomContext customContext = new CustomContext();
    Date date = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());
    customContext.setParam(context.getUriInfo().getPath() + "-" + date.toString());
    return customContext;
  }

  @Override
  public void dispose(CustomContext instance) {}
}

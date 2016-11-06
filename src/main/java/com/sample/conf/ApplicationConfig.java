package com.sample.conf;

import javax.inject.Singleton;

import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig extends ResourceConfig {

  public ApplicationConfig() {
    packages("com.sample.resources");
    register(JacksonFeature.class);
    register(JacksonContextResolver.class);
    register(new AbstractBinder() {
      @Override
      protected void configure() {
        bindFactory(ContextFactory.class).to(CustomContext.class);
        bind(ContextInjectResolver.class).to(new TypeLiteral<InjectionResolver<ContextInject>>() {})
            .in(Singleton.class);
      }
    });
  }
}

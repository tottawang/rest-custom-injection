package com.sample.conf;

import javax.inject.Inject;
import javax.inject.Named;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

public class ContextInjectResolver implements InjectionResolver<ContextInject> {

  @Inject
  @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
  InjectionResolver<Inject> systemInjectionResolver;

  @Override
  public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
    if (CustomContext.class == injectee.getRequiredType()) {
      return systemInjectionResolver.resolve(injectee, handle);
    }
    return null;
  }

  @Override
  public boolean isConstructorParameterIndicator() {
    return false;
  }

  @Override
  public boolean isMethodParameterIndicator() {
    return false;
  }


}

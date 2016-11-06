package com.sample.conf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomContext {

  @JsonProperty("param")
  private String param;

  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }
}

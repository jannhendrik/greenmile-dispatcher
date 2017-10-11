/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation;

public class ConfigRouteBuilder {


  private ConfigRoute configRoute;

  private ConfigRouteBuilder() {
    this.configRoute = new ConfigRoute();
  }

  public static ConfigRouteBuilder init() {
    return new ConfigRouteBuilder();
  }

  public ConfigRouteBuilder withPath(String path) {
    this.configRoute.setPath(path);
    return this;
  }

  public ConfigRouteBuilder withPort(String port) {
    this.configRoute.setPath(port);
    return this;
  }

  public ConfigRouteBuilder withUpstreamLocation(String upstreamLocation) {
    this.configRoute.setUpstreamLocation(upstreamLocation);
    return this;
  }

  public ConfigRouteBuilder withUpstreamPort(String port) {
    this.configRoute.setUpstreamPort(port);
    return this;
  }


  /*
  *
  *   private final String path;

  private final String port;

  private final String upstreamLocation;

  private final String upstreamPort;*/
  public ConfigRoute build() {
    return this.configRoute;
  }

}

/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation;

public class ConfigRoute {

  private String path;

  private String upstreamLocation;

  private String upstreamPort;

  private ConfigRoute() {
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUpstreamLocation() {
    return upstreamLocation;
  }

  public void setUpstreamLocation(String upstreamLocation) {
    this.upstreamLocation = upstreamLocation;
  }

  public String getUpstreamPort() {
    return upstreamPort;
  }

  public void setUpstreamPort(String upstreamPort) {
    this.upstreamPort = upstreamPort;
  }


  public static ConfigRoute of(String path, String upstreamLocation,
      String upstreamPort) {
    ConfigRoute configRoute = new ConfigRoute();

    configRoute.setPath(path);
    configRoute.setUpstreamLocation(upstreamLocation);
    configRoute.setUpstreamPort(upstreamPort);

    return configRoute;
  }
}

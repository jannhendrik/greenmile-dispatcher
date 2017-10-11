/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation;

public class ConfigRoute {

  private  String path;

  private  String port;

  private  String upstreamLocation;

  private  String upstreamPort;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
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
}

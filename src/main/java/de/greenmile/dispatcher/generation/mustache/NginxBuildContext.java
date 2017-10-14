/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 12.10.17.
*
*/

package de.greenmile.dispatcher.generation.mustache;

import java.util.List;

public class NginxBuildContext {

  private final List<String> domains;

  private final String certificateLocation;

  private final List<Upstream> upstreams;

  public NginxBuildContext(List<String> domains, String certificateLocation,
      List<Upstream> upstreams) {
    this.domains = domains;
    this.certificateLocation = certificateLocation;
    this.upstreams = upstreams;
  }

  public List<String> getDomains() {
    return domains;
  }

  public String getCertificateLocation() {
    return certificateLocation;
  }

  public List<Upstream> getUpstreams() {
    return upstreams;
  }

  @Override
  public String toString() {
    return "NginxBuildContext{" +
        "domains=" + domains +
        ", certificateLocation='" + certificateLocation + '\'' +
        ", upstreams=" + upstreams +
        '}';
  }
}

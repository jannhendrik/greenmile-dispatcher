/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 12.10.17.
*
*/

package de.greenmile.dispatcher.generation.mustache;

import com.google.common.base.Preconditions;
import de.greenmile.dispatcher.generation.ConfigParameter;
import de.greenmile.dispatcher.generation.ConfigRoute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NginxBuildContextBuilder {


  private NginxBuildContext nginxBuildContext;

  private List<String> domains = Arrays.asList("localhost");

  private String certificateLocation = "";

  private List<Upstream> upstreams = Collections.emptyList();

  private NginxBuildContextBuilder() {

  }

  public static NginxBuildContextBuilder init() {
    return new NginxBuildContextBuilder();
  }

  public NginxBuildContextBuilder withDomains(String... domains) {
    Preconditions.checkNotNull(domains);

    this.domains = Arrays.asList(domains);
    return this;
  }

  public NginxBuildContextBuilder withCertificateLocation(String certificateLocation) {
    Preconditions.checkNotNull(certificateLocation);

    this.certificateLocation = certificateLocation;
    return this;
  }

  public NginxBuildContextBuilder withUpstreams(Upstream... upstreams) {
    Preconditions.checkNotNull(upstreams);

    this.upstreams = Arrays.asList(upstreams);
    return this;
  }

  public NginxBuildContext build() {
    Preconditions.checkNotNull(domains);
    Preconditions.checkNotNull(certificateLocation);
    Preconditions.checkNotNull(upstreams);

    this.nginxBuildContext = new NginxBuildContext(domains, certificateLocation, upstreams);
    return this.nginxBuildContext;
  }


  public NginxBuildContextBuilder withConfigParameter(ConfigParameter configParameter) {
    Preconditions.checkNotNull(configParameter);
    Preconditions.checkArgument(configParameter.getDomains().size() > 0,
        "At least one domain must be given!");

    this.domains = configParameter.getDomains();

    final List<Upstream> upstreams = new ArrayList<>();
    configParameter.getConfigRoutes().forEach((route) -> {
      Upstream upstream = new Upstream(
          route.getUpstreamLocation() +":"+ route.getUpstreamPort(),
          route.getPath()
      );
      upstreams.add(upstream);
    });
    this.upstreams = upstreams;

    this.certificateLocation = domains.get(0);
    return this;
  }
}

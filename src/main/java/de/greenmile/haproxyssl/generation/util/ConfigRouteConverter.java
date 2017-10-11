/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation.util;

import com.beust.jcommander.IStringConverter;
import com.google.common.base.Preconditions;
import de.greenmile.haproxyssl.generation.ConfigRoute;
import de.greenmile.haproxyssl.generation.ConfigRouteBuilder;
import java.util.ArrayList;
import java.util.List;

public class ConfigRouteConverter implements IStringConverter<List<ConfigRoute>> {


  @Override
  public List<ConfigRoute> convert(String arg) {
    Preconditions.checkNotNull(arg, "Please routes config.");
    List<ConfigRoute> configRoutes = new ArrayList<>();

    String[] values = arg.split(";");

    for (String value : values) {
      String[] parts = value.split(">");
      String[] routePortAndRoute = this.extractValuesFromPart(parts[0]);
      String[] upstreamPortAndRoute = this.extractValuesFromPart(parts[1]);

      ConfigRoute configRoute = ConfigRouteBuilder.init().withPath(routePortAndRoute[0])
          .withPort(routePortAndRoute[1])
          .withUpstreamLocation(upstreamPortAndRoute[0]).withUpstreamPort(upstreamPortAndRoute[1])
          .build();

      configRoutes.add(configRoute);
    }

    if (configRoutes.size() == 0) {
      throw new IllegalArgumentException();
    }
    return configRoutes;


  }

  private String[] extractValuesFromPart(String part) {
    String[] portAndRoute = part.split(":");
    return portAndRoute;
  }
}

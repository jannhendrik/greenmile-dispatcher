/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation.util;

import com.beust.jcommander.IStringConverter;
import com.google.common.base.Preconditions;
import de.greenmile.dispatcher.generation.ConfigRoute;
import java.util.ArrayList;
import java.util.List;

public class ConfigRouteConverter implements IStringConverter<ConfigRoute> {


  @Override
  public ConfigRoute convert(String arg) {
    Preconditions.checkNotNull(arg, "Please routes config.");

    List<ConfigRoute> configRoutes = new ArrayList<>();

    if(arg.length() == 0) {
      throw new IllegalArgumentException("At least one route must be specified!");
    }

    String[] values = arg.split(";");

    if(values.length == 0) {
      throw new IllegalArgumentException("At least one route must be specified!");
    }

    ConfigRoute configRoute = null;

    for (String value : values) {
      String[] parts = value.split(">");
      String[] upstreamPortAndRoute = this.extractValuesFromPart(parts[1]);

       configRoute = ConfigRoute
          .of(
              parts[0],
              upstreamPortAndRoute[0],
              upstreamPortAndRoute[1]);
    }

    return configRoute;


  }

  private String[] extractValuesFromPart(String part) {
    String[] portAndRoute = part.split(":");
    return portAndRoute;
  }
}

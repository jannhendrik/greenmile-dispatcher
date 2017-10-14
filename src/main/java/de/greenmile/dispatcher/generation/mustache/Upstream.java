/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 12.10.17.
*
*/

package de.greenmile.dispatcher.generation.mustache;

public class Upstream {

  private final String target;

  private final String route;

  public Upstream(String target, String route) {
    this.target = target;
    this.route = route;
  }

  public String getTarget() {
    return target;
  }

  public String getRoute() {
    return route;
  }

  @Override
  public String toString() {
    return "Upstream{" +
        "target='" + target + '\'' +
        ", route='" + route + '\'' +
        '}';
  }
}

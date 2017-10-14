/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation;

import com.beust.jcommander.Parameter;
import de.greenmile.dispatcher.generation.util.ConfigRouteConverter;
import java.util.List;

public class ConfigParameter {

  @Parameter(names = {"--domains", "-d"}, echoInput = true, required = true)
  private List<String> domains;

  @Parameter(names = {"--routes", "-r"}, converter = ConfigRouteConverter.class )
  private List<ConfigRoute> configRoutes;

  @Parameter(names = {"--nginxTemplate", "-nt"})
  private String nginxConfigTemplate = "nginx-conf.mustache";


  @Parameter(names = {"--staging", "-s"}, required = false)
  private Boolean staging = false;

  @Parameter(names = {"--output", "-o"}, required = false)
  private String output = "nginx.conf";

  public List<String> getDomains() {
    return domains;
  }

  public void setDomains(List<String> domains) {
    this.domains = domains;
  }

  public String getNginxConfigTemplate() {
    return nginxConfigTemplate;
  }

  public void setNginxConfigTemplate(String nginxConfigTemplate) {
    this.nginxConfigTemplate = nginxConfigTemplate;
  }

  public List<ConfigRoute> getConfigRoutes() {
    return configRoutes;
  }

  public void setConfigRoutes(List<ConfigRoute> configRoutes) {
    this.configRoutes = configRoutes;
  }

  public Boolean getStaging() {
    return staging;
  }

  public void setStaging(Boolean staging) {
    this.staging = staging;
  }

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }
}

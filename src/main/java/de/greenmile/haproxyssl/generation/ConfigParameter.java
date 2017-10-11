/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation;

import com.beust.jcommander.Parameter;
import de.greenmile.haproxyssl.generation.util.FileConverter;
import java.io.File;
import java.util.List;

public class ConfigParameter {

  @Parameter(names = {"--domain", "-d"}, echoInput = true, required = true)
  private List<String> domain;

  @Parameter(names = {"--routes", "-r"})
  private List<ConfigRoute> configRoutes;

  @Parameter(names = {"--nginxTemplate", "--nt"}, converter = FileConverter.class)
  private File nginxConfigTemplate = new File("classpath:nginx-conf.mustache");

  @Parameter(names = {"--defaultRedirct", "-dr"})
  private String defaultRedirect;

  public List<String> getDomain() {
    return domain;
  }

  public void setDomain(List<String> domain) {
    this.domain = domain;
  }

  public File getNginxConfigTemplate() {
    return nginxConfigTemplate;
  }

  public void setNginxConfigTemplate(File nginxConfigTemplate) {
    this.nginxConfigTemplate = nginxConfigTemplate;
  }

  public List<ConfigRoute> getConfigRoutes() {
    return configRoutes;
  }

  public void setConfigRoutes(List<ConfigRoute> configRoutes) {
    this.configRoutes = configRoutes;
  }

  public String getDefaultRedirect() {
    return defaultRedirect;
  }

  public void setDefaultRedirect(String defaultRedirect) {
    this.defaultRedirect = defaultRedirect;
  }
}

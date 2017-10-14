/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import de.greenmile.dispatcher.generation.mustache.NginxBuildContext;
import de.greenmile.dispatcher.generation.mustache.NginxBuildContextBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigGenerator {

  private final ConfigParameter configParameter;

  /**
   * Default constructor
   */
  public ConfigGenerator(ConfigParameter configParameter) {
    this.configParameter = configParameter;
  }

  ///
  public void generate() throws IOException {
    NginxBuildContext nginxBuildContext = NginxBuildContextBuilder.init()
        .withConfigParameter(configParameter).build();

    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache mustache = mf.compile(configParameter.getNginxConfigTemplate());
    mustache.execute(new FileWriter(configParameter.getOutput()), nginxBuildContext).flush();

    System.out.print(nginxBuildContext.toString());

    Runtime rt = Runtime.getRuntime();
    //Process dhparam_pr = rt.exec(
        //"dhparam 2048 -out /dhparam/dhparam.pem");

    //Process pr = rt.exec(
    //    "certonly --standalone -d www.freightpilot.de -d www.freightpilot.eu --noninteractive --agree-tos --email jan.hendrik.telke@freightpilot.de --staging");

  }

  /// Getter + Setter

  public ConfigParameter getConfigParameter() {
    return configParameter;
  }
}

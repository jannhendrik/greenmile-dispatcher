/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation;

public class ConfigGenerator {

  private String outputDir;
  private ConfigParameter parameter;

  public ConfigGenerator() {
  }

  public void generate() {

  }

  public String getOutputDir() {
    return outputDir;
  }

  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }

  public ConfigParameter getParameter() {
    return parameter;
  }

  public void setParameter(ConfigParameter parameter) {
    this.parameter = parameter;
  }
}

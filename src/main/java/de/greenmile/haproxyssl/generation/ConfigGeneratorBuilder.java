/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.haproxyssl.generation;

/**
 * Generator to build ConfigGenerator
 */
public class ConfigGeneratorBuilder {

  private final ConfigGenerator configGenerator;

  private ConfigGeneratorBuilder() {
    this.configGenerator = new ConfigGenerator();
  }

  public static ConfigGeneratorBuilder init() {
    return new ConfigGeneratorBuilder();
  }

  public ConfigGeneratorBuilder withOutputDir(String outputDir) {
    this.configGenerator.setOutputDir(outputDir);
    return this;
  }

  public ConfigGeneratorBuilder withParameter(ConfigParameter parameter) {
    this.configGenerator.setParameter(parameter);
    return this;
  }

  public ConfigGenerator build() {
    return this.configGenerator;
  }
}

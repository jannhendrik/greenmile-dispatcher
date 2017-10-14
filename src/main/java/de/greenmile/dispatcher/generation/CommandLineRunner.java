/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation;

import com.beust.jcommander.JCommander;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;

public class CommandLineRunner {


  /**
   *
   * @param args
   */
  public static void main(String... args) throws IOException {
    ConfigParameter configParameter = CommandLineRunner.parseArgs(args);
    ConfigGenerator configGenerator = new ConfigGenerator(configParameter);

    configGenerator.generate();
  }


  /**
   *
   * @param args
   * @return
   */
  @VisibleForTesting
  public static ConfigParameter parseArgs(String... args) {
    ConfigParameter configParameter = new ConfigParameter();
    JCommander
        .newBuilder()
        .addObject(configParameter)
        .build()
        .parse(args);

    return configParameter;
  }
}

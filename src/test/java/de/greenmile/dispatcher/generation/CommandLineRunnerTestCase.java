package de.greenmile.dispatcher.generation;/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

import org.junit.Test;

public class CommandLineRunnerTestCase {

  @Test
  public void parseArgsTest_withExampleParams() {
    String[] exampleArgs = {" --domains","www.freightpilot.eu","--routes","/:>/landingserver:3000"};
    ConfigParameter configParameter = CommandLineRunner.parseArgs(exampleArgs);



  }

}

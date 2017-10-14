/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke
* on the 10.10.17.
*
*/
package de.greenmile.dispatcher.generation;

import java.io.IOException;
import org.junit.Test;

public class CommandLineRunnerAT {

  /**
   * Test website configuration
   */
  @Test
  public void mainTest_withLandingPageConfig() throws IOException {
    CommandLineRunner.main("--domains", "www.freightpilot.eu", "--routes", ">landingserver:3000");
  }

  /**
   *
   */
  @Test
  public void maintTest_withMaintConfig() throws IOException {
    CommandLineRunner.main( "--domains", "maint.freightpilot.eu",  "--routes", "maint>home:3002");
  }
}

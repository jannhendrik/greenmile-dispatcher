/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/

import de.greenmile.haproxyssl.generation.CommandLineRunner;
import org.junit.Test;

public class CommandLineRunnerAT {

  /**
   * Test website configuration
   */
  @Test
  public void mainTest_withLandingPageConfig() {
    CommandLineRunner.main("--domain", "www.freightpilot.eu", "--routes", "/:>/landingserver:3000");


  }

  /**
   *
   */
  @Test
  public void maintTest_withMaintConfig() {
    CommandLineRunner.main( "--domain", "maint.freightpilot.eu",  "--routes", "/maint /home");
  }
}

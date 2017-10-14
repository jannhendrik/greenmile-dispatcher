/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke
* on the 10.10.17.
*
*/

package de.greenmile.dispatcher.generation;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import de.greenmile.dispatcher.generation.util.ConfigRouteConverter;
import java.util.List;
import org.junit.Test;


public class ConfigRouteConverterTestCase {

  @Test
  public void convert_WithOneParam() {
    ConfigRouteConverterTestCase configRouteConverter = new ConfigRouteConverterTestCase();

    ConfigRoute result = new ConfigRouteConverter()
        .convert("/maint:80->/maintserver:3006");

    assert (result.getPath().equals("/maint"));
    assert (result.getUpstreamLocation().equals("/maintserver"));
    assert (result.getUpstreamPort().equals("3006"));

  }

  @Test
  public void convert_withMultiple_ShouldReturnCorrectResult() {
    ConfigRouteConverterTestCase configRouteConverter = new ConfigRouteConverterTestCase();

    ConfigRoute result= new ConfigRouteConverter()
        .convert("/maint:80->/maintserver:3006;/auth:443>/authserver:3007");



    assert (result.getPath().equals("/maint"));
    assert (result.getUpstreamLocation().equals("/maintserver"));
    assert (result.getUpstreamPort().equals("3006"));

  }

  @Test
  public void convert_withEmpty_shouldThrowIllegalArgumentException() {

    assertThatThrownBy(() -> new ConfigRouteConverter()
        .convert("")).isInstanceOf(IllegalArgumentException.class);

  }

  @Test
  public void convert_withNull_shouldThrowNullPointerException() {

    assertThatThrownBy(() -> new ConfigRouteConverter().convert(null)).isInstanceOf(
        NullPointerException.class);


  }


}

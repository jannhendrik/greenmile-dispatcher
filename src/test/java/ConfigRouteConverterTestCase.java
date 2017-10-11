/*
* Copyright (C) GreenMile UG, - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* Proprietary and confidential
* @author jan-hendriktelke 
* on the 10.10.17.
*
*/


import de.greenmile.haproxyssl.generation.ConfigRoute;
import de.greenmile.haproxyssl.generation.util.ConfigRouteConverter;
import java.util.List;
import org.junit.Test;


public class ConfigRouteConverterTestCase {

  @Test
  public void convert_WithOneParam() {
    ConfigRouteConverter configRouteConverter = new ConfigRouteConverter();

    List<ConfigRoute> configRoute = configRouteConverter.convert("/maint:80->/maintserver:3006");

    ConfigRoute result = configRoute.get(0);

    assert (result.getPath().equals("/maint"));
    assert (result.getPort().equals("80"));
    assert (result.getUpstreamLocation().equals("/maintserver"));
    assert (result.getUpstreamPort().equals("3006"));

  }

  @Test
  public void convert_withMultiple_ShouldReturnCorrectResult() {
    ConfigRouteConverter configRouteConverter = new ConfigRouteConverter();

    List<ConfigRoute> configRoute = configRouteConverter
        .convert("/maint:80->/maintserver:3006;/auth:443>/authserver:3007");

    ConfigRoute result = configRoute.get(0);

    assert (result.getPath().equals("/maint"));
    assert (result.getPort().equals("80"));
    assert (result.getUpstreamLocation().equals("/maintserver"));
    assert (result.getUpstreamPort().equals("3006"));

    ConfigRoute result2 = configRoute.get(0);

    assert (result2.getPath().equals("/auth"));
    assert (result2.getPort().equals("443"));
    assert (result2.getUpstreamLocation().equals("/authserver"));
    assert (result2.getUpstreamPort().equals("3007"));

  }

  @Test
  public void convert_withEmpty_shouldThrowIllegalArgumentException() {
    ConfigRouteConverter configRouteConverter = new ConfigRouteConverter();

    List<ConfigRoute> configRoute = configRouteConverter.convert("/maint:80>/maintserver:3006");

    //TODO assert exception

  }

  @Test
  public void convert_withNull_shouldThrowNullPointerException() {
    ConfigRouteConverter configRouteConverter = new ConfigRouteConverter();

    List<ConfigRoute> configRoute = configRouteConverter.convert(null);

    //TODO assert exception

  }


}

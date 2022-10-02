package features

import io.cucumber.core.options.Constants
// import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.*

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
class AcceptanceTest
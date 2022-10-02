package features

import io.cucumber.java8.En
import org.springframework.web.client.RestTemplate

class CalculatorSteps : En {
    private var a: Int = 0; private var b: Int = 0; private var sum: Int = 0
    private var restTemplate = RestTemplate()

    init {
        Given("I have to numbers: {int} and {int}") { a: Int, b: Int ->
            this.a = a
            this.b = b
        }

        When("the calculator sums them") {
            val calculatorUrl = System.getProperty("calculator.url")
            val url = String.format("%s/add?a=%d&b=%d", calculatorUrl, a, b)
            println(url)
            val result = restTemplate.getForObject(url, String::class.java)
            if (result != null) {
                sum = result.toInt()
            }
        }

        Then("I receive {int} as a result") { r: Int ->
            assert(sum == r)
        }
    }
}
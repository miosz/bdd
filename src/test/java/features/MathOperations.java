package features;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MathOperations {
    private int initial = 0;
    private List<Integer> numbers = new ArrayList<Integer>();

    @Given("^I have number (-?\\d+)$")
    public void initialNumber(int initial) {
        this.initial = initial;
    }

    @Given("^following numbers: (.*)$")
    public void followingNumbers(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    @Given("^following numbers:$")
    public void followingNumbersAsDt(DataTable dt) {
        this.numbers.addAll(dt.asList(Integer.class));
    }

    @Given("^number is (-?\\d+)$")
    public void getNumberOutline(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

//    @Given ("^following numbers:$")
//    public void followingNumbersAsCollections(List<Integer> numbers)
//    {
//        this.numbers.addAll(numbers);
//    }

    @When("^I subtract$")
    public void subtract() {
        for (Integer number : numbers) {
            this.initial -= number;
        }
    }

    @When("^I subtract (.*)$")
    public void subtractAnother() {
        for (Integer number : numbers) {
            this.initial -= number;
        }
    }

    @Then("^I get (-?\\d+)$")
    public void operationResult(int expected) {
        assertThat(initial, equalTo(expected));
    }

    @Then("^I get (-?\\d+) in result$")
    public void scenarioOutlineOperationResult(int expected) {
        assertThat(initial, equalTo(expected));
    }
}

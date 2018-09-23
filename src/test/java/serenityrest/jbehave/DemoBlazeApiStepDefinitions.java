package serenityrest.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
//import serenityrest.serenity.GeoApiSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import serenityrest.serenity.DemoBlazeApiActions;

public class DemoBlazeApiStepDefinitions {
    @Steps
    private DemoBlazeApiActions demoBlazeApiActions;


    @When("I have selected product $value")
    public void callApiForAddToCart(String value){
        demoBlazeApiActions.requestAddToCart(value);
    }

    @Then("I should get response status code $responseCode")
    public void thenAddToCartStatusCodeReceived(int responseCode) {
        demoBlazeApiActions.verifyAddToCartStatusCode(responseCode);
    }

    @Then("I should get response $response")
    public void thenAddToCartResponseReceived(String response)
    {
       assertThat("Wrong response from AddToCart", demoBlazeApiActions.verifyAddToCartResponse(),equalTo(response));
    }

    @When("I request delete item $productId")
    public void callApiForDeleteItem(String productId) {
        demoBlazeApiActions.requestDeleteItemFromCart(productId);
    }

    @Then("I should get response status code $responseCode from API")
    public void thenDeleteItemStatusCodeReceived(int responseCode){
              demoBlazeApiActions.verifyDeleteItemStatusCode(responseCode);
    }

    @Then("I should get this response $response")
    public void thenDeleteItemResponseReceived(String response){
       // assertThat("Wrong response status code", geoApiActions.getStatusCode() ,equalTo(expectedStatusCode));
        assertThat("Wrong response from DeleteItemAPI" ,demoBlazeApiActions.verifyDeleteItemResponse(),equalTo(response.replace("'","")));


    }

}

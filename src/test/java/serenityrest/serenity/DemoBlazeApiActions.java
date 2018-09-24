package serenityrest.serenity;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class DemoBlazeApiActions {
    @Step
    public void requestAddToCart(String value){
        SerenityRest.given().contentType("application/json").and().body(value).when().post("https://api.demoblaze.com/addtocart");//http://localhost:3000/addtocart
    }

    @Step
    public void requestDeleteItemFromCart(String value){
        SerenityRest.given().contentType("application/json").and().body(value).when().post("https://api.demoblaze.com/deleteitem");//"http://localhost:3000/deleteitem");
    }

    @Step
    public void verifyAddToCartStatusCode(int responseCode){
        SerenityRest.then().log().all().statusCode(responseCode);
    }

    @Step
    public void verifyDeleteItemStatusCode(int responseCode){
        SerenityRest.then().log().all().statusCode(responseCode);
    }

    @Step
    public String verifyAddToCartResponse(){
       return SerenityRest.then().extract().body().asString();
    }

    @Step
    public String verifyDeleteItemResponse(){
       return SerenityRest.then().extract().body().jsonPath().get("errorMessage");
    }
}

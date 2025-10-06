package stepDef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPage;

import java.util.Map;

import static helper.Utility.driver;

public class WebStepdef {

    WebPage webPage;

    public WebStepdef() {
        this.webPage = new WebPage();
    }

    @Given("open web demoblaze")
    public void openWebDemoblaze() {
        webPage.openBrowser();
    }

//  Phone

    @And("user go to phone section")
    public void userGoToPhoneSection() {
        webPage.setPhone_section();
    }

    @And("user select phone")
    public void userSelectPhone() {
        webPage.setSelectPhone();
    }

    @And("user go to cart page")
    public void userGoToCartPage() {
        webPage.goToCart();
    }

    @And("add phone to cart")
    public void addPhoneToCart() {
        webPage.checkOutPhone();
    }

    //  Laptop
    @And("user go to laptop section")
    public void userGoToLaptopSection() {
        webPage.setLaptop_section();
    }

    @And("user select laptop")
    public void userSelectLaptop() {
        webPage.setSelectLaptop();
    }

    @And("add laptop to cart")
    public void addLaptopToCart() {
        webPage.setAddLaptopToCart();
    }

    //  Monitor
    @And("user go to monitor section")
    public void userGoToMonitorSection() {
        webPage.setMonitor_section();
    }

    @And("user select monitor")
    public void userSelectMonitor() {
        webPage.setSelectMonitor();
    }

    @And("add monitor to cart")
    public void addMonitorToCart() {
        webPage.setAddMonitorToCart();
    }

//  Checkout
    @And("user place order from cart")
    public void userPlaceOrderFromCart() {
        webPage.setPlaceOrder();
    }

    @And("user input data:")
    public void userInputData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        webPage.fillOrderForm(
                data.get("name"),
                data.get("country"),
                data.get("city"),
                data.get("card"),
                data.get("month"),
                data.get("year")
        );
    }

    @And("user click purchase")
    public void userClickPurchase() {
        webPage.setBtn_purchase();
    }

    @And("user will see successful message {string}")
    public void userWillSeeSuccessfulMessage(String arg0) {
        webPage.setSuccessfulmsg();
    }

    @Then("verify total price is {string}")
    public void verifyTotalPriceIs(String expectedPrice) {
        webPage.verifyTotalPrice(expectedPrice);
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.Utility.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebPage {

    By phone_section = By.xpath("(//a[normalize-space()='Phones'])[1]");
    By laptop_section = By.xpath("(//a[normalize-space()='Laptops'])[1]");
    By monitor_section = By.xpath("(//a[normalize-space()='Monitors'])[1]");
    By selectPhone = By.xpath("(//a[normalize-space()='Samsung galaxy s6'])[1]");
    By selectLaptop = By.xpath("(//a[normalize-space()='Sony vaio i5'])[1]");
    By selectMonitor = By.xpath("(//a[normalize-space()='Apple monitor 24'])[1]");
    By addPhoneToCart = By.xpath("(//a[normalize-space()='Add to cart'])[1]");
    By addLaptopToCart = By.xpath("(//a[normalize-space()='Add to cart'])[1]");
    By addMonitorToCart = By.xpath("(//a[normalize-space()='Add to cart'])[1]");
    By placeOrder = By.xpath("(//button[normalize-space()='Place Order'])[1]");
    By cartNavbar = By.xpath("(//a[normalize-space()='Cart'])[1]");
    By totalPrice = By.id("(//h3[normalize-space()='1080'])[1]");
    By input_name = By.id("name");
    By input_country = By.id("country");
    By input_city = By.id("city");
    By input_creditCard = By.id("card");
    By input_month = By.id("month");
    By input_year = By.id("year");
    By btn_purchase = By.xpath("(//button[normalize-space()='Purchase'])[1]");
    By successfulmsg = By.xpath("(//h2[normalize-space()='Thank you for your purchase!'])[1]");


    public void openBrowser() {
        driver.get("https://www.demoblaze.com/index.html");
    }

//  Checkout Phone
    public void setPhone_section() {
        driver.findElement(phone_section).click();
    }

    public void setSelectPhone() {
        driver.findElement(selectPhone).click();
    }

    public void checkOutPhone() {
        driver.findElement(addPhoneToCart).click();
    }

//    Checkout Laptop
    public void setLaptop_section() {
        driver.findElement(laptop_section).click();
    }

    public void setSelectLaptop() {
        driver.findElement(selectLaptop).click();
    }

    public void setAddLaptopToCart() {
        driver.findElement(addLaptopToCart).click();
    }

//    Checkout Monitor
    public void setMonitor_section(){
        driver.findElement(monitor_section).click();
    }

    public void setSelectMonitor(){
        driver.findElement(selectMonitor).click();
    }

    public void setAddMonitorToCart(){
        driver.findElement(addMonitorToCart).click();
    }


//    public void assertErrMsg(String errmsg){
//        driver.findElement(text_err_msg(errmsg)).isDisplayed();
//    }

    public void fillOrderForm(String name, String country, String city,
                              String card, String month, String year) {
        driver.findElement(input_name).sendKeys(name);
        driver.findElement(input_country).sendKeys(country);
        driver.findElement(input_city).sendKeys(city);
        driver.findElement(input_creditCard).sendKeys(card);
        driver.findElement(input_month).sendKeys(month);
        driver.findElement(input_year).sendKeys(year);
    }

    public void goToCart() {
        driver.findElement(cartNavbar).click();
    }

    public void setPlaceOrder(){
        driver.findElement(placeOrder).click();
    }

    public void setBtn_purchase() {
        driver.findElement(btn_purchase).click();
    }

    public void setSuccessfulmsg() {
        driver.findElement(successfulmsg).isDisplayed();
    }

    public void verifyTotalPrice(String expectedPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualPrice = driver.findElement(totalPrice).getText();
        assertThat(actualPrice)
                .as("Expected total price: " + expectedPrice + " but was: " + actualPrice)
                .isEqualTo(expectedPrice);
    }

}

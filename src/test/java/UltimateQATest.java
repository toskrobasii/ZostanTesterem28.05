import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

// slowko kluczowe static
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//klasa
// kompozycja klas > dziedziczenia
public class UltimateQATest extends PageSetup {

    //metody (funkcje)
    // zwracanie wartosci funkcji - m.in. void
    @Test
    public void testOne() {
        // Page Object Model / Page Object Pattern
        WebElement buttonUsingId = driver.findElementById("idExample");
        buttonUsingId.click();
        //driver.findElementById("idExample").click();

        WebElement buttonSuccessText = driver.findElementByClassName("entry-title");
        // overloading
        assertEquals("Button success", buttonSuccessText.getText());
    }

    //obsluga wyjatkow
    @Test
    public void testTwo() throws InterruptedException {
        WebElement nameTextField = driver.findElementByName("et_pb_contact_name_0");
        nameTextField.sendKeys("Tester");

        WebElement emailTextField = driver.findElementByName("et_pb_contact_email_0");
        emailTextField.sendKeys("tester@tester.com");

        // rodzaje waitow w Selenium: Implicit wait, explicit wait, fluent wait
        Thread.sleep(3000);

        WebElement emailMeButton = driver.findElementByName("et_builder_submit_button");
        emailMeButton.click();

        Thread.sleep(3000);

        WebElement thanksText = driver.findElementByClassName("et-pb-contact-message");
        assertEquals("Thanks for contacting us", thanksText.getText());
    }

    @Test
    public void testThree() {
        //     //*[@class='...'] - ogolna postac xpath
        //     //*[@class='...' and @id='...']//*[@id='']
        //     //*[contains(@class, '...')]
        //     //*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]
        //     //div[@class='navbar-header']//img[@alt='Nasa']
        //     //*[text()='MORE STORIES']
        //     / - jeden poziom nizej
        //     // - dwa lub wiecej poziomow nizej

        WebElement blueField = driver.findElementByXPath("//*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]");
        // zmiana koloru HEX na RGBA
        assertEquals("rgba(46, 163, 242, 1)", blueField.getCssValue("background-color"));
    }

    @Test
    public void testFour() {
        WebElement bikeCheckbox = driver.findElementByXPath("//*[@type='checkbox' and @value='Bike']");
        bikeCheckbox.click();
        assertTrue(bikeCheckbox.isSelected());
    }

    @Test
    public void testFive() {

        // typy kolekcji w Java: ArrayList, Map, HashList
        List<String> listOfCars = new ArrayList<>();
        listOfCars.add("Volvo");
        listOfCars.add("Saab");
        listOfCars.add("Opel");
        listOfCars.add("Audi");

        //typy petli w Java
        for (int i = 0; i < listOfCars.size(); i++) {
            WebElement dropdownOption = driver.findElementByXPath("//*[@value='" + listOfCars.get(i).toLowerCase() + "']");
            dropdownOption.click();
            assertTrue(dropdownOption.isSelected());
        }

//        for (String listOfCar : listOfCars) {
//            WebElement dropdownOption = driver.findElementByXPath("//*[@value='" + listOfCar.toLowerCase() + "']");
//            dropdownOption.click();
//            assertTrue(dropdownOption.isSelected());
//        }

        // Java stream od wersji 8
    }

    @Test
    public void testSix() {
        WebElement buttonUsingXpath1 = driver.findElementByXPath("//span[text()='XPath tutorial for automation testers']" +
                "/ancestor::h4/following-sibling::div//button");
        buttonUsingXpath1.click();

        WebElement buttonSuccessText = driver.findElementByClassName("entry-title");
        // overloading
        assertEquals("Button success", buttonSuccessText.getText());
    }
}

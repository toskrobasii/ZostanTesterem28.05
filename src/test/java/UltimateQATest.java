import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

// slowko kluczowe static
import static org.junit.jupiter.api.Assertions.assertEquals;


//klasa
// kompozycja klas > dziedziczenia
public class UltimateQATest extends PageSetup {

    //metody (funkcje)
    // zwracanie wartosci funkcji - m.in. void
    @Test
    public void testOne() {
        WebElement buttonUsingId = driver.findElementById("idExample");
        buttonUsingId.click();
        //driver.findElementById("idExample").click();

        WebElement buttonSuccessText = driver.findElementByClassName("entry-title");
        // overloading
        assertEquals("Button success", buttonSuccessText.getText());
    }

}

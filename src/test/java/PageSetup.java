import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSetup {

    // slowko kluczowe w Java: final
    // typy proste (mala litera) vs typy obiektowe (wielka litera)

    // pola, zmienne
    // modyfikatory dostepu: public / private / protected / (default)
    // interface / abstract class
    // getter / setter
    String projectLocation = System.getProperty("user.dir");
    ChromeDriver driver;

    // testy zalezne test dependsOn, group {} - TestNG
    // ustawianie chrome do bloku @BeforeAll, a w @BeforeEach tylko driver.get() - przechodzenie na link
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", projectLocation + "/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    @AfterEach
    public void teardown() {
        // driver.close() a driver.quit()
//        driver.close();
    }



}

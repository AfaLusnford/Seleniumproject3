import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class project3 {





        public static void main(String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "/Users/afaggadimova/Desktop/untitled folder/driver/chromedriver");


            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            driver.get("https://www.cars.com/");

            Select select = new Select(driver.findElement(By.id("make-model-search-stocktype")));

            Assert.assertEquals(select.getFirstSelectedOption().getText(), "New & used cars");

            Thread.sleep(1000);

            Select select1 = new Select(driver.findElement(By.id("makes")));

            Assert.assertEquals(select1.getFirstSelectedOption().getText(), "All makes");

            Thread.sleep(1000);

            Select select2 = new Select(driver.findElement(By.id("models")));

            Assert.assertEquals(select2.getFirstSelectedOption().getText(), "All models");

            Select select3 = new Select(driver.findElement(By.id("make-model-max-price")));

            Assert.assertEquals(select3.getFirstSelectedOption().getText(), "No max price");

            Select select4 = new Select(driver.findElement(By.id("make-model-maximum-distance")));

            Assert.assertEquals(select4.getFirstSelectedOption().getText(), "20 miles");

            String[] expected = {"New & used cars", "New & certified cars", "New cars", "Used cars", "Certified cars"};

            List<WebElement> options = select.getOptions();


            for (int i = 0; i < options.size(); i++) {
                Assert.assertEquals(options.get(i).getText(), expected[i]);

            }


            Thread.sleep(1000);
            select.selectByIndex(3);

            List<WebElement> options1 = select1.getOptions();
            List<String> allmakes = new ArrayList<>();

            for (WebElement option : options1) {
                allmakes.add(option.getText());
            }

            select1.selectByVisibleText("Tesla");

            String[] expectedmodels = {"All models", "Model 3", "Model S", "Model X", "Model Y", "Roadster"};

            List<WebElement> options2 = select2.getOptions();


            for (int i = 0; i < options2.size(); i++) {

                Assert.assertEquals(options2.get(i).getText(), expectedmodels[i]);
            }
//
            select2.selectByIndex(2);


            List<WebElement> options3 = select3.getOptions();
            List<String> allprices = new ArrayList<>();

            for (WebElement option : options3) {
                allprices.add(option.getText());
            }

            select3.selectByVisibleText("$100,000");


            List<WebElement> options4 = select4.getOptions();
            List<String> alldistance = new ArrayList<>();

            for (WebElement option : options4) {
                alldistance.add(option.getText());
            }

            select4.selectByVisibleText("50 miles");


            driver.findElement(By.id("make-model-zip")).clear();
            driver.findElement(By.id("make-model-zip")).sendKeys("22182");

            driver.findElement(By.xpath("//button[@data-linkname='search-used-make']")).click();



            List<WebElement> element = driver.findElements(By.xpath("//div[@class='vehicle-card']"));

            for (int i = 0; i < element.size(); i++) ;

            if (element.size() == 20) {
                System.out.println("yes");
            }


            Thread.sleep(1000);


            WebElement element1 = driver.findElement(By.id("sort-dropdown"));
            Select sortby = new Select(element1);
            sortby.selectByValue("list_price");

            Thread.sleep(6000);
            List<WebElement> elements = driver.findElements(By.xpath("//span[@class='primary-price']"));
            if (elements.isEmpty()) {
                throw new RuntimeException();
            }
            for (WebElement count : elements) {
                double num = 0.0;
                Assert.assertTrue(Double.parseDouble(count.getText().replaceAll("[$,]", "")) > num);
                num = Double.parseDouble(count.getText().replaceAll("[$,]", ""));
                System.out.println(num);
            }

            sortby.selectByValue("mileage_desc");


            Thread.sleep(6000);
            List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='mileage'][contains(text(),' mi.')]"));
            if (elements1.isEmpty()) {
                throw new RuntimeException();
            }

            for (WebElement webElement : elements1) {
                long hello1 = 1000000000;
                Assert.assertTrue(Long.parseLong(webElement.getText().replaceAll("[$,mi. ]", "")) < hello1);
                hello1 = (Long.parseLong(webElement.getText().replaceAll("[$,mi. ]", "")));
                System.out.println(hello1);
            }

            sortby.selectByValue("distance");

            List<WebElement> far = driver.findElements(By.xpath("//div[@data-qa='miles-from-user']"));
            if (far.isEmpty()) {
                throw new RuntimeException();
            }

            for (WebElement webElement : far) {
                int hello1 = 0;
                Assert.assertTrue(Integer.parseInt(webElement.getText().substring(0, 4).replaceAll("[$,mi. ]", "")) > hello1);
                hello1 = (Integer.parseInt(webElement.getText().substring(0, 4).replaceAll("[$,mi. ]", "")));
                System.out.println(hello1);
            }
            sortby.selectByValue("year");

            Thread.sleep(6000);
            List<WebElement> year = driver.findElements(By.xpath("//h2[@class='title'] "));
            if (far.isEmpty()) {
                throw new RuntimeException();
            }

            for (WebElement webElement : year) {
                int hello1 = 0;
                if (Integer.parseInt(webElement.getText().substring(0, 5).replaceAll("[$,mi. ]", "")) > hello1){

                    hello1 = (Integer.parseInt(webElement.getText().substring(0, 5).replaceAll("[$,mi. ]", "")));
                    System.out.println(hello1);
                }else {throw new RuntimeException();}

            }driver.quit();

        }}













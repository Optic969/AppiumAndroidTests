import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import setUp.SetUp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class AppiumTests extends SetUp  {

    static AndroidDriver<AndroidElement> driver;

    {
        try {
            driver = Capabilities("real");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setupTest() throws MalformedURLException {

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //@AfterClass
    public void teardown() {

    }

    @Test
    public void PreferenceRun() {

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");//Send a data to element with possibility a get input data
        driver.findElementsByClassName("android.widget.Button").get(1).click();//Select a element inside class with use a index
    }
    @Test
    public void DragDrop() {

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        TouchAction action = new TouchAction(driver);
        WebElement source=driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination=driver.findElementsByClassName("android.view.View").get(1);
        action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();

    }
    @Test
    public void TapLongTap() {

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        TouchAction touchAction = new  TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        touchAction.tap(tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        touchAction.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }

}

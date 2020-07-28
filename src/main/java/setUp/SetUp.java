package setUp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SetUp {
    public static  AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException
    {


        AndroidDriver<AndroidElement>  driver;

        // TODO Auto-generated method stub
        File appDir = new File("src");
        File app = new File(appDir, "original.apk");
        //File app = new File(appDir, "com.btsshow.apk" );//Alternative way to install testing app
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3098b88a0205");//emulator-5554
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        if (device.equals("emulator")){
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        }
        else if (device.equals("real")){
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3098b88a0205");
        }

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.2");//"9.0"
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        /**AndroidUIAutomator**/

        //((FindsByAndroidUIAutomator<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();


        return driver;
    }
}

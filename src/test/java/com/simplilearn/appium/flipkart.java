package com.simplilearn.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class flipkart {

  private AndroidDriver driver;

  @BeforeMethod
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "11");
    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
    desiredCapabilities.setCapability("appium:app", "C:\\Users\\shaza\\Downloads\\Flipkart-7.18.apk");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
  }

  @Test
  public void sampleTest() throws InterruptedException {
    MobileElement engRadBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.ImageView[1]");
    engRadBtn.click();
    System.out.println("English Language option is selected.");
    Thread.sleep(3000);
    MobileElement contBtn = (MobileElement) driver.findElementById("com.flipkart.android:id/select_btn");
    contBtn.click();
    System.out.println("Flipkart launched in English Interface.");
    Thread.sleep(3000);
    cancelOperation();    
    Thread.sleep(3000);
    MobileElement searchField = (MobileElement) driver.findElementById("com.flipkart.android:id/search_widget_textbox");
    searchField.click();
    System.out.println("Click on Search Field");
    Thread.sleep(3000);
    MobileElement searchText = (MobileElement) driver.findElementByAccessibilityId("Search grocery products");
    searchText.sendKeys("boat smart watch");
    searchText.click();
    System.out.println("Click on the option provided by the search text.");
    Thread.sleep(3000);
    MobileElement listIems = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
    listIems.click();
    System.out.println("Search Result is displayed for the entered text.");
    Thread.sleep(3000);
    allowLocationAccess();
    
    @SuppressWarnings("unchecked")
	List<WebElement> selectItemLink =  driver.findElements(By.xpath("//*[contains(@text,'boAt Wave Connect with Bluetooth Calling')]"));
    for(WebElement link: selectItemLink){
        System.out.println(link.getText());
        link.click();
        break;
    }
    
    System.out.println("Item details is displayed with all the information.");
    Thread.sleep(2000);
    MobileElement addToCartBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
    addToCartBtn.click();
    System.out.println("Item is added to the cart and button name is chnaged to Go to Cart.");
    Thread.sleep(2000);
    MobileElement goToCartBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
    goToCartBtn.click();
    System.out.println("Cart is diaplyed with the added item.");
    Thread.sleep(2000);
    MobileElement placeOrderBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    placeOrderBtn.click();
    System.out.println("Register flipkart screen is displayed since the account is not registered.");
    Thread.sleep(2000);
    cancelOperation();    
  }
  
  public void cancelOperation() {
	  MobileElement cancelBtn = (MobileElement) driver.findElementById("com.flipkart.android:id/custom_back_icon");
	  cancelBtn.click();
	  System.out.println("Register with MobileNo or Email ID screen is cancelled.");
  }
  
  public void allowLocationAccess() throws InterruptedException {
	  MobileElement allowLocationBtn = (MobileElement) driver.findElementById("com.flipkart.android:id/allow_button");
	    allowLocationBtn.click();
	    System.out.println("Allow location dialog pop-up is displayed.");
	    Thread.sleep(2000);
	    MobileElement allowOneTimeBtn = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button");
	    allowOneTimeBtn.click();
	    System.out.println("Allow location dialog window is closd and the result list is displayed.");
	    Thread.sleep(2000);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

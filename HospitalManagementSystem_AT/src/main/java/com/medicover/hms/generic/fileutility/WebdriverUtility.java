package com.medicover.hms.generic.fileutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	WebDriver driver;
public void toWaitLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
}

public void toMaximize(WebDriver driver) {
	driver.manage().window().maximize();
}
public void toMinimize(WebDriver driver) {
	driver.manage().window().minimize();
}
public void toExplicitWait(WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void toSwitchWindow() {
	Set<String> allwin = driver.getWindowHandles();
	for(String win:allwin) {
		driver.switchTo().window(win);
		if(driver.getCurrentUrl().contains(win)) {  //if(driver.getTitle().contains(win))
			break;
		}
	}
}
public void selectByValue(WebElement element,String value1) {
	Select select=new Select(element);
	select.selectByValue(value1);
}
public void selectByIndex(WebElement element,int index) {
	Select select=new Select(element);
	select.selectByIndex(index);
}
public void selectByVisibleText(WebElement element,String text) {
	Select select=new Select(element);
	select.selectByVisibleText(text);
}
public void selectAllOption(WebElement element) {
	Select select=new Select(element);
	select.getOptions();
	
}
public void getFirstSelectedOption(WebElement element) {
	Select select=new Select(element);
	select.getFirstSelectedOption();
}
public void clickElementJavaExecutor(WebDriver driver,  WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",element);
}
public void scrollElementJavaExecutor(WebDriver driver,  WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scroll",element);
}
}

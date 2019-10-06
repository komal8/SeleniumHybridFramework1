package com.visionIT.FreeCrm.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper1 {
	public static void selectValueFromDD(WebElement ddEle, String ddValue)
	{
		Select sel =new Select(ddEle);
		
		sel.selectByVisibleText(ddValue);
	}
	
public static String captureScreenShots(WebDriver driver){
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotsPath=System.getProperty("user.dir")+"//Screenshot1//FreeCrm_"+getCurrentDataTime()+".png";
	
		try {
			FileHandler.copy(srcFile, new File(screenshotsPath));
			
			System.out.println("screenshots captured");
			
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshots"+e.getMessage());
		}
		
		return screenshotsPath;
	}
	
	
		public static String getCurrentDataTime(){
			
			DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			
			Date currentDate=new Date();
			
			return customFormat.format(currentDate);
	
}

	
}




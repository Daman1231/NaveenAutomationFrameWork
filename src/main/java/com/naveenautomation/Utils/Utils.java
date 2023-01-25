package com.naveenautomation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomation.Base.TestBase;

public class Utils extends TestBase {

	public static void randomInteger(int length) {
		Random random = new Random();
		random.nextInt(length);
	}

	public static String randomString(int length) {
		return RandomStringUtils.random(length);
	}

	public static String getRandomEmail() {
		String randomEmail = RandomStringUtils.random(5);
		return "testemial" + randomEmail + "@gmail.com";
	}

	public static String getRandomPassword() {
		return "Password" + new Random().nextInt(2);
	}

	public static Date getCurrentTime() {
		return new Date();
	}

	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenShot(String testName) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) local.get()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotFile, new File("./FailedScreenShots\\" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

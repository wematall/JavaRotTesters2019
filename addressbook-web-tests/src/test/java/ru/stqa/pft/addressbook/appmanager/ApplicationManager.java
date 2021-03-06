package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

	WebDriver wd;

	public ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;
	private SessionHelper sessionHelper;
	private String browser;

	public ApplicationManager(String browser) {
		this.browser = browser;
	}

	public void init() {

		if (browser.equals(BrowserType.FIREFOX)) {
			wd = new FirefoxDriver();
		}
		else if (browser.equals(BrowserType.CHROME)) {
			wd = new ChromeDriver();
		}
		else if (browser.equals(BrowserType.IE)) {
			wd = new InternetExplorerDriver();
		}

		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wd.get("http://192.168.63.138/addressbook/group.php");

		contactHelper = new ContactHelper(wd);
		groupHelper = new GroupHelper(wd);
		navigationHelper = new NavigationHelper(wd);
		sessionHelper = new SessionHelper(wd);

		sessionHelper.login("admin", "secret");

	}

	public void stop() {
		sessionHelper.logout();
		wd.quit();
	}


	public GroupHelper group () {
		return groupHelper;
	}


	public ContactHelper contact () {
		return contactHelper;
	}

	public NavigationHelper goTo() {
		return navigationHelper;
	}

	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}


}

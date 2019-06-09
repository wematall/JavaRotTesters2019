package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper (FirefoxDriver wd) {
		super(wd);
	}


	public void submitContactForm() {
		click(By.xpath("(//input[@name='submit'])[2]"));
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData) {
		type(By.name("firstname"), contactData.getFirstName());
		type(By.name("middlename"), contactData.getMiddleName());
		type(By.name("lastname"), contactData.getLastName());
		type(By.name("nickname"), contactData.getNickName());
		type(By.name("title"), contactData.getTitle());
		type(By.name("company"), contactData.getCompanyName());
		type(By.name("address"), contactData.getAddress());
		type(By.name("home"), contactData.getPhoneHome());
		type(By.name("mobile"), contactData.getPhoneMobile());
		type(By.name("work"), contactData.getPhoneWork());
		type(By.name("fax"), contactData.getFax());
		type(By.name("email"), contactData.getEmail());
		type(By.name("email2"), contactData.getEmail2());
		type(By.name("email3"), contactData.getEmail3());
		type(By.name("homepage"), contactData.getWebPage());

		//пока не знаю что с этим делать
		//по идее нужно создание этих объектов
		//перенести в другое место
		new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
		wd.findElement(By.name("bday")).click();

		new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
		wd.findElement(By.name("bmonth")).click();

		type(By.name("byear"), contactData.getBirthYear());

		new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnnyversaryDay());
		wd.findElement(By.name("aday")).click();

		new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnnyversaryMonth());
		wd.findElement(By.name("amonth")).click();

		type(By.name("ayear"), contactData.getAnnyversaryYear());
		type(By.name("address2"), contactData.getAddress2());
		type(By.name("phone2"), contactData.getPhoneHome2());
		type(By.name("notes"), contactData.getNotes());

	}
}

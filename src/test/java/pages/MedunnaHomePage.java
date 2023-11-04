package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaHomePage {
    public MedunnaHomePage(){
        PageFactory.initElements(
                Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@aria-expanded='false']")
    public WebElement userIcon;
    @FindBy(id = "login-item")
    public WebElement signInOption;

    @FindBy(id = "entity-menu")
    public WebElement itemsdAndTitles;

    @FindBy(linkText = "Room")
    public WebElement roomOption;

}

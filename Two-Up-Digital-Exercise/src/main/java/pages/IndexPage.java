package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends MainPage {

    @FindBy(css = "[id^='ubermenu-main'] [href$='/football']")
    private WebElement tabFootball;

    @FindBy(css = "[href$='/premier-league']")
    private WebElement linkPremierLeague;

    public IndexPage(WebDriver driver, WebDriverWait wait, String url) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public IndexPage openIndexPage() {
        driver.get(url);
        waitForJStoLoad();
        return this;
    }

    public IndexPage hoverTabFootball() {
        //Actions hoverMouse = new Actions(driver);
        //hoverMouse.moveToElement(tabFootball).build().perform();
        hoverOverWebelement(tabFootball);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;

    }

    public PremierLeaguePage clickPremierLeague() {
        //linkPremierLeague.click();
        waitForWebelementToBeClickableAndClick(linkPremierLeague);
        return new PremierLeaguePage(driver, wait);
    }

}

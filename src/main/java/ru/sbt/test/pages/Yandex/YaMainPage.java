package ru.sbt.test.pages.Yandex;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

@PageEntry(title = "Яндекс", url = "https://www.yandex.ru")
public class YaMainPage extends Page {

    //@ElementTitle("Ссылка на Яндекс Маркет")
    @FindBy(xpath = ".//a[@data-id='market']")
    private Link yandexMarket;

    public YaMainPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())),this);
        PageFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @ActionTitle("переходит в")
    public void navigate_to(String dest){
        switch (dest){
            case "Яндекс Маркет":
                WebDriverWait wait = new WebDriverWait(PageFactory.getWebDriver(), 10);
                wait.until(ExpectedConditions.visibilityOf(yandexMarket));
                yandexMarket.click();
                break;
            default:
                Assert.fail(dest +  " не определено");
                break;
        }
    }
}

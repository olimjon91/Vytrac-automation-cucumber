package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class NavigationMenu {
    public NavigationMenu() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='pagination pagination-centered']/label[3]")
    public WebElement totalOfRecords;

    @FindBy(xpath = "(//div[@class='pull-left'])[1]")
    public WebElement pageName;

    public void navigateTo(String module_page){
        String[] args = module_page.split(",\\s");
        Actions actions = new Actions(Driver.get());
        List<WebElement> elements = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.xpath("//a[@href='#']//span[contains(text(),'"+args[0]+"')]"))));
        try {
            elements.add(Driver.get().findElement(By.xpath("//a[@href='#']//span[contains(text(),'"+args[0]+"')]")));
            elements.add(Driver.get().findElement(By.xpath("//span[@class='title title-level-2'][.='"+args[1]+"']")));
            elements.add(Driver.get().findElement(By.xpath("//span[@class='title title-level-3'][.='"+args[2]+"']")));
            elements.add(Driver.get().findElement(By.xpath("//span[@class='title title-level-4'][.='"+args[3]+"']")));
        }catch (Exception e ){}

        for (int i = 0; i < elements.size(); i++ ){
            BrowserUtils.waitFor(1);
            if(i==elements.size()-1) elements.get(i).click();
            else actions.moveToElement(elements.get(i)).perform();
        }
    }

}

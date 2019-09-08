package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase {
  @Test
  public void testBoardCreation() throws InterruptedException {
      int before= getBoardSize();
    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm("qa21", "descr qa 21");
    confirmBoardCreation();
      backToHomePage();
      int after= getBoardSize();
Assert.assertEquals(after,before+1);
  }

    public void backToHomePage() throws InterruptedException {
      Thread.sleep(10000);
        click(By.cssSelector("a[href='/']"));
        Thread.sleep(5000);
        click(By.cssSelector("a[href='/']"));
    }

    public int getBoardSize() {
      return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

}

package page

import org.openqa.selenium.By.xpath
import org.openqa.selenium.{By, WebDriver}

class SortPanel(private var driver: WebDriver) {
  private val sort: By = xpath("//*[contains(@class,'select-css ng-untouched ng-pristine ng-valid ng-star-inserted')]")
  private val fromLowerToBiggerOption: By = xpath("//option[@value='1: cheap']")

  def clickOnSortPanel(): Unit = {
    driver.findElement(sort).click()
  }

  def clickOnOptionFromLowerToBigger(): Unit ={
   driver.findElement(fromLowerToBiggerOption).click()
  }

}

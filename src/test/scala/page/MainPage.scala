package page

import org.openqa.selenium.{By, Keys, WebDriver}

class MainPage(private var driver: WebDriver) {

  private val search: By = By.name("search")
  private val icon: By = By.xpath("//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
  private val product: By = By.className("tile__picture")
  private val categoryLink: By = By.xpath("(//a[@href='https://rozetka.com.ua/computers-notebooks/c80253/'])[2]")
  private val comparisonIcon: By = By.xpath("//*[@class='compare-button ng-star-inserted']")

  def searchFor(searchTerm: String): Unit = {
    driver.findElement(search).sendKeys(searchTerm + Keys.RETURN)
  }

  def clickOnProductPicture(): Unit = {
    driver.findElement(product).click()

  }

  def clickOnCategory(): Unit = {
    driver.findElement(categoryLink).click()
  }

  def clickOnIcon(): Unit = {
    driver.findElement(icon).click()
  }

  def clickOnComparisonIcon(): Unit = {
    driver.findElement(comparisonIcon).click()
  }


}

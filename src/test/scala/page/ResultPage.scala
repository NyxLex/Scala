package page

import org.openqa.selenium.{By, WebDriver}


class ResultPage(private var driver: WebDriver) {
  val heading: By = By.id("firstHeading")
  val productPreview: By = By.className("goods-tile__inner")
  val moneyPreview: By = By.className("goods-tile__price-value")
  val searchResult: By = By.className("goods-tile__title")
  val productTitle: By = By.className("product__title")
  val advertiseList: By = By.className("lite-tile__picture")
  private val headerComparison: By = By.xpath("//button[@class='header__button ng-star-inserted']")

  def verifyHeading(searchTerm: String): Unit = {
    assert(driver.findElement(heading).getText equals searchTerm)
  }

  def verifySearchResults(searchTerm: String): Unit = {
    assert(driver.findElements(searchResult).stream().allMatch(elem => elem.getText.toLowerCase().contains(searchTerm)))
  }
  def verifyProductPageIsVisible(): Unit = {
    assert(driver.findElement(productTitle).isEnabled)
  }

  def verifyAdvertiseIsNotEmpty(): Unit = {
    assert(!driver.findElements(advertiseList).isEmpty)
  }

  def verifyLinkIsOpen(): Unit = {
    assert(driver.getCurrentUrl!=null)
  }
  def verifyProductContainsCost(): Unit = {
    assert(!driver.findElements(moneyPreview).isEmpty)
  }

  def verifyComparisonElementIsNotEmpty(): Unit = {
    assert(!driver.findElements(headerComparison).isEmpty)
  }



}

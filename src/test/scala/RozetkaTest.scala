import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.concurrent.Eventually
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}
import org.scalatestplus.selenium.WebBrowser
import page.{MainPage, ResultPage, SortPanel}

class RozetkaTest extends AnyFlatSpec with BeforeAndAfterAll with BeforeAndAfterEach
  with Matchers with Eventually with WebBrowser {

  implicit val driver: ChromeDriver = {
    System.setProperty("webdriver.chrome.driver", "D:\\scala-automation-samples\\chromedriver.exe")
    new ChromeDriver()
  }

  val baseUrl = "https://rozetka.com.ua"
  lazy val mainPage = new MainPage(driver)
  lazy val searchResultsPage = new ResultPage(driver)
  lazy val sortPanel = new SortPanel(driver)

  override def beforeEach(): Unit = {
    go to baseUrl
  }

  override def afterAll(): Unit = {
    quit()
  }

  "User" should "be able to find topic" in {
    val topic = "Ноутбук2"
    mainPage.searchFor(topic)
    searchResultsPage.verifySearchResults(topic)
  }
  "User" should "be able to able to see advertise " in {
    mainPage.clickOnProductPicture()
    searchResultsPage.verifyProductPageIsVisible()
    searchResultsPage.verifyAdvertiseIsNotEmpty()
  }

  "User" should "be able to change list order " in {
    mainPage.clickOnCategory()
    mainPage.clickOnIcon()
    sortPanel.clickOnSortPanel()
    sortPanel.clickOnOptionFromLowerToBigger()
    searchResultsPage.verifyProductContainsCost()
  }

}

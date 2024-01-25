package page

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.time.Duration

class CheckingSearchFunctionality {
    private lateinit var driver: WebDriver

    @Test
    fun search() {
        val options = ChromeOptions()
        val prefs = HashMap<String, Any>()
        prefs["profile.managed_default_content_settings.images"] = 2
        options.setExperimentalOption("prefs", prefs)
        driver = ChromeDriver(options)
        driver.get("https://www.google.com/")

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500))
        var textFind = driver.findElement(By.className("gLFyf"))
        textFind.sendKeys("танцующий котик")
        textFind.sendKeys(Keys.ENTER)
        //var videoButton = driver.findElements(By.className("hdtb-mitem").findElement("video").click())
        //driver.findElements(By.className("GKS7s"))[2].findElement(By.className("FMKtTb")).text
        val buttons = driver.findElements(By.className("FMKtTb"))
        for (i in 0 until buttons.size) {
            if (buttons[i].text == "Видео") {
                buttons[i].click()
                break
            }
        }
    }

    @Test
    fun searchYandex(){
        driver = ChromeDriver()
        driver.get("https://yandex.ru/search")
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500))
        var textFind = driver.findElement(By.className("HeaderDesktopForm-Input"))
        textFind.sendKeys("Танцующий котик")
        var buttonFind = driver.findElement(By.className("arrow__button"))
    }
    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}
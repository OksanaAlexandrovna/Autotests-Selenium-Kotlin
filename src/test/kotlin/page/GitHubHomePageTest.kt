package page

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class GitHubHomePageTest {
    private lateinit var driver: WebDriver
    private lateinit var gitHubHomePage: GitHubHomePage

    @Test
    fun setUp() {
        driver = ChromeDriver()
        gitHubHomePage = GitHubHomePage(driver)
        gitHubHomePage.open()
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}
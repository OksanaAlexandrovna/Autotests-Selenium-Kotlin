package page

import org.openqa.selenium.WebDriver

class GitHubHomePage(private val driver: WebDriver) {
    fun open() {
        driver.get("https://github.com/")
    }
}
package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void sortProductsByPriceLowToHigh() {
        login();
        driver.findElement(By.className("product_sort_container")).sendKeys("Price (low to high)");

        String price1 = driver.findElements(By.className("inventory_item_price")).get(0).getText();
        String price2 = driver.findElements(By.className("inventory_item_price")).get(1).getText();

        double p1 = Double.parseDouble(price1.replace("$", ""));
        double p2 = Double.parseDouble(price2.replace("$", ""));

        Assert.assertTrue(p1 <= p2);
    }

    private void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}

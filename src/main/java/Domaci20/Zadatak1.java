package Domaci20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

/*
Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita,
 da nije doslo do izmene. Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.

 */
public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdiver.chrome.driver", "C:\\ITBootCamp\\chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        WebElement fullName= driver.findElement(By.id("userName"));
        fullName.sendKeys("Sandra Matic");
        String fullName1 = fullName.getAttribute("value");

        WebElement email= driver.findElement(By.id("userEmail"));
        email.sendKeys("sandramatic@gmail.com");
        String email1 = email.getAttribute("value");

        WebElement currentAdress= driver.findElement(By.id("currentAddress"));
        currentAdress.sendKeys("Petra Petrovica 11");
        WebElement permanentAdress= driver.findElement(By.id("permanentAddress"));
        permanentAdress.sendKeys("Petra Petrovica 11");

        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();

        WebElement fullNameActuall = driver.findElement(By.id("name"));
        String fullName2 = fullNameActuall.getText();

        WebElement emailActual = driver.findElement(By.id("email"));
        String email2 = emailActual.getText();



        if(fullName2.substring(5).equals(fullName1) && email2.substring(6).equals(email1)){
            System.out.println("Full name i email su isti i pre i posle Submit-a");
        } else {
            System.out.println("Full name i email nisu isti pre i posle Submit - a");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}

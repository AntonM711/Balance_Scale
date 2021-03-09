package com.Balance_Scale.tests;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class Scale {

    public static void waits(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        String even = "=";
        String less = "<";
        String more = ">";

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");

        waits(1);
        driver.findElement(By.id("left_0")).sendKeys("0");

        waits(1);
        driver.findElement(By.id("left_1")).sendKeys("1");

        waits(1);
        driver.findElement(By.id("left_2")).sendKeys("2");

        waits(1);
        driver.findElement(By.id("right_0")).sendKeys("3");

        waits(1);
        driver.findElement(By.id("right_1")).sendKeys("4");

        waits(1);
        driver.findElement(By.id("right_2")).sendKeys("5");

        waits(1);
        driver.findElement(By.id("weigh")).click();

        String result1 = driver.findElement(By.xpath("(//button[@id='reset'])[1]")).getText();

        if(result1.equals(even)){
            waits(1);
            driver.findElement(By.xpath("(//button[@id='reset'])[2]")).click();

            waits(1);
            driver.findElement(By.id("left_0")).sendKeys("6");

            waits(1);
            driver.findElement(By.id("right_0")).sendKeys("7");

            waits(1);
            driver.findElement(By.id("weigh")).click();
            String result2 = driver.findElement(By.xpath("(//button[@id='reset'])[1]")).getText();

            waits(1);
            if (result2.equals(even)){
                driver.findElement(By.xpath("//button[@id='coin_8']")).click();
            }else if(result2.equals(less)){
                driver.findElement(By.xpath("//button[@id='coin_6']")).click();
            }else {
                driver.findElement(By.xpath("//button[@id='coin_7']")).click();
            }

        }else if(result1.equals(less)){
            waits(1);
            driver.findElement(By.xpath("(//button[@id='reset'])[2]")).click();

            waits(1);
            driver.findElement(By.id("left_0")).sendKeys("0");

            waits(1);
            driver.findElement(By.id("right_0")).sendKeys("1");

            waits(1);
            driver.findElement(By.id("weigh")).click();
            String result2 = driver.findElement(By.xpath("(//button[@id='reset'])[1]")).getText();

            waits(1);
            if (result2.equals(even)){
                driver.findElement(By.xpath("//button[@id='coin_2']")).click();
            }else if(result2.equals(less)){
                driver.findElement(By.xpath("//button[@id='coin_0']")).click();
            }else {
                driver.findElement(By.xpath("//button[@id='coin_1']")).click();
            }

        }else{
            waits(1);
            driver.findElement(By.xpath("(//button[@id='reset'])[2]")).click();

            waits(1);
            driver.findElement(By.id("left_0")).sendKeys("3");

            waits(1);
            driver.findElement(By.id("right_0")).sendKeys("4");

            waits(1);
            driver.findElement(By.id("weigh")).click();
            String result2 = driver.findElement(By.xpath("(//button[@id='reset'])[1]")).getText();

            waits(1);
            if (result2.equals(even)){
                driver.findElement(By.xpath("//button[@id='coin_5']")).click();
            }else if(result2.equals(less)){
                driver.findElement(By.xpath("//button[@id='coin_3']")).click();
            }else {
                driver.findElement(By.xpath("//button[@id='coin_4']")).click();
            }

        }

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();
        String expectedAlert = "Yay! You find it!";

        Assert.assertTrue("Alert Message Failed", alertMessage.equals(expectedAlert));
        waits(1);
        alert.accept();

        System.out.println(alertMessage);
        String list_Of_Weighing = driver.findElement(By.xpath("//div[@class='game-info']")).getText();
        System.out.println(list_Of_Weighing);










    }


}

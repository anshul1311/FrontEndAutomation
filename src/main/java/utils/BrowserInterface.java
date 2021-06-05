package utils;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface BrowserInterface<T> {

    void driver(T t,String browserName) throws IOException;
     T getDriver() throws IOException;
}

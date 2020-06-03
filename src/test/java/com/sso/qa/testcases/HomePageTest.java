package com.sso.qa.testcases;

import com.sso.qa.base.TestBase;
import com.sso.qa.pages.HomePage;
import com.sso.qa.util.DataProviderSSO;
import com.sso.qa.util.TestUtil;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

public class HomePageTest extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
    DataProviderSSO dp;
    String sheetName = "data";

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeTest
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        dp = new DataProviderSSO();
        driver.get(prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        Object data[][] = new Object[0][];
        try {
            data = dp.dataSupplier();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Test(priority = 1, dataProvider = "getCRMTestData")
    public void test1(Map<Object, Object> map) {
        System.out.println("-------------Test case started ----------------");
        System.out.println(map.get("execution"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));

        System.out.println("-------------Test case Ended ----------------");    }

    @Test(priority = 2)
    public void test2() {

    }

    @Test(priority = 3)
    public void test3() {

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

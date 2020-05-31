package com.sso.qa.testcases;

import com.sso.qa.base.TestBase;
import com.sso.qa.pages.HomePage;
import com.sso.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
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
        driver.get(prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 1, dataProvider = "getCRMTestData")
    public void test1(String execution, String firstName, String lastName, String company) {
            System.out.println(execution + firstName + lastName + company);
    }

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

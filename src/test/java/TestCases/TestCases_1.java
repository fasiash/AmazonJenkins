package TestCases;

import org.testng.annotations.Test;

import PageObject.Page_Objects_1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestCases_1 extends Page_Objects_1 {

	Page_Objects_1 poa = new Page_Objects_1();

	@BeforeSuite
	public void ExtentReportSetup1() {

		poa.ExtentReportSetup();

	}
	@Test(priority = 1)
	public void test1() throws Exception {

		poa.Invalid_Login();

	}

	@Test(priority = 2)
	public void test2() throws Exception {

		poa.Login_into_Amazon();

	}

	@Test(priority = 3)
	public void test3() throws Exception {

		poa.Add_Watch_to_the_Cart();
	}

	@Test(priority = 4)
	public void test4() throws Exception {

		poa.Add_Mobile_to_the_Cart();
	}

	@Test(priority = 5)
	public void test5() throws Exception {

		poa.Add_Speaker_to_the_Cart();

	}

	@Test(priority=6)

	public void test6() throws Exception{

		poa.Delete_products();
	}
	@Test(priority=7)
	public void test7() throws Exception{
		poa.Click_On_Checkout();
	}

	@Test(priority=8)
	public void test8() throws Exception {
		poa.Return_to_cart();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		poa.BrowserLaunch();
	}

		@AfterTest
		public void closebrowser() throws Exception {
			
			poa.afterTest();
	
		}

	@AfterSuite
	public void teardown1() throws Exception {

		poa.teardown();
	}


}


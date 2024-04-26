package com.automation.pim.locators;

public class PageObjectsLocators {
	
	//SignUpPage Locators
	public static final String SignUp_Link="signin2";
	public static final String SignUp_Modal="signInModalLabel";
	public static final String SignUp_Button="//button[normalize-space()='Sign up']";
	public static final String SignUp_Close_Button="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']";
	public static final String SignUp_Username="//input[@id='sign-username']";
	public static final String SignUp_Password="//input[@id='sign-password']";

	
	//LoginLoutPage Locators
	public static final String Login_Link="login2";
	public static final String Login_Modal="logInModalLabel";
	public static final String Login_Button="//button[normalize-space()='Log in']";
	public static final String Login_Username="//input[@id='loginusername']";
	public static final String Login_Password="//input[@id='loginpassword']";
	public static final String Logout_Link="logout2";

	
	//AddToCart Locators
	public static final String Phone_Category="//div[@id='contcont']//a[2]";
	public static final String First_Phone="//a[normalize-space()='Samsung galaxy s6']";
	public static final String Second_Phone="//a[normalize-space()='Nokia lumia 1520']";
	public static final String Add_To_Cart_Button="//a[normalize-space()='Add to cart']";
	public static final String Home_Link="//li[@class='nav-item active']//a[@class='nav-link']";
	public static final String Cart_Link="//a[@id='cartur']" ;
	public static final String Delete_Item="//tbody/tr[1]/td[4]/a[1]";
	public static final String Total_ItemPrice="totalp";
	public static final String PlaceOrder_Button="//button[normalize-space()='Place Order']";
	public static final String Form_Modal="orderModalLabel";
	public static final String Form_User_Name="//input[@id='name']";
	public static final String Form_Country="//input[@id='country']";
	public static final String Form_City="//input[@id='city']";
	public static final String Form_CreditCard="//input[@id='card']";
	public static final String Form_CC_Month="//input[@id='month']";
	public static final String Form_CC_Year="//input[@id='year']";
	
	//PurchasePage Locators
	public static final String Purchase_Button="//button[normalize-space()='Purchase']";
	public static final String Purchase_Close_Button="//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']";
	public static final String Purchase_Ok_Button="//button[normalize-space()='OK']";
	public static final String Purchase_Details="//p[@class='lead text-muted ']";
	
	//CategoryPage Locators
	public static final String Main_Category="//a[@id='cat']";
	public static final String Laptop_Category="//div[@id='contcont']//a[3]";
	public static final String Monitor_Category="//div[@id='contcont']//a[4]";
	public static final String Main_Category_Next_Button="next2";
	public static final String Login_Modal_Label="logInModal";
	public static final String Items_Title="//div[@id='tbodyid']//h4[@class='card-title']/a";




	



}

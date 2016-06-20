package testcases;

import org.testng.annotations.Test;

public class sample {
	@Test
	public void login(){
		System.out.println("Logging into app");
	}
	
	@Test(dependsOnMethods={"login"})
	public void Register(){
		System.out.println("Registering user");
	}
	
	@Test(dependsOnMethods={"Register"})
	public void passwordChange(){
		System.out.println("Changing password");
	}
}

package mypackage;

import org.testng.annotations.BeforeTest;

public class Test {

	
	//public static void main(String[] args){
//		String s1=new String("Hello");
//				String s2=new String("there");
//				String s3=new String();
//				
//				s3=s1+s2;
//				s3=s1-s2;
//				s3=s1&s2;
//				s3=s1 && s2;
//				System.out.println(s3);
		
//		boolean a = false;
//		if (a = true)
//			System.out.println("Hello");
//		else
//			System.out.println("Good Bye");


//		String s1 = "abc";
//		String s2 = "def";
//		String s3 = s1.concat(s2.toUpperCase());
//		System.out.println(s1+s2+s3);
	
	
	@BeforeTest
	public void add(int a){
		
		loop: for (int i=1; i<3; i++){
			for (int j=1;j<3; j++){
				if(a==5){
					break loop;
				}
		System.out.println(i*j);
			}
			
			
				
		}
		
	}

}

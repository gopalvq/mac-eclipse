package logging;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class ProperiesDemo {
	static Logger log = Logger.getLogger(ProperiesDemo.class);
	
	@Test
	public void test() {
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("This message is a info");
		runMethod();
		log.debug("This message is a debug");
	}
	
	public void runMethod(){
		log.info("This is from runMethod");
	}
	

}

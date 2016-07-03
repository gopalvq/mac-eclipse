package logging;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class LoggingDemo {
	static Logger log = Logger.getLogger(LoggingDemo.class);
	
	@Test
	public void test() {
		//BasicConfigurator.configure();
		Properties log4jprop = new Properties();
		log4jprop.setProperty("log4j.rootLogger", "DEBUG, CA");
		log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
		log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
		log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%d{yyyy-MM-dd} -- %-10p %c - %m%n");
		PropertyConfigurator.configure(log4jprop);
		
		log.info("This message is a info");
		runMethod();
		log.debug("This message is a debug");
	}
	
	public void runMethod(){
		log.info("This is from runMethod");
	}
	

}

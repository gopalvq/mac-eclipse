package logging;

import static org.junit.Assert.*;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoLogging {
	
	static Logger log = Logger.getLogger(DemoLogging.class);
	static Appender append;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		final PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("%d{yyyy-MM-dd} --%-10p %c -%m%n");
		//layout.setConversionPattern("%d{yyyy-MM-dd} --%-10p %c{1} -%m%n");
		append = new ConsoleAppender(layout);
		log.addAppender(append);
		log.setLevel(Level.DEBUG);
		//log.setLevel(Level.ERROR);
		log.info("Running before method");
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		log.debug("Running After method");
	}

	@Test
	public void test() {
		log.debug("Running test method");
	}

}

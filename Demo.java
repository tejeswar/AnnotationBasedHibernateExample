package com.cisco;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.AppenderAttachable;


public class Demo {
	private static Logger logger = Logger.getLogger(Demo.class);
public static void main(String[] a){
	 PropertyConfigurator.configure("log4j.properties");
	/*logger.trace("trace leve");
	logger.debug("debug level");
	logger.info("info level");
	logger.warn("warn level");
	logger.error("error level");
	logger.fatal("fatal level");*/
	 for(int count = 0;count<100;count++){
	logger.info("helloshwshdfwohondfoshowefowioosdfowjowjeoiklsndfgkdfoqwefio");
	 }
	logger.debug("debug message");
	System.out.println("how");
	
	new Demo().test();
}
private static void test() {
	// TODO Auto-generated method stub
	System.out.println("test");
	System.out.println(null instanceof String);
}

}

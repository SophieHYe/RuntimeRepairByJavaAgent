package repair.java.agent;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 *
 * The exercise is consist of three projects: buggy project, java agent project and bug fix project.
 * This is the target running buggy project. The project contains an ArithmeticException : / by zero
 * Java agent project specifys the target buggy class and provides an agentmain method to redefine buggy classes.
 * The bug fix project loads java agent jar to fix the bugs in buggy project. 
 *  
 * @author yehe
 *
 */
public class App {
	
	public static Integer index = 10;
	
	public static void main(String[] args) {
		
		   while(true) {
	            try {
	            	System.out.println("Current process id is: " + getCurrentThreadID());
	                new DividedByZero().print(index);
	                Thread.sleep(2000);
	                index--;
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	}	
		
	 private static Integer getCurrentThreadID()
	    {
	        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
	        String name = runtime.getName();
	        return Integer.parseInt(name.substring(0, name.indexOf("@")));
	    }

}

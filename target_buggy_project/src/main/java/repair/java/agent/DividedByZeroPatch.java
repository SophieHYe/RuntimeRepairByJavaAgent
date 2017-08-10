package repair.java.agent;

/**
 * 
 * @author yehe
 *
 */
public class DividedByZeroPatch {	
	
	/**
	 * when index is zero, there is an ArithmeticException : / by zero
	 * @param index
	 */

    public void print(Integer index) {
        System.out.println("Current index is: "+index);
        Integer dividedResult = 0;
        if(index!=0) {
        	dividedResult = 1/index;
        }
        System.out.println("The result of 1/"+ index +" is: "+dividedResult);
    }
}
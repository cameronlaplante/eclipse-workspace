package recursionPractice;

public class Recursion {

	static int counter = 0;
    static int fib(int n){
    	
    	if (n<=1) {
    		if (n <= 0) {
    			return 0;
    		}
    		else {
    			return 1;
    		}
    	}
    	else {
    		counter += 1;
    		System.out.println("current count" + counter);
    		return fib(n-1) + fib(n-2);
    	}
    }
	      
	public static void main(String[] args) {
		int n = 9;
	    System.out.println(fib(n));
	}
	
}
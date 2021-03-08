package stackAndQueue;

public class QStackTest {

	public static void main(String[] args) {
		
		
		//Case1
		System.out.println("--------------------");
		
		QStack stack1 = new QStack();
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		
		stack1.pop();
		stack1.pop();
		stack1.pop();
		
		System.out.println("Case1 Top: " + stack1.top());
		
		
		//case2
		System.out.println("--------------------");
		
		QStack stack2 = new QStack();
		
		stack2.push(2);
		stack2.push(4);
		stack2.push(8);
		
		stack2.pop();
		stack2.pop();
		
		System.out.println("Case2 Empty: " + stack2.isEmpty());
		
		
		//case3
		System.out.println("--------------------");
		
		QStack stack3 = new QStack();
		
		stack3.push(3);
		stack3.push(6);
		stack3.push(9);
		
		stack3.pop();
		
		System.out.println("Case3 Top: " + stack3.top());
		System.out.println("Case3 Empty: " + stack3.isEmpty());
		
	}
	
}

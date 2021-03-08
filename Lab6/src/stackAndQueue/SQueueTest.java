package stackAndQueue;

public class SQueueTest {

	public static void main(String[] args) {
	
	//case1
	System.out.println("--------------------");	
		
	SQueue Queue1 = new SQueue();
	
	Queue1.add(1);
	Queue1.add(2);
	Queue1.add(3);
	Queue1.add(4);
	Queue1.add(5);
	
	Queue1.remove();
	Queue1.remove();
	Queue1.remove();
	
	System.out.println("Case1 Top: " + Queue1.peek());
	
	//case2
	System.out.println("--------------------");
	
	SQueue Queue2 = new SQueue();
	
	Queue2.add(2);
	Queue2.add(4);
	Queue2.add(8);
	
	Queue2.remove();
	Queue2.remove();
	
	System.out.println("Case2 Empty: " + Queue2.isEmpty());
	
	//case3
	System.out.println("--------------------");
	
	SQueue Queue3 = new SQueue();
	
	Queue3.add(3);
	Queue3.add(6);
	Queue3.add(9);
	
	Queue3.remove();
	
	System.out.println("Case3 Top: " + Queue3.peek());
	System.out.println("Case3 Empty: " + Queue3.isEmpty());
	
	}
	
	
}

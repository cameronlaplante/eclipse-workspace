package TestingPackage;

public class Tree {
	public int height;
	public boolean isEvergreen;
	
	public void printTreeDetails(){
		System.out.println("The height is " + height);
		if (isEvergreen){
			System.out.println("The tree is an evergreen");
		}else{
			System.out.println("The tree is not an evergreen tree");
			}
	}

	public void printInfo(int operation){
		if (operation == 1){
			System.out.print("height times 3 is ");
			System.out.println(height * 3);
			}else{
				System.out.print("height is ");
				System.out.println(height);
			}
	}
	
	public static void main(String args[]){
		Tree myTree = new Tree();
		Tree ourTree = new Tree();
		myTree.height = 32;
		ourTree.isEvergreen = false;
		myTree.isEvergreen = (1 < 5.3232);
		myTree.printInfo(1);
		ourTree.printInfo(-2);
		myTree.printTreeDetails();
		Tree bTree = new Tree();
		bTree.height = 96;
		bTree.printInfo(96);
		}
}

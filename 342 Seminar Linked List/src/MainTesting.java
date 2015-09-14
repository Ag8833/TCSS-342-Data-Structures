
public class MainTesting 
{
	public static void main(String[] args) 
	{
		System.out.println("------------------- First List -------------------");
		MyList firstList = new MyList();
		firstList.addNumber(1);
		firstList.addNumber(2);
		firstList.addNumber(3);
		firstList.printList();
		
		System.out.println("------------------- Second List: -------------------");
		int[] myArray = {1,2,2,2,3};
		MyList secondList = new MyList(myArray);
		secondList.printList();
		System.out.println("The number 2 occurs: " + secondList.countNumber(2) + " times");
		
		secondList.deleteFirst(1);
		secondList.printList();
		secondList.deleteAll(2);
		secondList.printList();
		
		System.out.println("------------------- Third List: -------------------");
		int[] secondArray = {1,2,3,4,5};
		MyList thirdList = new MyList(secondArray);
		thirdList.printList();
		thirdList.clearList();
		thirdList.printList();
	}
}

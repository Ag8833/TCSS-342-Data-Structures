/* Andrew Gates
 * 6/29/2015
 * TCSS 342
 * StackImplementation
 * 
 * This program contains the Main class for testing to be used with the Node class and
 * LinkedStack class. It contains a printMenu method that will call the corresponding
 * Node/LinkedStack methods.
 */

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		LinkedStack<String> myStack = new LinkedStack<String>();
		
		//Creating a scanner for menu input.
		Scanner scan = new Scanner(System.in);
		
		//Capturing the response to printMenu.
		int selection = printMenu(scan);
		
		//While loop to iterate until the user enters 0.
		while(selection != 0)
		{
			scan.nextLine();
			System.out.println();
			
			//Push selection.
			if(selection == 1)
			{
				System.out.print("Please enter the data to be pushed - ");
				myStack.push(scan.nextLine());
				System.out.println();
			}
			
			//Pop selection.
			else if(selection == 2)
			{
				if(myStack.isEmpty())
				{
					System.out.println("The stack is empty!");
				}
				else
				{
					System.out.println("The element popped is: " + myStack.pop());
				}
				System.out.println();
			}
			
			//Print stack selection.
			else if(selection == 3)
			{
				myStack.printStack();
			}
			
			//Peek selection.
			else if(selection == 4)
			{
				if(myStack.isEmpty())
				{
					System.out.println("The stack is empty!");
					System.out.println();
				}
				else
				{
					System.out.println("The top element is: " + myStack.peek());
					System.out.println();
				}
				
			}
			
			//Check if stack is empty selection.
			else if(selection == 5)
			{
				if(myStack.isEmpty() == true)
				{
					System.out.println("The stack is empty!");
					System.out.println();
				}
				else
				{
					System.out.println("The stack is NOT empty!");
					System.out.println();
				}
			}
			
			//Output the size of the stack.
			else if(selection == 6)
			{
				System.out.println("The size of the stack is: " + myStack.getSize());
				System.out.println();
			}
			
			//Delete all of the elements in the stack.
			else if(selection == 7)
			{
				if(myStack.isEmpty() == true)
				{
					System.out.println("The stack is already empty!");
					System.out.println();
				}
				
				else
				{
					myStack.clearStack();
				}
			}
			
			//Recapture the menu selection to repeat the loop.
			selection = printMenu(scan);
		}
		
		//Close scanner and end.
		scan.close();
		return;
	}

	//Method to output the menu and capture the selection from the user.
	static int printMenu(Scanner scan)
	{
		int response = 0;
		
		do
		{
			System.out.println("---------- MAIN MENU ----------");
			System.out.println("1) Push");
			System.out.println("2) Pop");
			System.out.println("3) Print Stack");
			System.out.println("4) Peek");
			System.out.println("5) Check if stack is empty");
			System.out.println("6) Check the size of the stack");
			System.out.println("7) Clear all of the elements in the stack");
			System.out.println("0) Exit");
			System.out.println("-------------------------------");
			System.out.println("Choose a selection - ");
			
			response = scan.nextInt();
			
			if(response < 0 || response > 7)
			{
				System.out.println("Please enter a valid response");
				System.out.println();
			}
		}
		while(response < 0 || response > 7);
			
		return response;
	}
}


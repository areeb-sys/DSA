import java.util.Stack;
import java.util.Scanner;
class PalindromeTest {
	@SuppressWarnings("unchecked")

    public static void main(String[] args) {

    	System.out.print("Enter any string:");
        Scanner input=new Scanner(System.in);
        String inpSt = input.nextLine();
        Stack stack1 = new Stack();

        for (int i = 0; i < inpSt.length(); i++) 
		{
            stack1.push(inpSt.charAt(i));
        }

        String reverseString = "";

        while (!stack1.isEmpty()) {
            reverseString = reverseString+stack1.pop();
        }

        if (inpSt.equals(reverseString))
            System.out.println("Input String is a palindrome.");
        else
            System.out.println("Input String is not a palindrome.");

    }
}
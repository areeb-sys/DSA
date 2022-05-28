import java.util.Scanner;
public class Test
{
	public static void main(String[] args)
	{
		Stack st = new Stack();
		int stack[] = new int[5];
		Scanner input = new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			stack[i] = input.nextInt();
			
		}
		
	}
}

class Stack
{
	int stack[] = new int[5];
	int top=0;
	
	public void push(int data)
	{
		if(isFull())
		{
			System.out.println("Stack is Full");
		}
		else
		{
			stack[top] = data;
			top++;
		}
		
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		int data;
		top--;
		data = stack[top];
		stack[top] = 0;
		return data;
	}
	public int peek()
	{
		int data;
		data = stack[top-1];
		return data;
	}
	public int size()
	{
		return top;
	}
	public boolean isFull()
	{
		return top >= 5;
	}
	public boolean isEmpty()
	{
		return top<=0;
	}
	
	public void display()
	{
		for(int i=0;i<5;i++)
		{
			System.out.printf("%d  ",stack[i]);
			System.out.println("\n");
		}
	}
}
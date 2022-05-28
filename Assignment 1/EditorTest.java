import java.util.Scanner;

class Editor
{
	public int[] numArray={5,10,15,20,25,30,35,40};
	int i,j;
	public int counter=0;
	
	public void insertNum()
	{
		System.out.println("Given array is:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number for array!");
		int num = input.nextInt();
		i=0;
		while(numArray[i]<num)
		{
			i++;
		}
		j=counter;
		while(j>i)
		{
			numArray[j]= numArray[j-1];
			j--;
		}
		numArray[j]=num;
		counter++;
		for(i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
	}
	public void findAndReplace()
	{
		System.out.println("Given array is:");
		for( i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		System.out.println("\n");
		System.out.println("Enter the number you want to replace:");
		Scanner input = new Scanner(System.in);
		int entered_number = input.nextInt();
		System.out.println("Enter the number with which you want to replace:");
		int replaced_num = input.nextInt();
		i=0;
		while(numArray[i]!=entered_number)
		{
			i++;
		}
		if(numArray[i]==entered_number)
			numArray[i] = replaced_num;
		System.out.println("Resultant array will be:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d     ",numArray[i]);
		}
	}
	public void replaceAll()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Given array is:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		System.out.println("\n");
		System.out.println("Here we are replacing all element...");
		System.out.println("Enter the values for next array:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("Element %d-",i+1);
			numArray[i] = input.nextInt();
		}
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		
	}
	public void delNum()
	{
		int position=0;
		int size=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Given array is:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		size = numArray.length;
		System.out.println("\n");
		System.out.println("Enter the position from where we want to delete the element:");
		position = input.nextInt();
		for(i=position-1;i<size-1;i++)
		{
			numArray[i]=numArray[i+1];
		}
		 size--;
		for(int i=0;i<size;i++)
		{
			System.out.printf("%d   ",numArray[i]);
		}
	}
	public void delAll()
	{
		int from,to;
		System.out.println("Given array is:");
		for(int i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of index from where you want to delete the numbers:");
		from = input.nextInt();
		System.out.println("Enter the number of index where you want to stop the deletion:");
		to		= input.nextInt();
		
		int i=to+1;
	while(i<counter)
	{
			numArray[from]=numArray[i];
			i++;
			from++;
		
	}
	counter=from;
	for(i=0;i<numArray.length;i++)
		{
			System.out.printf("%d  ",numArray[i]);
		}
	}	
	public void display()
	{
		System.out.println("Given array is :");
		for(int i =0;i<numArray.length;i++)
		{
			System.out.printf("%d   ",numArray[i]);
		}
	}
	
	
}

 public class EditorTest
{
	public static void main(String[] args)
	{
		System.out.println("\n");
		System.out.println("  			   Enter the choice");
		System.out.println("			1:Insert a number");
		System.out.println("			2:Find and replace a number");
		System.out.println("			3:Replace All");
		System.out.println("			4:Delete one element");
		System.out.println("			5:Delete all in Range");
		System.out.println("			6:View numbers");
		System.out.println("			0:Exit");
		System.out.println("\n");
		Scanner input = new Scanner(System.in);
		Editor ed = new Editor();
		 int choice = input.nextInt();
		if(choice == 0)
			System.out.println("Program Exited....");
		else
		{
				switch(choice)
				{
					case 1:
					{
						ed.insertNum();
						break;
					}
					case 2:
					{
						ed.findAndReplace();
						break;
					}
					case 3:
					{
						ed.replaceAll();
						break;
					}
					case 4:
					{
						ed.delNum();
						break;
					}
					case 5:
					{
						ed.delAll();
						break;
					}
					case 6:
					{
						ed.display();
						break;
					}
					
				}
		}
		
		
		
	}
}
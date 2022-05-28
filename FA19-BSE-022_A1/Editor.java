//AUTHOR : AREEB AHMED FA19-BSE-022-B

import java.util.Scanner;

public class Editor {

    private int counter=0;
    private int[] numArr=new int[100];
	private int arr_size=100;
    
    
    
    public static void main(String[] args) {
        int i=0,choice=1,number=0,number1=0,posit=0,numbWith=0;
        Scanner inp = new Scanner(System.in);
        Editor ed = new Editor();
        while(choice!=0)
        {
            System.out.println("\n");
		System.out.println("			1:Insert a number");
		System.out.println("			2:Find and replace a number");
		System.out.println("			3:Replace All");
		System.out.println("			4:Delete one element");
		System.out.println("			5:Delete all in Range");
		System.out.println("			6:View numbers");
		System.out.println("			0:Exit");
		System.out.println("\n");
        choice = inp.nextInt();
        switch(choice)
        {
			case 1:
			{
				System.out.println("Enter The Number to Add");
				number=inp.nextInt();
                ed.insertNum(number);
                ed.disp();
                break;
			}           
            case 2:
			{
				System.out.println("Current Array is");
				ed.disp();
				System.out.println("\n");
				System.out.println(" Enter Number to find");
				number=inp.nextInt();
				System.out.println("Enter Number to Replace With");
				numbWith=inp.nextInt();
				ed.findNRep(number, numbWith);
				ed.disp();
				break;
			}	
			case 3:
			{
				System.out.println("Current Array is");
				ed.disp();
				System.out.println("\n");
                System.out.println("Enter the first position of element of array:");
                number=inp.nextInt();
                System.out.println("Enter the second position of element of array:");
                numbWith=inp.nextInt();
                ed.FindNReplaceAll(number, numbWith);
                ed.disp();
				break;
			}
			case 4:
			{
				System.out.println("Enter The index to delete element from");
				posit=inp.nextInt();
				ed.DelNum(posit);
				ed.disp();
				break;
			}
			case 5:
			{
				System.out.println("Enter the lower Limit of index of array:");
				number=inp.nextInt();
				System.out.println("Enter the upper Limit of index of array:");
				number1=inp.nextInt();
				ed.delInRan(number,number1);
				ed.disp();
				break;
			}
			case 6:
				ed.disp();
				break;
            }
                
        }
    }
    boolean insertNum(int number)
	{
		int i = 0, j;

		if (counter >= arr_size)
			return false;

		if (counter == 0)
		{
			numArr[counter++] = number;
			return true;

		}
		if (numArr[counter - 1] < number)
		{
			numArr[counter++] = number;
			return true;
		}


		for (i = 0; i < counter; i++)
		{
			if (numArr[i] > number)
			{
				break;
			}
		}

		for (j = counter; j > i; j--)
		{
			numArr[j] = numArr[j - 1];
		}//end for loop

		numArr[i] = number;
		counter++;
		return true;
	}

void DelNum(int posit)
{
    int i = posit;
    while(i<counter)
    {
        numArr[i]=numArr[i++];
    }
    counter--;
}

boolean findNRep(int number,int numbWith)
{
    int i =0;
    while(numArr[i]!=number)
    {
        i++;
    }
    if(i>=counter)
    {
        return false;
    }
    if(numArr[i]==number)
        numArr[i]=numbWith;
    return true;
}
void disp()
{
    int i;
    for(i=0 ; i<counter; i++)
        System.out.printf(" %d ",numArr[i]);
}
boolean FindNReplaceAll(int number, int numbWith)
{
	int i =0;
    while(i!=counter)
    {
       
    
    if(i>=counter)
    {
        return false;
    }
    if(numArr[i]==number)
        numArr[i]=numbWith;
    	i++;
	}
	
		return true;
}
void delInRan(int from,int to)
{
	int i=to+1;
	while(i<counter)
	{
			numArr[from]=numArr[i];
			i++;
			from++;
		
	}
	counter=from;
}



    
}
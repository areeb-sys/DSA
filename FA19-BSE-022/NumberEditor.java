import java.util.Scanner;

class MyStack
{
    private int value;
    private int posit;
    private char var;

    public MyStack(int value, int posit, char var)
	{
        this.value = value;
        this.posit = posit;
        this.var = var;
    }

    public int getValue()
	{
        return value;
    }

    public int getPosit()
	{
        return posit;
    }

    public char getVar()
	{
        return var;
    }

    public void setNumber(int value){
        this.value = value;
    }

    public void setLocation(int posit)
	{
        this.posit = posit;
    }

    public void setOperation(char var)
	{
        this.var = var;
    }
}

public class NumberEditor
{
    private int array_size=50;
    private  int[] numAry = new int[array_size];
    private int counter;
    private MyStack[] st1 = new MyStack[array_size];
    private int peek ;

    public static void main(String[] args) 
	{

        int i=0,choice=1,value=0,num=0;
        Scanner load = new Scanner(System.in);
        NumberEditor editor = new NumberEditor();
        while(choice!=0)
        {
            System.out.println("\n");
		System.out.println("1:Insert a number");
		System.out.println("2:Delete one element");
		System.out.println("3:Undo");
		System.out.println("4:View value");
		System.out.println("0:Exit");
		System.out.println("\n");
        choice = load.nextInt();
        switch(choice)
        {
        case 1:
		if(editor.counter>=editor.array_size)
		{
		System.out.println("Number not deleted beacuse Array is full");
		}
		else
		{
			System.out.println("Enter The Number:");
			value=load.nextInt();
			editor.InsertArray(value);
		}
			break;					 
        case 2:
        if(editor.counter==0)
        {
			System.out.println("Cannot Delete Number");
        }
        else
		{
			System.out.print("Enter the Position to Delete : ");
			num = load.nextInt();
			int check=editor.DeleteNum(num);
        }
			break;           
        case 3:
        if(editor.isStackEmpty())
		{
			System.out.println("No Undo number in Stack");
        }
		else
		{
            editor.undo();
        }
			break;
        case 4:
            editor.Display();
            break;


            }
        }
    }
    
  public NumberEditor()
	{
        this.peek = 0;
        this.counter = 0;
    }
 
    int getCounter()
    {
        return this.counter;
    }

    boolean empty()
    {
        return counter == 0;
    }
  public int DeleteNum(int num)
    {
        if(num >= counter)
        {
            return 0;
        }
        else
        {
			if(!(Thread.currentThread().getStackTrace()[2].getMethodName().equals("undo")))
			{
            push(numAry[num],num,'d');
            }

            for (int i = num; i < counter; i++)
			{
                numAry[i] = numAry[i + 1];
            }

            numAry[counter] = 0;
            counter--;
            return 1;
        }
    }
	
	
    public boolean InsertArray(int value)
    {
        int temp = counter;
        if(!empty())
        {
            for (int i = 0; i < counter + 1; i++) 
            {
                if (numAry[i] < value)
                {
                    continue;
                }
                temp = i;
                break;
            }

            for (int i = counter; i > temp; i--)
            {
                numAry[i] = numAry[i - 1];
            }
        }

        numAry[temp] = value;
        this.counter++;
        if(!(Thread.currentThread().getStackTrace()[2].getMethodName().equals("undo"))) 
		{
            push(value, temp, 'i');
		}
        return true;
	}
  
	public void pop()
	{
        st1[peek-1].setNumber(0);
        st1[peek-1].setLocation(0);
        st1[peek-1].setOperation('\u0000');
        peek--;
    }
    public void push(int value, int num, char opr)
	{
        st1[peek] = new MyStack(value, num, opr);
        peek++;
    }

    public boolean isStackEmpty()
	{
        return peek == 0;
    }

    public void undo()
	{
        if(st1[peek-1].getVar() == 'i'){
            DeleteNum(st1[peek-1].getPosit());
        }
        if(st1[peek-1].getVar() == 'd'){
           InsertArray(st1[peek-1].getValue());
        }
        pop();
    }


    public void Display() {
        System.out.println("");
		int i = 0;
        while( i < counter)
        {
            System.out.printf("%d ", numAry[i]);
			i++;
        }
        System.out.println("");
    }     
    
}


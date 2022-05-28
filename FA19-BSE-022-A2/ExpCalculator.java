//Author : AREEB AHMED (FA19-BSE-022)

import java.util.Scanner;

public class ExpCalculator{
    
    
    public static void main(String[] args)
    {
        int counter1=0;
        String Var;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any Expression");
        Var=input.next();
        
        
        Stack stack = new Stack();
		int i =0 ;
        
        while( i<Var.length())
        {
             stack.Expression[i]=Var.charAt(i);
              counter1++;
				i++;
        } 
        stack.setcounter(counter1);
        
       if(stack.ExpressionIsValid())
        {
            System.out.printf("Expression is valid\n");
            stack.postFixConversion();
            System.out.printf("Answer is: %d",stack.postFixEvaluation());
        }
        else
        {
            System.out.printf("Expression is not valid");
        }  
    }
}
  
class Stack{
    
    int tot_size = 100;
    public char Expression[] = new char[tot_size];
    private int numbStack[] = new int[tot_size];
    private char[] Stack = new char[tot_size];
    private char[] postFix_Expression = new char[tot_size];
    private int counter1=0;
    private int peek=0;
    private int counter2=0;

    boolean postFixConversion()
  {
     int i,j=0;
      
      
      for(i =0 ;i<counter1;i++)
      {
          if((Expression[i]=='(')||(Expression[i]=='{')||(Expression[i]=='['))
          {
              push(Expression[i]);
              continue;
          }
          if((Expression[i]>='0')&&(Expression[i]<='9'))
          {
              postFix_Expression[j++]=Expression[i];
              continue;
          }
          peek=peek-1;
           if((Expression[i]==')')||(Expression[i]=='}')||(Expression[i]==']'))
           {
               while((Stack[peek]!='(')&&(Stack[peek]!='{')&&(Stack[peek]!='['))
               {
                   postFix_Expression[j++]=Stack[peek--];
               }
               continue;
           }
           
           if((Expression[i]=='+')||(Expression[i]=='-')||(Expression[i]=='*')||(Expression[i]=='/'))
           {
               while(precedence(Stack[peek])>=precedence(Expression[i]))
               {
                   postFix_Expression[j++]=Stack[peek--];
               }
               peek++;
               push(Expression[i]);
           }
           }
     
       counter2=j;
      return true;
  }
  
  
   int charToNum(char ch)
  {
	  switch(ch)
	  { 
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5': 
			return 5;
		case '6': 
			return 6;
		case '7':
			return 7;
		case '8': 
			return 8;
		case '9':
			return 9;
	  }
      
      return -1; 
  }
  
  
   boolean ExpressionIsValid()
  { 
      int i=0;
      
      
      for(i =0 ;i<counter1;i++)
      {
          if((Expression[i]=='[')||(Expression[i]=='{')||(Expression[i]=='('))
          {
              push(Expression[i]);
              continue;
              
          }
          if((Expression[i]==')')&&(pop()!='('))
          {
              
              return false;
          }
          if((Expression[i]=='}')&&(pop()!='{'))
          {
              return false;
          }
          if((Expression[i]==']')&&(pop()!='['))
          {
              return false;
          }
      }
    return true;
  }
  
 
   int postFixEvaluation()
  {
      int Value=0 , val1 =0 , val2=0, i = 0;
      while( i <counter2)
      {
          if((postFix_Expression[i]>='0')&&(postFix_Expression[i]<='9'))
          {
              numbStack[Value++]=charToNum(postFix_Expression[i]);
          }
          else
        {
              val2=numbStack[--Value];
              val1=numbStack[--Value];
              if(postFix_Expression[i]=='-')
                  numbStack[Value++]=val1-val2;
              if(postFix_Expression[i]=='+')
                  numbStack[Value++]=val1+val2;
              if(postFix_Expression[i]=='*')
                  numbStack[Value++]=val1*val2;
              if(postFix_Expression[i]=='/')
                numbStack[Value++]=val1/val2;
        }
		i++;
    }
    return (numbStack[--Value]);
  }
  
    int precedence(char ch)
    {
		switch(ch)
		{ 
			case '-':
				return 1;
			case '+':
				return 2;
			case '*':
				return 3;
			case '/':
				return 4;
		}
		return 0; 
	}
 
 void setcounter(int counter1)
    {
        this.counter1=counter1;
    }
	
	
    char pop()
    {
        return Stack[--peek];
        
    }
	void push(char n)
    {
        Stack[peek++]=n;
    }
}
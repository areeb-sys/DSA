import java.util.Scanner;
public class QuizTest
{
	public static void main(String[] args)
	{
		Quiz q = new Quiz();
		q.duplicates();
	}
}

 class Quiz
{
	public int[] array = {1,2,2,3,4,5,5,5,6,7,9};
	public	int counter=0;
	public void duplicates()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Given array is:");
		for(int i=0;i<array.length;i++)
		{
			System.out.printf("%d   ",array[i]);
		}
		System.out.println("Enter the number for matching:");
		int number = input.nextInt();
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==number)
			{
				counter++;
			}
		}
		System.out.printf("%d found %d times in given array",number,counter);
	}
}
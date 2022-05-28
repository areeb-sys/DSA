import java.util.Scanner;

import java.util.Arrays;

public class Remove{

public static void main(String[] args) {
	

int num;

System.out.print("Please enter the size of the array: ");

Scanner input = new Scanner(System.in);

num = input.nextInt(); 

int[] array = new int[num];

System.out.print("Please enter the elements of the array: ");

for(int i = 0; i<num; i++)

array[i] = input.nextInt(); 

Arrays.sort(array); 

int size = 0;

for (int i=0; i < num-1; i++){

if (array[i] != array[i+1]){ 

array[size++] = array[i];

}

}

array[size++] = array[num-1];

for(int i = 0; i<size; i++) 

System.out.printf("%d   ",array[i]);

}

}
/*
 * Class: CMSC201 
 * Instructor: Grinberg
 * Description: This program checks if a credit card number is valid
 * Due: 03/02/2019
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emily Bolten
*/
/*
*List of inputs for the program:
*1. Credit card number

*List of output for the program:
*1. Whether the credit card is valid or not
*/
/*
*Pseudocode for Program:
*1. Import Scanner and Math packages, create public class CreditCardValidity and main method
*2. Create InputData() method to get user's data
*3. Prompt user for credit card number, store long into CreditCardNum and return the value
*4. Create GetSize(long Num) method to get length of credit card number
*5. Convert Num into a string and return the length of the characters in integer Size
*6. Create DisplayResults(boolean Validity, long Num) to display validity of credit card number
*7. If validity is true, print the card is valid, otherwise print it's invalid
*8. Create sumOfEvenPlace(long Num) to get sum of even place numbers in card number
*9. Convert Num to a string and double each character, then convert them back to integers
*and return the sum of the numbers
*10. Create sumOfOddPlace(long Num) to get sum of odd place numbers in card number
*11. Convert Num to a string and add each character, then convert them back to integers
*and return the sum of the numbers
*12. Create SumResults(int Sum1, int Sum2, long Num) to get final result of sums
*13. Define Sum1 to be result of sumOfEvenPlace(Num) and Sum2 to be result of sumofOddPlace(Num)
*14. Define TotalSum to be result of Sum1 + Sum2, return TotalSum
*15. Create prefixMatched(int Sum) to get boolean value of card validity
*16. If sum is divisible by 10, validity = true, otherwise validity = false, return validity
*17. Define CreditCardNum in main method as result of InputData()
*18. Define Sum to be the result of the sums of the card number's even and odd values
*19. Use DisplayResult() method to display whether the card number is valid or not
*/

//import necessary packages
import java.util.Scanner;
import java.lang.Math;


public class CreditCardValidity {

	public static void main(String[] args) {
		
		//To store the user's credit card number
		long CreditCardNum = InputData();
		
		//to store the sum and check if credit card is valid
		int Sum1 = sumOfEvenPlace(CreditCardNum);
		int Sum2 = sumOfOddPlace(CreditCardNum);
		int TotalSum = SumResults(Sum1,Sum2,CreditCardNum);
		
		//to finally check if credit card is valid
		boolean Validity = prefixMatched(TotalSum);
		DisplayResult(Validity,CreditCardNum);
		
	}
	
	//function to get user's credit card number
	public static long InputData() {
		
		long CreditCardNum; //declare variable to hold user's credit card number
		
		Scanner input = new Scanner (System.in); //create scanner object
		
		System.out.println("Enter a credit card as a long integer: ");
		CreditCardNum = input.nextLong(); //store credit card number
		return CreditCardNum; //return long credit card number
	}
	
	//return number of digits in credit card number
	public static int GetSize(long Num) {
		
		int Size; //variable to store size of credit card number
		
		String NumString = Long.toString(Num); //turn credit card number into string
		Size = NumString.length(); //get the length of the characters
		
		return Size; //return the size of the credit card number
	}
	
	//display the result
	public static void DisplayResult(boolean Validity,long Num) {
		//if validity is true, display card is valid
		if (Validity == true) {
			System.out.println(Num + " is valid.");
		}
		//if validity is not true, display card is invalid
		else {
			System.out.println(Num + " is invalid.");
		}
	}
	
	 //get sum of all numbers in even place
	  public static int sumOfEvenPlace(long Num) {
		  
		  int Sum = 0;
		  
		  String NumString = Long.toString(Num); //turn credit card number to string
		  char Number;
		  int NumberInt;
		  
		  for (int i = 0; i < NumString.length(); i ++) {
			  
			  if (i % 2 == 0) {
			  
			  Number = NumString.charAt(i);
			  
			  NumberInt = Character.getNumericValue(Number);
			  NumberInt *= 2;
			  
			  
			  String AddedNum = Integer.toString(NumberInt);
			  
			  if (AddedNum.length() > 1) {
				  char Num1 = AddedNum.charAt(0);
				  char Num2 = AddedNum.charAt(1);
				  
				  int NumInt1 = Character.getNumericValue(Num1);
				  int NumInt2 = Character.getNumericValue(Num2);
				  
				  NumberInt = NumInt1 + NumInt2;
			  }
			  Sum += NumberInt;
			  }
		  }
		  return Sum;
	  }
	  
	  //turn digit into single digit
	  public static int getDigit(int Num) {
		  
		  String NumString = Integer.toString(Num);
		  
		  if (NumString.length() > 1) {
			  char Num1 = NumString.charAt(0);
			  char Num2 = NumString.charAt(1);
			  
			  int NumInt1 = Character.getNumericValue(Num1);
			  int NumInt2 = Character.getNumericValue(Num2);
			  
			  int TotalNum = NumInt1 + NumInt2;
			  return TotalNum;
		  }
		  else {
			  return Num;
		  }
	  }
	  
	//get sum of all numbers in odd place
	  public static int sumOfOddPlace(long Num) {
		  
		  String NumString = Long.toString(Num); //turn credit card number to string
		  char Number;
		  int NumberInt;
		  int Sum = 0;
		  
		  for (int i = 0; i < NumString.length(); i ++) {
		  
			  if (!(i % 2 == 0)) {
				  
				  Number = NumString.charAt(i);
				  
				  NumberInt = Character.getNumericValue(Number);
				  
				  Sum += NumberInt;
			  }
		  }
		  return Sum;
	  }
	  
	  	//get the results of the sum of the card numbers
	  	public static int SumResults(int Sum1, int Sum2, long Num) {
		  
	  		Sum1 = sumOfEvenPlace(Num); //sum1 is sum of even place numbers
	  		
	  		Sum2 = sumOfOddPlace(Num); //sum2 is sum of odd place numbers
	  		
	  		int TotalSum = Sum1 + Sum2; //TotalSum is the sum of sum1 and sum2
		  
	  		return TotalSum;
	  	}
	  	
	  	//return if credit card is valid or not
	  	public static boolean prefixMatched(int Sum) {
	  		
	  		boolean Validity; //declare variable to store validity
	  		
	  		if (Sum % 10 == 0) {
	  			Validity = true; //if sum is divisible by 10, card is valid
	  		}
	  		else {
	  			Validity = false; //if sum is not divisible by 10, card is invalid
	  		}
	  		return Validity;
	  	}
}
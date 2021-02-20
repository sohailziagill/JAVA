import java.util.InputMismatchException;
import java.util.Scanner;

public class Arithmatic_Mismatch_Exception_Handling {

    public static int Quotient(int Nominator,int Denominator)
            throws ArithmeticException {

        // demonstrates throwing an exception when a divide-by-zero occurs



            // Possible Division by Zero
            return Nominator/Denominator;
        }


    public static void main(String[]args){
        Scanner MyObject=new Scanner(System.in);
        Scanner MyChoice=new Scanner(System.in);
        int Choice=0;

        do {

            try {
                System.out.println("Please Enter the Nominator ");
                int Nominator=MyObject.nextInt();
                System.out.println("Please Enter the Denominator ");
                int Denominator=MyObject.nextInt();
                int Result=Quotient(Nominator,Denominator);
                System.out.printf("%nThe Result is: %d/%d=%d%n",Nominator,Denominator,Result);




                // For the Choice Validation
                do {
                    System.out.println("Enter your choice to continue Press 1 otherwise 0");
                    Choice =MyChoice.nextInt();
                    if(Choice!=1  &&Choice!=0)
                        System.out.println("Your entered an Invalid numbere plaese Enter again");
                }while(Choice!=1 &&Choice!=0);
            }
            // For Input Mismatch Exception
            catch (InputMismatchException inputMismatchException){
                System.err.printf("%nException %s%n",inputMismatchException);
                System.out.printf("%nYou Must Enter Integer, Please Enter Again %n%n ");

            }
            catch (ArithmeticException arithmeticException){
                System.err.printf("%nException %s",arithmeticException);
                System.out.println("Zero is an invalid denominator. Please try again ");
            }


        }while(Choice==1);

    }
}


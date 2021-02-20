import java.util.ArrayList;
import java.util.Scanner;

public class Presentation_2 {


    public static void main(String[] args) {


        //To  Display first of all My Name and My Reg no....
        System.out.println("\n*******************************************************************:");
        System.out.println("\nProgrammer :  Sohail Zia Gill:");
        System.out.println("\nReg No  4041 :");

        System.out.println("\nDated : 21/Oct/2020:");
        System.out.println("\nCompiling date : 21/Oct/2020:");
        System.out.println(" \nInternational Islamic University Islamabad:");
        System.out.println("\n*******************************************************************:\n\n");


        // Take the input from the user and stored it to list to array

        // Declaring the Array List
        ArrayList<String> My_Array_List = new ArrayList<>();

        do {
            System.out.println("Please Enter the value to Array and Enter 0  to exit");
            Scanner Input = new Scanner(System.in);    //Taking the input through Scanner
            String Var = Input.nextLine();

            if (Var.equals("0"))            // Check the Terminating Case
                break;

            My_Array_List.add(Var);   // To add the data in ArrayList

        } while (true);


        System.out.println("The All Records of List are");
        // To Display the All records of List

        // For Undefined size of ArrayList we use ForEach(Declare Variable:List_Name)
        for(String s : My_Array_List)
        {
            System.out.println(s);
        }
    }
}



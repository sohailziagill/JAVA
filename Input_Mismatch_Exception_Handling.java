import java.util.InputMismatchException;
import java.util.Scanner;

public class Input_Mismatch_Exception_Handling {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int num;
        try {
            System.out.println("Please Enter your Registration Number");
            num = input.nextInt();
            System.out.println("You entered the number "+num);
        }
        catch (InputMismatchException ex){
            System.out.println("Illegal Argument the int type input is required");

        }


    }
}

import java.security.SecureRandom;
import java.util.Scanner;

public class Assignment_roll_dice_sum_with_user_name_length {

    public static void main(String[] args)
    {
        String Name;
        Scanner myObj=new Scanner(System.in);
        System.out.println("Enter your Name");
        Name=myObj.next();

        int Name_Length;
        int Sum_of_RollDice;
        int Result;
        Name_Length=Name.length();

        Sum_of_RollDice=RollDice();

        Result=Name_Length-Sum_of_RollDice;

        // For the Evven Rolled Dice By User
        if(Sum_of_RollDice%2==0)
        {


            if((Result%2==0)||(Result%2==-0))
            {
                System.out.println("The MR. "+Name+"  is Winner ");
                System.out.println("The Result of Name_Length-Sum_of_RollDice = "+Result);
            }
            else {
                System.out.println("The MR. "+Name+"  Lose ");
                System.out.println("The Result of Name_Length-Sum_of_RollDice = "+Result);
            }

        }

        // For the Odd Rolled Dice By User
        else
        {


            if((Result%2==1)||(Result%2==-1))
            {
                System.out.println("The MR. "+Name+"  is Winner ");
                System.out.println("The Result of Name_Length-Sum_of_RollDice = "+Result);
            }
            else {
                System.out.println("The MR. "+Name+"  Lose ");
                System.out.println("The Result of Name_Length-Sum_of_RollDice = "+Result);
            }
        }


    }


    public static int RollDice()
    {
        // Declaring the Constant Secure Random Number

        final SecureRandom Random_Number=new SecureRandom();

        int die1=1+Random_Number.nextInt(6);
        int die2=1+Random_Number.nextInt(6);
        int sum=die1+die2;
        System.out.println("The Player Rolled  "+die1+ " +"+die2+" ="+sum);
        return sum;
    }
}

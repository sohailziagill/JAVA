import java.security.SecureRandom;
import java.util.Scanner;

public class Quiz2_RollDice_Name_Limitations {
    public static class GamePlay {
        public void Process() {
            // For multiplayer we use the for loop

            boolean ischeck=false;

            int No_of_Player;
            System.out.println("Please Enter the Total number of PLayers");
            Scanner Input = new Scanner(System.in);
            No_of_Player = Input.nextInt();

            // For the Multi players turn
            for (int i = 0; i < No_of_Player; i++) {

                // If you want to End the Game before Completed all Players Trun.

                System.out.println("If you want to stop this Game at this Player Truns");
                System.out.println("Then Enter the 0  otherwise Enter the 1");
                System.out.println("\n\n");
                Scanner Choice = new Scanner(System.in);
                int choice = Choice.nextInt();
                if (choice == 0) {
                    System.out.println("The Game is Terminated.");
                    System.out.println("\n\n");
                    break;
                }
                String Name;
                System.out.println("Please Enter the Name of Player in Capiital Letters Like NAME ");
                Scanner Name1 = new Scanner(System.in);
                Name = Name1.next();
                System.out.println("\n\n");
                System.out.println("You have only 5 turns ");

                // For the Player's Turn
                int turns=5;
                // The  While loop will Terminate only when the Player wins the Game.
                while (turns>0) {

                    int iswon = 0;

                    // Now we have to Roll Two Dices and then sum
                    SecureRandom Random_Number = new SecureRandom();
                    int Num1 = Random_Number.nextInt(6) + 1;
                    int Num2 = Random_Number.nextInt(6) + 1;

                    // Now I am going to calculate the sum of both Roll Dices
                    int Sum;
                    Sum = Num1 + Num2;

                    //  Now I am going to convert these three numbers into character by using ASCCI code and its Values

                    char Var1 = (char) ('A' + Num1);
                    char Var2 = (char) ('A' + Num2);

                    System.out.println("The two RollDice numbers are "+Num1 +" and "+Num2);
                    // If we met the condition 1 then Player 1 won the match Terminated.

                    // To store the index for checking

                    // To store all the indexes
                    int Index1 = Name.indexOf(Var1);
                    int Index2 = Name.indexOf(Var2);

                    String s3=" ";
/// For the Alphabets

                    switch(Sum){
                        case 1:
                        {
                            s3="ONE";
                            break;
                        }
                        case 2:
                        {
                            s3="Two";
                            break;
                        }
                        case 3:
                        {
                            s3="THREE";
                            break;
                        }
                        case 4:
                        {
                            s3="FOUR";
                            break;
                        }
                        case 5:
                        {
                            s3="FIVE";
                            break;
                        }
                        case 6:
                        {
                            s3="SIX";
                            break;
                        }
                        case 7:
                        {
                            s3="SEVEN";
                            break;
                        }

                        case 8:
                        {
                            s3="EIGHT";
                            break;
                        }
                        case 9:
                        {
                            s3="NINE";
                            break;
                        }

                        case 10:
                        {
                            s3="TEN";
                            break;
                        }
                        case 11:
                        {
                            s3="ELEVEN";
                            break;
                        }
                        case 12:
                        {
                            s3="TWELEVE";
                            break;
                        }

                    }
                    // The end of Switch statement.
                    System.out.println("The number is "+s3);

                    int l1 = Name.length();
                    int l2 = s3.length();


                    for(int j=0;j<l2;j++)
                    {
                        int str1_ch = (int)s3.charAt(i);

                        for(int k=0;k<l1;k++)
                        {
                            int str2_ch = (int)Name.charAt(i);
                            char show=(char)(str2_ch);
                            if(str1_ch==str2_ch){
                                System.out.println("The found char is "+show);

                                ischeck=true;
                            }



                        }

                    }

                    // For the Condition 1 we need index3
                    if (ischeck) {
                        // If the index is greater than or equal to zero it means that this char is present in this name
                        System.out.println("\n\n");
                        System.out.println("The Player " + Name + " won the Match");

                        System.out.println("\n\n");
                        break;


                    } else if ((Index1 >= 0) || (Index2 >= 0)) {
                        // If the index is greater than or equal to zero it means that this char is present in this name

                        System.out.println("The Player " + Name + " won the Match");
                        System.out.println("The RollDice Numbers are  found in name of Player ");
                        System.out.println("The found character is one of this   "+Var1+"  or is  "+Var2 );
                        System.out.println("\n\n");
                        break;
                    } else {
                        // If the player got the 2 times the same sum then Player wins the game
                        if (Sum == iswon) {
                            System.out.println("The Player " + Name + " won the Match");
                            System.out.println("The Player got the as it is Sum of RollDice as previous  ");
                            System.out.println("The Numbers are  "+Sum+ " == "+iswon);
                            System.out.println("\n\n");
                            break;
                        }
                        else
                        {
                            turns--;
                            System.out.println("No Player wins the Game we are trying again");
                            System.out.println("You have only "+turns+ "turns left ");
                            System.out.println("\n\n");
                        }

                    }
                }

            }
        }
    }
    public  void main(String[] args){
        GamePlay Game=new GamePlay();
        Game.Process();
    }

}

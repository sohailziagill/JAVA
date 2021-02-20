import java.security.SecureRandom;

public class Game_of_chance_Craps {

    // Declaring the Enum to represent the game status

    private enum Status{
        CONTINUE,WON,LOST
    }

    // Some Constant that are represent the common roll dice
    private static final int SNAKE_EYES=2;
    private static final int TREY=3;
    private static final int SEVEN=7;
    private static final int YO_LEVEN=11;
    private static final int BOX_CARS=12;

    // Declaring the Main Function
    public static void main(String[] args){

        int My_Point=0;
        Status Game_Status;

        // The first roll of Dice
        int SumOfDice=RollDice();

        // Determine the Game Status and point based on first Roll

        switch(SumOfDice)
        {
            case SEVEN:
            case YO_LEVEN:
                Game_Status=Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                Game_Status=Status.LOST;
                break;
            default:
                Game_Status=Status.CONTINUE;
                My_Point=SumOfDice;
                System.out.println("Your Points are  "+My_Point);
                break;

        }


        // While The Game is Not completed then

        while(Game_Status==Status.CONTINUE)
        {
            SumOfDice=RollDice();

            // Winning by Making again the points equals

            if(SumOfDice==My_Point)
                Game_Status=Status.WON;

            else
            {
                // Lose by Rolling 7
                if(SumOfDice==SEVEN)
                    Game_Status=Status.LOST;

            }
        }

        // Display The Won or Lost Message

        if(Game_Status==Status.WON)
            System.out.println("The Palyer Wins");
        else
            System.out.println("The Player Loses");

    }


    // The RollDice Function it will Roll and Retrun the Sum of RollDices
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

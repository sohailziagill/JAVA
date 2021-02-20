
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Assignment_Tik_tak_toe_with_user_name_length {

    char player='x';              // Declaring for the Player
    public char[][] matrix ={{'1','2','3'},{'4','5','6'},{'7','8','9'}};      // possible posibilities



    // To Draw the Box of tik Tok Toe Game
    void draw()
    {

        System.out.println("\n The Tik Tok Toe Game.\n\n\n");

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(matrix[i][j]+"\t");      // To print Matrix Values

            }
            System.out.println();
        }
    }    // End of Draw function




    void input()
    {
        int a;
        Scanner myObj = new Scanner(System.in);

        System.out.println("\n Enter the number");

        a= myObj.nextInt();  // To read input from user form string to int
        /*For the string
         * Scanner myObj=new Scanner(System.in);
         * string Name;
         * System.Out.println("Enter your Name");
         * Name=myObj.next();
         * */





        if(a==1)
        {
            matrix[0][0]=player;

        }
        else if (a==2)
        {
            matrix[0][1]=player;

        }
        else if (a==3)
        {
            matrix[0][2]=player;

        }
        else if (a==4)
        {
            matrix[1][0]=player;

        }
        else if (a==5)
        {
            matrix[1][1]=player;

        }
        else if (a==6)
        {
            matrix[1][2]=player;

        }
        else if (a==7)
        {
            matrix[2][0]=player;

        }
        else if (a==8)
        {
            matrix[2][1]=player;

        }
        else if (a==9)
        {
            matrix[2][2]=player;

        }
        else
        {
            System.out.println("You Entered an Invalid Number");
        }






    }
    // End of Input Function

    // To change the turn of players
    void toggleplayer()
    {
        if(player=='x')
            player='o';
        else
            player='x';
    }// End of toggleplayer Function

    // To check wather any player Won
    char win()
    {


        // For 3 value possibilities


        //For first palyer.

        if(matrix[0][0]=='x'&&matrix[0][1]=='x'&&matrix[0][2]=='x')
            return 'x';
        if(matrix[1][0]=='x'&&matrix[1][1]=='x'&&matrix[1][2]=='x')
            return 'x';
        if(matrix[2][0]=='x'&&matrix[2][1]=='x'&&matrix[2][2]=='x')
            return 'x';
        if(matrix[0][0]=='x'&&matrix[1][0]=='x'&&matrix[2][0]=='x')
            return 'x';
        if(matrix[0][1]=='x'&&matrix[1][1]=='x'&&matrix[2][1]=='x')
            return 'x';
        if(matrix[0][2]=='x'&&matrix[1][2]=='x'&&matrix[2][2]=='x')
            return 'x';
        if(matrix[0][2]=='x'&&matrix[1][1]=='x'&&matrix[2][0]=='x')
            return 'x';
        if(matrix[0][0]=='x'&&matrix[1][1]=='x'&&matrix[2][2]=='x')
            return 'x';

        //For player two.
        if(matrix[0][0]=='o'&&matrix[0][1]=='o'&&matrix[0][2]=='o')
            return 'o';
        if(matrix[1][0]=='o'&&matrix[1][1]=='o'&&matrix[1][2]=='o')
            return 'o';
        if(matrix[2][0]=='o'&&matrix[2][1]=='o'&&matrix[2][2]=='o')
            return 'o';
        if(matrix[0][0]=='o'&&matrix[1][0]=='o'&&matrix[2][0]=='o')
            return 'o';
        if(matrix[0][1]=='o'&&matrix[1][1]=='o'&&matrix[2][1]=='o')
            return 'o';
        if(matrix[0][2]=='o'&&matrix[1][2]=='o'&&matrix[2][2]=='o')
            return 'o';
        if(matrix[0][2]=='o'&&matrix[1][1]=='o'&&matrix[2][0]=='o')
            return 'o';
        if(matrix[0][0]=='o'&&matrix[1][1]=='o'&&matrix[2][2]=='o')
            return 'o';


// At end of function
        return '/';

    }

    // The Main Function

    public static void main(String[]args){

        System.out.println("\n*******************************************************************:");
        System.out.println("\nProgrammer :  Sohail Zia Gill:");
        System.out.println("\nTitle: Tic Tak Toe Game :");

        System.out.println("\nDated : 21/Oct/2020:");
        System.out.println("\nCompiling date : 21/Oct/2020:");
        System.out.println(" \nInternational Islamic University Islamabad:");
        System.out.println("\n*******************************************************************:\n\n");

        String First_Player_Name;
        String Second_Player_Name;

        Scanner name1=new Scanner(System.in);
        Scanner name2=new Scanner(System.in);

        System.out.println("Enter the Name of Player 1: ");
        First_Player_Name=name1.next();


        System.out.println("Enter the Name of Player 2");

        Second_Player_Name=name2.next();

        int c=0;

        // To save the length of user

        int Name_Length;
        // TO save the result
        int result;

        Assignment_Tik_tak_toe_with_user_name_length Game;
        Game = new Assignment_Tik_tak_toe_with_user_name_length();
        Game.draw();
        while(c<9)//Number of turns.
        {
            Game.input();
            Game.draw();
            if(Game.win()=='x')
            {

                // To put the All givven conditions of name.length

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));



                Name_Length=First_Player_Name.length();

                // To get the minutes to full fill conditions

                result=now.getMinute()-Name_Length;
                if((result%2==1)||(result%2==-1))
                {
                    System.out.println("\nThe player     "+ First_Player_Name+"   is  winner ");
                    System.out.println("The producede number of Curr Time-Name.Length =  "+result);
                    break;
                }
                else
                {
                    System.out.println("You Lose MR. "+First_Player_Name);
                    System.out.println("The producede number of Curr Time-Name.Length =  "+result);
                    break;
                }


            }
            else if(Game.win()=='o')
            {


                // To put the All givven conditions of name.length

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));



                Name_Length=Second_Player_Name.length();

                // To get the minutes to full fill conditions

                result=now.getMinute()-Name_Length;
                if((result%2==1)||(result%2==-1))
                {
                    System.out.println("\nThe player    "+ Second_Player_Name+"     is  winner");
                    System.out.println("The producede number of Curr Time-Name.Length =  "+result);
                    break;
                }
                else
                {
                    System.out.println("You Lose MR. "+Second_Player_Name);
                    System.out.println("The producede number of Curr Time-Name.Length =  "+result);
                    break;
                }


            }
            Game.toggleplayer();
            c++;

        }
    }
    // The End of Main Function

}

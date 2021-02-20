package com.company;

import java.util.Scanner;

public class Tik_Tok_Toe {

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




        // For 2 values possibilities

        // For player 1

        // For 1
        if((matrix[0][0]=='x'&&matrix[1][1]=='x')||(matrix[0][0]=='x'&&matrix[1][2]=='x')||(matrix[0][0]=='x'&&matrix[0][1]=='x'))
            return 'x';


        // For 2
        if((matrix[0][1] == 'x' && matrix[0][2] == 'x')||(matrix[0][1] == 'x' && matrix[1][1] == 'x')||(matrix[0][1] == 'x' && matrix[1][0] == 'x'))
            return 'x';

        // For end of line value 3 has only the two possibilities

        if((matrix[0][2]=='x'&& matrix[1][1]=='x')||(matrix[0][2]=='x'&& matrix[1][2]=='x'))
            return 'x';

        // For 4
        if((matrix[1][0]=='x'&& matrix[1][1]=='x')||(matrix[1][0]=='x'&&matrix[2][0]=='x')||(matrix[1][0]=='x'&& matrix[2][1]=='x'))
            return 'x';

        // For 5
        if((matrix[1][1]=='x'&& matrix[2][0]=='x')||(matrix[1][1]=='x'&&matrix[2][1]=='x')||(matrix[1][1]=='x'&&matrix[2][2]=='x')||(matrix[1][1]=='x'&&matrix[1][2]=='x'))
            return 'x';
        // For 6

// For end of line value 6 has only the two possibilities

        if((matrix[1][2]=='x'&& matrix[2][1]=='x')||(matrix[1][2]=='x'&& matrix[2][2]=='x'))
            return 'x';

        // For 7 has only the two possibilities

        if(matrix[2][0]=='x'&& matrix[2][1]=='x')
            return 'x';

        // For 8 has one possibility
        if(matrix[2][1]=='x'&&matrix[2][2]=='x')
            return 'x';

        // For 9 no possibility left


        // For player 2

// For 1
        if((matrix[0][0]=='o'&&matrix[1][1]=='o')||(matrix[0][0]=='o'&&matrix[1][2]=='o')||(matrix[0][0]=='o'&&matrix[0][1]=='o'))
            return 'o';


        // For 2
        if((matrix[0][1] == 'o' && matrix[0][2] == 'o')||(matrix[0][1] == 'o' && matrix[1][1] == 'o')||(matrix[0][1] == 'o' && matrix[1][0] == 'o'))
            return 'o';

        // For end of line value 3 has only the two possibilities

        if((matrix[0][2]=='o'&& matrix[1][1]=='o')||(matrix[0][2]=='o'&& matrix[1][2]=='o'))
            return 'o';

        // For 4
        if((matrix[1][0]=='o'&& matrix[1][1]=='o')||(matrix[1][0]=='o'&&matrix[2][0]=='o')||(matrix[1][0]=='o'&& matrix[2][1]=='o'))
            return 'o';

        // For 5
        if((matrix[1][1]=='o'&& matrix[2][0]=='o')||(matrix[1][1]=='o'&&matrix[2][1]=='o')||(matrix[1][1]=='o'&&matrix[2][2]=='o')||(matrix[1][1]=='o'&&matrix[1][2]=='o'))
            return 'o';
        // For 6

// For end of line value 6 has only the two possibilities

        if((matrix[1][2]=='o'&& matrix[2][1]=='o')||(matrix[1][2]=='o'&& matrix[2][2]=='o'))
            return 'o';

        // For 7 has only the two possibilities

        if(matrix[2][0]=='o'&& matrix[2][1]=='o')
            return 'o';

        // For 8 has one possibility
        if(matrix[2][1]=='o'&&matrix[2][2]=='o')
            return 'o';

        // For 9 no possibility left




// At end of function
        return '/';

    }


    // End of Win Function
/*
    // To check whether number is duplicated
    boolean Duplicate(int pos)
    {
        // If duplicated then return the false
        //and return true if not duplicated
        boolean option=true;
        switch (pos) {
            case 1:
                if (matrix[0][0] != '1')
                {
                    option = false;
                    break;
                }

            case 2:
                if (matrix[0][1] != '2')
                {
                    option = false;
                    break;
                }

            case 3:
                if (matrix[0][2] != '3')
                {
                    option = false;
                    break;
                }

            case 4:
                if (matrix[1][0] != '4')
                {
                    option = false;
                    break;
                }

            case 5:
                if (matrix[1][1] != '5')
                {
                    option = false;
                    break;
                }

            case 6:
                if (matrix[1][2] != '6')
                {
                    option = false;
                    break;
                }

            case 7:
                if (matrix[2][0] != '7')
                {
                    option = false;
                    break;
                }

            case 8:
                if (matrix[2][1] != '8')
                {
                    option = false;
                    break;
                }
            case 9:
                if (matrix[2][2] != '9')
                {
                    option = false;
                    break;
                }



        }
        return option;
    }
    // The End of Duplicate Function

*/
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
        Tik_Tok_Toe Game;
        Game = new Tik_Tok_Toe();
        Game.draw();
        while(c<9)//Number of turns.
        {
            Game.input();
            Game.draw();
            if(Game.win()=='x')
            {
                System.out.println("\nThe player     "+ Second_Player_Name+"   is  winner ");
                break;
            }
            else if(Game.win()=='o')
            {
                System.out.println("\nThe player    "+ First_Player_Name+"     is  winner");
                break;
            }
            Game.toggleplayer();
            c++;

        }
    }
    // The End of Main Function
}

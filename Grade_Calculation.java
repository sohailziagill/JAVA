import java.util.Scanner;

public class Grade_Calculation {
    public static String GradeCal(int marks)
    {

        String grade;
        if(marks>79)
            grade="A";
        else if(marks>74 & marks<80)
            grade="B+";
        else if(marks>69 & marks<75)
            grade="B";
        else if(marks>64 & marks<70)
            grade="C+";
        else if(marks>59 & marks<65)
            grade="C";
        else
            grade="F";

        return grade;




    }
    public static void main(String[]args) {
        int Marks;
        do {
            System.out.println("Please Enter your Marks out of 100");
            Scanner num = new Scanner(System.in);
            Marks = num.nextInt();
            if (Marks < 0 || Marks > 100)
                System.out.println("You Entered An Invalid Number ");
        } while ((Marks< 0) || (Marks > 100));

        String Grade = GradeCal(Marks);
        System.out.println("Your Grade Against numbers  " + Marks + "  is  " + Grade);
    }


}

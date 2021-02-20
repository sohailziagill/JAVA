import javax.naming.Name;
import java.util.Scanner;
public class Account_Class {
    private String FullName;
    private String InitName;
    private String LastName;
    private int Blanace;
    // The class Constructor
    Account_Class(String Name1)
    {
        this.InitName=Name1;
    }


    // To set the Name by using function
    public void SetName(String Name, int balance){
        this.LastName=Name;
        this.Blanace=balance;
        this.FullName=InitName+LastName;
    }
    // To Return the Full Name
    public String GetName(){
        return FullName;

    }
    public int GetBalance()
    {
        return Blanace;
    }
    public static void main(String[] args)
    {







        // By using the Constructor
        // To create an object of Account_Class and we can access all functions of that class
        Account_Class Account=new Account_Class("Taimoor");
        System.out.println("Enter the Last Name for  "+Account.InitName);
        // To create the scanner object
        Scanner input=new Scanner(System.in);

        String Name = input.nextLine();

        // For the Balance
        System.out.println("Enter the Balance for Account");
        Scanner balance=new Scanner(System.in);
        int Blanace=balance.nextInt();
// Set the Full Name
        Account.SetName(Name,Blanace);
// To display the Full Name
        System.out.println("The Full Name is  "+Account.GetName()+"   And Balance is "+Account.GetBalance());


        // I am going to create an other class of Account with Default Values
        Account_Class Account1=new Account_Class("Ahmed");
        System.out.println("Enter the Last Name for  "+Account.InitName);
        // To create the scanner object

        Scanner input1=new Scanner(System.in);
        String Name1 = input1.nextLine();

        // For the Balance
        System.out.println("Enter the Balance for Account");
        Scanner balance1=new Scanner(System.in);
        int Blanace1=balance1.nextInt();
        Account1.SetName(Name1,Blanace1);
        // To display the Full Name
        System.out.println("The Full Name is  "+Account1.GetName()+"   And Balance is "+Account1.GetBalance());


    }

}

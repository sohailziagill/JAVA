import java.sql.*;
import java.util.Scanner;

public class Bank_Project {
    String url="jdbc:mysql://localhost/bank_management_system";
    String user="root";
    String password="";

    String sql = "";


    public Bank_Project() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        Bank_Project bank_project=new Bank_Project();
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Welcome to Sohail Zia Gill's Bank Database Management System");
            System.out.println( "Enter 1 for New Registration of Bank Employee ");
            System.out.println( "Enter 2 for Bank Employee Log In");
            System.out.println( "Enter 3 for New Registration of Customer ");
            System.out.println( "Enter 4 for Customer Log In");
            System.out.println( "Enter 5 for New Loan for  Customer ");
            System.out.println( "Enter 6 and any wrong no for EXIT()!!!");
            choice = scanner.nextInt();

            if(choice<0 ||choice>6)
                System.out.println("You have entered an invalid choice :: Please Enter Again");
            else
            {
                switch (choice){
                    case 1:
                    {

                        System.out.println("Welcome to New Registration for Bank Employee Menu");
                        bank_project.Bank_Employee_Registration();


                        break;
                    }
                    case 2:
                    {
                        System.out.println("Welcome to  Bank Employee Log In Menu");

                        bank_project.Bank_Employee_LogIn();

                        break;
                    }
                    case 3:
                    {
                        System.out.println("Welcome to New Registration for  Customer Menu");
                        bank_project.Customer_Registration();



                        break;
                    }
                    case 4:
                    {

                        System.out.println("Welcome to Customer Log In Menu");
                        bank_project.Customer_LogIn();

                        break;
                    }
                    case 5:
                    {
                        System.out.println("Welcome to New LOan for Customer Menu");
                        bank_project.Loan();


                        break;
                    }

                }
            }
        }while(choice!=6);


    }

    private void Loan() {
    }

    private void Customer_LogIn() {
    }

    private void Customer_Registration() {
    }

    private void Bank_Employee_LogIn() {
    }

    private void Bank_Employee_Registration() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        String username;
        String password;
        String name;
        String email;
        String phone;
        System.out.println("Enter Your User Name");
        username=scanner.next();
        System.out.println("Enter Your Password");
        password=scanner.next();
        System.out.println("Enter Your Name");
        name=scanner.next();
        System.out.println("Enter Your Email");
        email=scanner.next();
        System.out.println("Enter Your Phone in Format (03XX-XXXXXXX)");
        phone=scanner.next();
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            sql="INSERT INTO `bankemployee`(`UserName`, `Password`, `Name`, `Email`, `Phone`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])"+
                    username+password+name+email+phone;
            ResultSet resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

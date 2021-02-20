import java.sql.*;
import java.util.Scanner;

public class Bank_Project {
    String url = "jdbc:mysql://localhost/bank_management_system";
    String user = "root";
    String password1 = "";

    String sql = "";

    static class Bank_Employee {
        String E_username, E_password, E_name, E_email, E_phone;

        Bank_Employee() {

        }

        public void Collect_Money() {
            System.out.println("You are Collecting the Money");
            System.out.println("Finished.");
        }

        public void Giving_Money() {
            System.out.println("You are Giving the Money");
            System.out.println("Finished.");
        }
    }

    public Bank_Project() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to Sohail Zia Gill and Sheraz Iqbal Khan's Bank Database Management System");
            System.out.println("Enter 1 for New Registration of Bank Employee ");
            System.out.println("Enter 2 for Bank Employee Log In");
            System.out.println("Enter 3 for New Registration of Customer ");
            System.out.println("Enter 4 for Customer Log In");
            System.out.println("Enter 5 for New Loan for  Customer ");
            System.out.println("Enter 6 and any wrong no for EXIT()!!!");
            choice = scanner.nextInt();

            if (choice < 0 || choice > 6)
                System.out.println("You have entered an invalid choice :: Please Enter Again");
            else {
                switch (choice) {
                    case 1: {

                        System.out.println("Welcome to New Registration for Bank Employee Menu");
                        Bank_Employee_Registration bank_employee_registration=new Bank_Employee_Registration();
                        bank_employee_registration.run();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Welcome to  Bank Employee Log In Menu");

                        Bank_Employee_LogIn bank_employee_logIn=new Bank_Employee_LogIn();
                        bank_employee_logIn.run();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Welcome to New Registration for  Customer Menu");
                        Customer_Registration customer_registration=new Customer_Registration();
                        customer_registration.run();


                        break;
                    }
                    case 4: {

                        System.out.println("Welcome to Customer Log In Menu");
                        Customer_LogIn customer_logIn=new Customer_LogIn();
                        customer_logIn.run();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Welcome to New LOan for Customer Menu");
                        Loan loan= new Loan();
                        loan.run();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;
                    }

                }
            }
        } while (choice != 6);


    }

    public static class Loan extends Thread {
        String url = "jdbc:mysql://localhost/bank_management_system";
        String user = "root";
        String password1 = "";

        String sql = "";
        public synchronized void process(){

            Scanner scanner = new Scanner(System.in);
            String username;
            String password;
            System.out.println("Enter Your User Name");
            username = scanner.next();
            System.out.println("Enter Your Password");
            password = scanner.next();
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");

                String q = "Select * from customer where UserName='" + username + "' and Password='" + password + "'";

                // to execute query
                ResultSet rs = statement.executeQuery(q);
                if (rs.next())
                    System.out.println("Welcome Mr." + rs.getString("Name"));
                else
                    System.out.println("An invalid UserName or Password");
            } catch (SQLException e) {
                e.printStackTrace();
            }


            System.out.println("Welcome to the Loan Management System");

            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");
                sql = "INSERT INTO `loan`(`UserName`, `Password`, `Amount`, `Interest_Rate`, `Purpose`)VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, 0);
                preparedStatement.setString(5, "");


            } catch (SQLException e) {
                e.printStackTrace();
            }
            Scanner sc=new Scanner(System.in);
            int option3;
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");

                String q = "Select * from Loan where UserName='" + username + "' and Password='" + password + "'";

                // to execute query
                ResultSet rs = statement.executeQuery(q);

                String Purpose;
                int count;
                int amount;
                String query2;
                String query3;

                do {
                    System.out.println("\n-------------------");
                    System.out.println("W  E  L  C  O  M  E");
                    System.out.println("-------------------\n");
                    System.out.println("1. Check Loan Amount.");
                    System.out.println("2. Education Loan       (5,000 PKR).");
                    System.out.println("3.Family Support Loan   (10,000 PKR).");
                    System.out.println("4. Health Care Loan     (15,000 PKR).");
                    System.out.println("5. Home Loan            (20,0000 PKR).");
                    System.out.println("6. Business Loan        (100,000 PKR).");
                    System.out.println("7. Log out from Loan Section .");
                    System.out.print("\nEnter your choice : ");
                    option3 = sc.nextInt();
                    sc.nextLine();
                    switch (option3){
                        case 1:



                            System.out.println("Your Loan Amount is "+rs.getInt("Amount"));
                            break;
                        case 2:
                            System.out.println("Enter Purpose of Loan in Detail : ");
                            Purpose = sc.next();

                            amount=rs.getInt("Amount");
                            amount=amount+50000;
                            query2 =  "Update loan Set Purpose="+Purpose;
                            query3 =  "Update loan Set Amount="+Purpose;
                            count = statement.executeUpdate(query2);
                            System.out.println("Number of rows updated by executing query2 =  " + count);
                            count = statement.executeUpdate(query3);
                            System.out.println("Number of rows updated by executing query3 =  " + count);
                            break;
                        case 3:
                            System.out.println("Enter Purpose of Loan in Detail : ");
                            Purpose = sc.next();

                            amount=rs.getInt("Amount");
                            amount=amount+10000;
                            query2 =  "Update loan Set Purpose="+Purpose;
                            query3 =  "Update loan Set Amount="+Purpose;
                            count = statement.executeUpdate(query2);
                            System.out.println("Number of rows updated by executing query2 =  " + count);
                            count = statement.executeUpdate(query3);
                            System.out.println("Number of rows updated by executing query3 =  " + count);
                            break;
                        case 4:
                            System.out.println("Enter Purpose of Loan in Detail : ");
                            Purpose = sc.next();

                            amount=rs.getInt("Amount");
                            amount=amount+15000;
                            query2 =  "Update loan Set Purpose="+Purpose;
                            query3 =  "Update loan Set Amount="+Purpose;
                            count = statement.executeUpdate(query2);
                            System.out.println("Number of rows updated by executing query2 =  " + count);
                            count = statement.executeUpdate(query3);
                            System.out.println("Number of rows updated by executing query3 =  " + count);
                            break;
                        case 5:
                            System.out.println("Enter Purpose of Loan in Detail : ");
                            Purpose = sc.next();

                            amount=rs.getInt("Amount");
                            amount=amount+20000;
                            query2 =  "Update loan Set Purpose="+Purpose;
                            query3 =  "Update loan Set Amount="+Purpose;
                            count = statement.executeUpdate(query2);
                            System.out.println("Number of rows updated by executing query2 =  " + count);
                            count = statement.executeUpdate(query3);
                            System.out.println("Number of rows updated by executing query3 =  " + count);
                            break;
                        case 6:
                            System.out.println("Enter Purpose of Loan in Detail : ");
                            Purpose = sc.next();

                            amount=rs.getInt("Amount");
                            amount=amount+100000;
                            query2 =  "Update loan Set Purpose="+Purpose;
                            query3 =  "Update loan Set Amount="+Purpose;
                            count = statement.executeUpdate(query2);
                            System.out.println("Number of rows updated by executing query2 =  " + count);
                            count = statement.executeUpdate(query3);
                            System.out.println("Number of rows updated by executing query3 =  " + count);
                            break;
                        case 7:
                            break;
                        default:System.out.println("An inValid Choice:");

                    }
                }while((option3!=7));

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            process();
        }


    }

    public static class Customer_LogIn extends Thread {

        String url = "jdbc:mysql://localhost/bank_management_system";
        String user = "root";
        String password1 = "";

        String sql = "";
        public  synchronized void process(){
            Scanner scanner = new Scanner(System.in);
            String username;
            String password;
            System.out.println("Enter Your User Name");
            username = scanner.next();
            System.out.println("Enter Your Password");
            password = scanner.next();
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");

                String q = "Select * from customer where UserName='" + username + "' and Password='" + password + "'";

                // to execute query
                ResultSet rs = statement.executeQuery(q);
                if (rs.next())
                    System.out.println("Welcome Mr." + rs.getString("Name"));
                else
                    System.out.println("An invalid UserName or Password");
            } catch (SQLException e) {
                e.printStackTrace();
            }






            Scanner sc=new Scanner(System.in);

            int choice;
            do{

                System.out.println("\n-------------------");
                System.out.println("W  E  L  C  O  M  E");
                System.out.println("-------------------\n");
                System.out.println("1.Amount Deposit.");
                System.out.println("2. Transfer Amount.");
                System.out.println("3. WithDraw Amount.");
                System.out.println("4. Last 5 transactions.");
                System.out.println("5. Account Holder information.");
                System.out.println("6. Update accounts.");
                System.out.println("7. Log out.");
                System.out.print("\nEnter your choice : ");
                choice = sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:
                        System.out.print("Enter amount : ");

                        double amount1;
                        double amount = sc.nextDouble();

                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();

                            String q = "Select * from customer where UserName='" + username + "' and Password='" + password + "' ";

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);

                            amount1= rs.getDouble("Balance");

                            amount=amount+amount1;

                            sql="Update customer Set Balance='"+amount+"' where UserName='" + username;
                            int count = statement.executeUpdate(sql);
                            System.out.println("Number of rows updated by executing query2 =  " + count);


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }


                        break;
                    case 2:

                        System.out.print("Enter payee username : ");
                        String username1 = sc.next();
                        sc.nextLine();
                        System.out.println("Enter amount : ");

                        double amount3 = sc.nextDouble();
                        sc.nextLine();
                        if(amount3 > 300000)
                        {
                            System.out.println("Transfer limit exceeded. Contact bank manager.");
                            break;
                        }
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();
                            System.out.println("Connected database successfully...");

                            String q = "Select * from customer where UserName='" + username1;

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);
                            if (rs.next()) {
                                double amount2;
                                amount2=rs.getDouble("Blanace");
                                amount2=amount2+amount3;

                                sql="Update customer Set Balance='"+amount2+"' where UserName='" + username1;
                                int count = statement.executeUpdate(sql);
                                System.out.println("Number of rows updated by executing query2 =  " + count);


                                String q1= "Select * from customer where UserName='" + username;

                                // to execute query
                                ResultSet rs1 = statement.executeQuery(q);

                                double amount5;

                                amount5= rs1.getDouble("Balance");

                                amount5=amount5-amount3;

                                sql="Update customer Set Balance='"+amount5+"' where UserName='" + username;
                                count = statement.executeUpdate(sql);
                                System.out.println("Number of rows updated by executing query2 =  " + count);

                            }

                            else
                                System.out.println("The Entered  UserName is Registered Here");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }




                        break;

                    case 3:
                        System.out.println("Enter amount : ");

                        amount = sc.nextDouble();


                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();

                            String q = "Select * from customer where UserName='" + username;

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);

                            amount1= rs.getDouble("Balance");

                            amount=amount-amount1;

                            sql="Update customer Set Balance='"+amount+"' where UserName='" + username;
                            int count = statement.executeUpdate(sql);
                            System.out.println("Number of rows updated by executing query2 =  " + count);


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }



                        break;
                    case 4:

                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();

                            String q = "Select * from customer where UserName='" + username;

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);

                            while (rs.next()) {

                                System.out.println("The Transection 1 is "+rs.getInt("Transection1"));
                                System.out.println("The Transection 2 is "+rs.getInt("Transection2"));
                                System.out.println("The Transection 3 is "+rs.getInt("Transection3"));
                                System.out.println("The Transection 4 is "+rs.getInt("Transection4"));
                                System.out.println("The Transection 5 is "+rs.getInt("Transection5"));

                            }





                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:


                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();

                            String q = "Select * from customer where UserName='" + username;

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);

                            while (rs.next()) {

                                System.out.println("Accountholder User Name : "+rs.getString("UserName"));
                                System.out.println("Accountholder Name : "+rs.getString("Name"));
                                System.out.println("Accountholder Phone No : "+rs.getString("Phone"));
                                System.out.println("Accountholder Email : "+rs.getString("Email"));

                            }





                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 6:
                        System.out.println("Your Account is Updated");
                        break;

                    default:
                        System.out.println("Wrong choice !");
                }
            }while(choice!=7);

        }

        @Override
        public void run() {
            process();
        }


    }


    public static class Customer_Registration extends Thread {

        String url = "jdbc:mysql://localhost/bank_management_system";
        String user = "root";
        String password1 = "";

        String sql = "";
        public  synchronized void process(){
            Scanner scanner = new Scanner(System.in);


            String username;
            String password;
            String name;
            String phone = null;
            int balance;
            int transection1 = 0;
            int transection2 = 0;
            int transection3 = 0;
            int transection4 = 0;
            int transection5 = 0;
            String email;
            System.out.println("Enter Your User Name");
            username = scanner.next();
            System.out.println("Enter Your Password");
            password = scanner.next();
            System.out.println("Enter Your Name");
            name = scanner.next();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Phone in Format (03XX-XXXXXXX)");
            phone = sc.next();
            System.out.println("Enter Initial Deposit  in your Balanec Account");
            balance = scanner.nextInt();
            System.out.println("Enter Your Email");
            email = scanner.next();
            transection1 = balance;
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");
                sql = "INSERT INTO `customer`(`UserName`, `Password`, `Name`, `Phone`, `Balance`, `Transection1`, `Transection2`, `Transection3`, `Transection4`, `Transection5`, `Email`)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, phone);
                preparedStatement.setInt(5, balance);
                preparedStatement.setInt(6, transection1);
                preparedStatement.setInt(7, transection2);
                preparedStatement.setInt(8, transection3);
                preparedStatement.setInt(9, transection4);
                preparedStatement.setInt(10, transection5);
                preparedStatement.setString(11, email);


                preparedStatement.executeUpdate();


                System.out.println("Inserted");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            process();
        }



    }


    public static class  Bank_Employee_LogIn extends Thread {

        String url = "jdbc:mysql://localhost/bank_management_system";
        String user = "root";
        String password1 = "";

        String sql = "";

        public synchronized void process(){
            Scanner scanner = new Scanner(System.in);
            String username;
            String password;
            System.out.println("Enter Your User Name");
            username = scanner.next();
            System.out.println("Enter Your Password");
            password = scanner.next();
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");

                String q = "Select * from bankemployee where UserName='" + username + "' and Password='" + password + "'";

                // to execute query
                ResultSet rs = statement.executeQuery(q);
                if (rs.next())
                    System.out.println("Welcome Mr." + rs.getString("Name"));
                else
                    System.out.println("An invalid UserName or Password");
            } catch (SQLException e) {
                e.printStackTrace();
            }



            Scanner sc=new Scanner(System.in);
            Bank_Employee bank_employee=new Bank_Employee();
            int option1;
            //  while(true)
            do{
                System.out.println("\n-------------------");
                System.out.println("W  E  L  C  O  M  E      E M P L O Y E E ");
                System.out.println("-------------------\n");
                System.out.println("1. Collecting Money.");
                System.out.println("2. Giving  Money.");
                System.out.println("3. Employee Account information.");
                System.out.println("4. Update accounts.");
                System.out.println("5. To see Customers accounts.");
                System.out.println("6. To see Bank Employees  accounts.");
                System.out.println("7. Log out.");
                System.out.print("\nEnter your choice : ");
                option1 = sc.nextInt();
                sc.nextLine();
                switch (option1){
                    case 1:
                        bank_employee.Collect_Money();
                        break;
                    case 2:
                        bank_employee.Giving_Money();
                        break ;
                    case 3:
                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();
                            System.out.println("Connected database successfully...");

                            String q = "Select * from bankemployee where UserName='" + username + "' and Password='" + password + "'";

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);
                            if (rs.next()) {
                                System.out.println("Employee Accountholder UserName : "+rs.getString("UserName"));
                                System.out.println("Employee Accountholder  Name : "+rs.getString("Name"));
                                System.out.println("Employee Accountholder Email : "+rs.getString("Email"));
                                System.out.println("Employee Accountholder Phone : "+rs.getString("Phone"));
                            }

                            else
                                System.out.println("An invalid UserName or Password");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }





                        break ;
                    case 4:
                        System.out.println("Enter username : ");
                        String username1 = sc.next();

                        System.out.println("Your Account is Updated");



                        break;
                    case 5:



                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();
                            System.out.println("Connected database successfully...");

                            String q = "Select * from customer";
                            // to execute query
                            ResultSet rs = statement.executeQuery(q);
                            while (rs.next()){
                                System.out.println("The Customer UserName is "+rs.getString("UserName"));
                                System.out.println("The Customer Name is "+rs.getString("Name"));
                                System.out.println("The Customer Phone is "+rs.getString("Phone"));
                                System.out.println("The Customer Email is "+rs.getString("Email"));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }











                        break ;


                    case 6:

                        try {
                            Connection connection = DriverManager.getConnection(url, user, password1);
                            Statement statement = connection.createStatement();
                            System.out.println("Connected database successfully...");

                            String q = "Select * from bankemployee";

                            // to execute query
                            ResultSet rs = statement.executeQuery(q);


                            while (rs.next()){
                                System.out.println("The Bank Employee  UserName is "+rs.getString("UserName"));
                                System.out.println("The Employee Name is "+rs.getString("Name"));
                                System.out.println("The Employee Phone is "+rs.getString("Phone"));
                                System.out.println("The Employee Email is "+rs.getString("Email"));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }









                        break ;


                    default:
                        break;

                }
            }while(option1!=7);
        }

        @Override
        public void run() {
            process();
        }



                                }

    public static class   Bank_Employee_Registration  extends Thread {

        String url = "jdbc:mysql://localhost/bank_management_system";
        String user = "root";
        String password1 = "";

        String sql = "";

        public void process() {
            Scanner scanner = new Scanner(System.in);
            String username;
            String password;
            String name;
            String email;
            String phone;
            System.out.println("Enter Your User Name");
            username = scanner.next();
            System.out.println("Enter Your Password");
            password = scanner.next();
            System.out.println("Enter Your Name");
            name = scanner.next();
            System.out.println("Enter Your Email");
            email = scanner.next();
            System.out.println("Enter Your Phone in Format (03XX-XXXXXXX)");
            phone = scanner.next();
            try {
                Connection connection = DriverManager.getConnection(url, user, password1);
                Statement statement = connection.createStatement();
                System.out.println("Connected database successfully...");
                sql = "INSERT INTO `bankemployee`(`UserName`, `Password`, `Name`, `Email`, `Phone`) VALUES (?,?,?,?,?)";
                //  statement.executeUpdate("INSERT INTO bankemployee values("+username+","+name+","+email+","+phone+")");

                //sql="INSERT INTO `bankemployee`(`UserName`, `Password`, `Name`, `Email`, `Phone`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])"
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, phone);
                preparedStatement.executeUpdate();
                System.out.println("Inserted");
                //statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }

        @Override
        public void run() {
            process();
        }
    }
}


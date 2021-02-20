import java.io.*;
import java.text.NumberFormat;
import java.util.*;


public class Fileing_Project {

    interface SavingsAccount
    {
        double rate = 0.04,limit = 10000,limit1 = 200;
        void deposit(double n, Date d);
        void withdraw(double n,Date d);
    }

    static class Bank_Employee implements Serializable
    {
        String E_username,E_password,E_name,E_address,E_phone;
        Bank_Employee(String e_username,String e_password,String e_name,String e_address,String e_phone)
        {
            this.E_username=e_username;
            this.E_password=e_password;
            this.E_name=e_name;
            this.E_address=e_address;
            this.E_phone=e_phone;
        }
        public void Collect_Money()
        {
            System.out.println("You are Collecting the Money");
            System.out.println("Finished.");
        }
        public void Giving_Money()
        {
            System.out.println("You are Giving the Money");
            System.out.println("Finished.");
        }
    }
    static class Loan{
        String L_username;
        String L_Purpose;
        double L_Amount=0;


    }

    static class Customer implements SavingsAccount,Serializable
    {
        String username,password,name,address,phone;
        double balance;
        ArrayList<String> transactions;
        Customer(String username,String password,String name,String address,String phone,double balance,Date date)
        {
            this.username = username;
            this.password = password;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.balance = balance;
            transactions  =  new ArrayList<String>(5);
            addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
        }
        void update(Date date)
        {
            if(balance>= 10000)
            {
                balance += rate*balance;
            }
            else
            {
                balance -= (int)(balance/100.0);
            }
            addTransaction(String.format("Account updated. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
        }
        @Override
        public void deposit(double amount,Date date)
        {
            balance += amount;
            addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
        }
        @Override
        public void withdraw(double amount,Date date)
        {
            if(amount>(balance-200))
            {
                System.out.println("Insufficient balance.");
                return;
            }
            balance -= amount;
            addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
        }
        private void addTransaction(String message)
        {
            transactions.add(0,message);
            if(transactions.size()>5)
            {
                transactions.remove(5);
                transactions.trimToSize();
            }
        }
    }


    static class Bank
    {
        Map<String,Customer> customerMap;
        Map<String,Bank_Employee> Bank_EmployeeMap;
        Bank()
        {
            customerMap = new HashMap<String,Customer>();
            Bank_EmployeeMap=new HashMap<String,Bank_Employee>();
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {



            Scanner sc  =  new Scanner(System.in);
            Customer customer;
            Bank_Employee bank_employee;
            String username,password;
            double amount;
            Bank bank  =  new Bank();
            int choice;



            //Fileing of Customer Read from the Customer Create if not already exists.

            File My_Customer = new File("MyCustomerFile.txt");
            try {

                if (My_Customer.createNewFile()) {
                    System.out.println("File created: " + My_Customer.getName());

                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.println("File name: " + My_Customer.getName());
            System.out.println("Absolute path: " + My_Customer.getAbsolutePath());








            //Fileing of Customer Map Read from the Customer Create if not already exists.

            File My_CustomerMap = new File("MyCustomerFileMap.txt");
            try {

                if (My_CustomerMap.createNewFile()) {
                    System.out.println("File created: " + My_CustomerMap.getName());

                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.println("File name: " + My_CustomerMap.getName());
            System.out.println("Absolute path: " + My_CustomerMap.getAbsolutePath());












            //Fileing of Bank Employees to Read from the Customer Create if not already exists.

            File My_Bank_Employee= new File("MyBankEmployeeFile.txt");
            try {

                if (My_Bank_Employee.createNewFile()) {
                    System.out.println("File created: " + My_Bank_Employee.getName());

                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("File name: " + My_Bank_Employee.getName());
            System.out.println("Absolute path: " + My_Bank_Employee.getAbsolutePath());









            //Fileing of Bank Employees to Read from the Customer Create if not already exists.

            File My_Bank_EmployeeMap= new File("MyBankEmployeeFileMap.txt");
            try {

                if (My_Bank_EmployeeMap.createNewFile()) {
                    System.out.println("File created: " + My_Bank_EmployeeMap.getName());

                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("File name: " + My_Bank_EmployeeMap.getName());
            System.out.println("Absolute path: " + My_Bank_EmployeeMap.getAbsolutePath());

































            outer: while(true)

            {
                System.out.println("\n-------------------");
                System.out.println("Allied  Bank  Limited");
                System.out.println("-------------------\n");
                System.out.println("1.For Bank Employees .");
                System.out.println("2. New Customer Account Registration.");
                System.out.println("3. Customer Login.");
                System.out.println("4. For Bank Loan.");
                System.out.println("5. Exit.");
                System.out.print("\nEnter your choice : ");
                choice = sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:

                        int option;
                        Bank_Employee_Logout:do {

                            System.out.println("1. For Bank Employee Login.");
                            System.out.println("2.New Bank Employee Registration.");
                            System.out.println("3.Exit.");
                            System.out.print("\nEnter your choice : ");
                            option = sc.nextInt();
                            sc.nextLine();
                            switch (option) {
                                case 1:
                                    // For Employee Login
                                    // First of all reload the all data from the File MyBankEmployeeMap.txt

                                    File file = new File("MyBankEmployeeFileMap.txt");
                                    FileInputStream f = new FileInputStream(file);
                                    ObjectInputStream s = new ObjectInputStream(f);
                                    bank.Bank_EmployeeMap=(HashMap<String,Bank_Employee>) s.readObject();
                                    s.close();







                                    System.out.println("Enter username : ");
                                    username = sc.next();
                                    sc.nextLine();
                                    System.out.println("Enter password : ");
                                    password = sc.next();
                                    sc.nextLine();
                                    if(bank.Bank_EmployeeMap.containsKey(username))
                                    {
                                        bank_employee = bank.Bank_EmployeeMap.get(username);
                                        if(bank_employee.E_password.equals(password))
                                        {
                                            int option1;
                                            while(true)
                                            {
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
                                                        System.out.println("Employee Accountholder user name : "+bank_employee.E_username);
                                                        System.out.println("Employee Accountholder  name : "+bank_employee.E_name);
                                                        System.out.println("Employee Accountholder phone : "+bank_employee.E_phone);
                                                        System.out.println("Employee Accountholder address : "+bank_employee.E_address);




                                                        break ;
                                                    case 4:
                                                        System.out.println("Enter username : ");
                                                        String username1 = sc.next();
                                                        if(bank.Bank_EmployeeMap.containsKey(username1))
                                                        {
                                                            System.out.println("Your Account is Updated");
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Username doesn't exist.");
                                                        }

                                                        break;
                                                    case 5:
                                                        //  // First of all reload the file data of MyCustomerFile.txt  and use it.

                                                        InputStream fileIs5 = null;
                                                        ObjectInputStream objIs5 = null;
                                                        try {
                                                            fileIs5 = new FileInputStream("MyCustomerFile.txt");
                                                            objIs5 = new ObjectInputStream(fileIs5);

                                                            customer =(Customer) objIs5.readObject();

                                                            System.out.println("The Customer name is "+customer.name);
                                                            System.out.println("The Customer address is "+customer.address);
                                                            System.out.println("The Customer phone is "+customer.phone);
                                                            System.out.println("The Customer username is "+customer.username);




                                                        } catch (FileNotFoundException e) {
                                                            e.printStackTrace();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        } catch (ClassNotFoundException e) {
                                                            e.printStackTrace();
                                                        }
                                                        finally {
                                                            try {
                                                                if(objIs5 != null) objIs5.close();
                                                            } catch (Exception ex){

                                                            }
                                                        }
                                                        break ;


                                                    case 6:
//First of all reload the file  data of MyEmployeeFile.txt  and use it.

                                                        InputStream fileIs3 = null;
                                                        ObjectInputStream objIs3 = null;
                                                        try {
                                                            fileIs3 = new FileInputStream("MyBankEmployeeFile.txt");
                                                            objIs3 = new ObjectInputStream(fileIs3);

                                                            bank_employee =(Bank_Employee) objIs3.readObject();

                                                            System.out.println("The Bank employee name is "+bank_employee.E_name);
                                                            System.out.println("The Bank employee address is "+bank_employee.E_address);
                                                            System.out.println("The Bank employee phone is "+bank_employee.E_phone);
                                                            System.out.println("The Bank employee username is "+bank_employee.E_username);





                                                        } catch (FileNotFoundException e) {
                                                            e.printStackTrace();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        } catch (ClassNotFoundException e) {
                                                            e.printStackTrace();
                                                        } finally {
                                                            try {
                                                                if(objIs3 != null) objIs3.close();
                                                            } catch (Exception ex){

                                                            }
                                                        }


                                                        break ;


                                                    case 7:




                                                        continue Bank_Employee_Logout;


                                                }
                                            }
                                        }
                                        else
                                            System.out.println("The Password doesn't match Try Again: ");
                                    }
                                    else
                                        System.out.println("The username doesn't exist Try Again: ");




                                    break;
                                case 2:
                                    // For New Employee Registration
                                    System.out.print("Enter name : ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter address : ");
                                    String address = sc.nextLine();
                                    System.out.print("Enter contact number : ");
                                    String phone = sc.nextLine();
                                    System.out.println("Set username : ");
                                    username = sc.next();
                                    while(bank.Bank_EmployeeMap.containsKey(username))
                                    {
                                        System.out.println("Username already exists. Set again : ");
                                        username = sc.next();
                                    }
                                    System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
                                    password = sc.next();
                                    sc.nextLine();
                                    while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
                                    {
                                        System.out.println("Invalid password condition. Set again :");
                                        password=sc.next();
                                    }

                                    sc.nextLine();

                                    bank_employee = new Bank_Employee(username,password,name,address,phone);
                                    bank.Bank_EmployeeMap.put(username,bank_employee);

// Before Exiting the Bank Employee Section first store the Bank Employee  data


                                    OutputStream ops = null;
                                    ObjectOutputStream objOps = null;


                                    try {
                                        ops = new FileOutputStream("MyBankEmployeeFile.txt");
                                        objOps = new ObjectOutputStream(ops);
                                        objOps.writeObject(bank_employee);
                                        objOps.flush();
                                        objOps.close();
                                    }
                                    catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }finally{
                                        try{
                                            if(objOps != null) objOps.close();
                                        }
                                        catch (Exception ex)
                                        {  }
                                    }




// Before Exiting the Bank Employee Section first store the Bank_Employee  MAP   data

                                    File file1 =new File("MyBankEmployeeFileMap.txt");
                                    FileOutputStream f1 = new FileOutputStream(file1);
                                    ObjectOutputStream s1 = new ObjectOutputStream(f1);
                                    s1.writeObject(bank.Bank_EmployeeMap);
                                    s1.close();


                                    break;
                                case 3:
                                    // To exit from Bank Employee

                                    break;
                                default:
                                    System.out.println("Wrong choice !");

                            }

                        }while(!(option==3));


                        break;
                    case 2:
                        System.out.print("Enter name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter address : ");
                        String address = sc.nextLine();
                        System.out.print("Enter contact number : ");
                        String phone = sc.nextLine();
                        System.out.println("Set username : ");
                        username = sc.next();
                        while(bank.customerMap.containsKey(username))
                        {
                            System.out.println("Username already exists. Set again : ");
                            username = sc.next();
                        }
                        System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
                        password = sc.next();
                        sc.nextLine();
                        while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
                        {
                            System.out.println("Invalid password condition. Set again :");
                            password=sc.next();
                        }



                       /* System.out.print("Enter initial deposit : ");
                        sc.nextLine();
                        while(!sc.hasNextDouble())
                        {
                            System.out.println("Invalid amount. Enter again :");
                            sc.nextLine();
                        }*/
                        amount=1000;//sc.nextDouble();
                        sc.nextLine();



                        customer = new Customer(username,password,name,address,phone,amount,new Date());
                        bank.customerMap.put(username,customer);





// Before leaving we are here to store Customer registration.





                        OutputStream ops10 = null;
                        ObjectOutputStream objOps10 = null;


                        try {
                            ops10 = new FileOutputStream("MyCustomerFile.txt");
                            objOps10= new ObjectOutputStream(ops10);
                            objOps10.writeObject(customer);
                            objOps10.flush();
                        }
                        catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally{
                            try{
                                if(objOps10 != null) objOps10.close();
                            }
                            catch (Exception ex)
                            {  }
                        }
// Before the leaving we are going to store the CustomerMapFile.txt data


                        File file2 =new File("MyCustomerFileMap.txt");
                        FileOutputStream f2 = new FileOutputStream(file2);
                        ObjectOutputStream s2 = new ObjectOutputStream(f2);
                        s2.writeObject(bank.customerMap);
                        s2.close();


                        break;
                    case 3:


                        //For Customer  Login
                        // First of all reload the all data from the File MyCustomerMap.txt
                        //

                        File file3 = new File("MyCustomerFileMap.txt");
                        FileInputStream f3 = new FileInputStream(file3);
                        ObjectInputStream s3 = new ObjectInputStream(f3);
                        bank.customerMap=(HashMap<String,Customer>) s3.readObject();
                        s3.close();


                        System.out.println("Enter username : ");
                        username = sc.next();
                        sc.nextLine();
                        System.out.println("Enter password : ");
                        password = sc.next();
                        sc.nextLine();
                        if(bank.customerMap.containsKey(username))
                        {
                            customer = bank.customerMap.get(username);
                            if(customer.password.equals(password))
                            {
                                while(true)
                                {
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

//  // First of all reload the file data of MyCustomerFile.txt  and use it.

                                            InputStream fileIs12 = null;
                                            ObjectInputStream objIs12 = null;
                                            try {
                                                fileIs12 = new FileInputStream("MyCustomerFile.txt");
                                                objIs12 = new ObjectInputStream(fileIs12);

                                                 customer =(Customer) objIs12.readObject();


                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            finally {
                                                try {
                                                    if(objIs12 != null) objIs12.close();
                                                } catch (Exception ex){

                                                }
                                            }



                                            System.out.print("Enter amount : ");
                                            while(!sc.hasNextDouble())
                                            {
                                                System.out.println("Invalid amount. Enter again :");
                                                sc.nextLine();
                                            }
                                            amount = sc.nextDouble();
                                            sc.nextLine();
                                            customer.deposit(amount,new Date());



                                            //     Before leaving save the updated amount in customer Account.
                                            //

                                            // Before leaving we are here to store Customer registration.





                                            OutputStream ops15 = null;
                                            ObjectOutputStream objOps15 = null;


                                            try {
                                                ops15 = new FileOutputStream("MyCustomerFile.txt");
                                                objOps15= new ObjectOutputStream(ops15);
                                                objOps15.writeObject(customer);
                                                objOps15.flush();
                                            }
                                            catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }finally{
                                                try{
                                                    if(objOps15 != null) objOps15.close();
                                                }
                                                catch (Exception ex)
                                                {  }
                                            }
                                            //
                                            break;
                                        case 2:



                                            //  // First of all reload the file data of MyCustomerFile.txt  and use it.

                                            InputStream fileIs13 = null;
                                            ObjectInputStream objIs13 = null;
                                            try {
                                                fileIs13 = new FileInputStream("MyCustomerFile.txt");
                                                objIs13 = new ObjectInputStream(fileIs13);

                                                 customer =(Customer) objIs13.readObject();

                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            finally {
                                                try {
                                                    if(objIs13 != null) objIs13.close();
                                                } catch (Exception ex){

                                                }
                                            }


                                            System.out.print("Enter payee username : ");
                                            username = sc.next();
                                            sc.nextLine();
                                            System.out.println("Enter amount : ");
                                            while(!sc.hasNextDouble())
                                            {
                                                System.out.println("Invalid amount. Enter again :");
                                                sc.nextLine();
                                            }
                                            amount = sc.nextDouble();
                                            sc.nextLine();
                                            if(amount > 300000)
                                            {
                                                System.out.println("Transfer limit exceeded. Contact bank manager.");
                                                break;
                                            }
                                            if(bank.customerMap.containsKey(username))
                                            {
                                                Customer payee = bank.customerMap.get(username);
                                                payee.deposit(amount,new Date());
                                                customer.withdraw(amount,new Date());
                                            }
                                            else
                                            {
                                                System.out.println("Username doesn't exist.");
                                            }
                                            //   Before leaving save the updated amount in customer Account.
                                            //
                                            //


                                            // Before leaving we are here to store Customer registration.





                                            OutputStream ops16 = null;
                                            ObjectOutputStream objOps16 = null;


                                            try {
                                                ops16 = new FileOutputStream("MyCustomerFile.txt");
                                                objOps16= new ObjectOutputStream(ops16);
                                                objOps16.writeObject(customer);
                                                objOps16.flush();
                                            }
                                            catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }finally{
                                                try{
                                                    if(objOps16 != null) objOps16.close();
                                                }
                                                catch (Exception ex)
                                                {  }
                                            }
                                            break;

                                        case 3:


                                            //  // First of all reload the file data of MyCustomerFile.txt  and use it.

                                            InputStream fileIs14 = null;
                                            ObjectInputStream objIs14 = null;
                                            try {
                                                fileIs14 = new FileInputStream("MyCustomerFile.txt");
                                                objIs14 = new ObjectInputStream(fileIs14);

                                                customer =(Customer) objIs14.readObject();


                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            finally {
                                                try {
                                                    if(objIs14 != null) objIs14.close();
                                                } catch (Exception ex){

                                                }
                                            }


                                            System.out.println("Enter amount : ");
                                            while(!sc.hasNextDouble())
                                            {
                                                System.out.println("Invalid amount. Enter again :");
                                                sc.nextLine();
                                            }
                                            amount = sc.nextDouble();
                                            sc.nextLine();
                                            customer.withdraw(amount,new Date());

                                            //   Before leaving save the updated amount in customer Account.
//
//
                                            // Before leaving we are here to store Customer registration.





                                            OutputStream ops17 = null;
                                            ObjectOutputStream objOps17 = null;


                                            try {
                                                ops17 = new FileOutputStream("MyCustomerFile.txt");
                                                objOps17= new ObjectOutputStream(ops17);
                                                objOps17.writeObject(customer);
                                                objOps17.flush();
                                            }
                                            catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }finally{
                                                try{
                                                    if(objOps17 != null) objOps17.close();
                                                }
                                                catch (Exception ex)
                                                {  }
                                            }
                                            break;
                                        case 4:
                                            for(String transactions : customer.transactions)
                                            {
                                                System.out.println(transactions);
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Accountholder user name : "+customer.username);
                                            System.out.println("Accountholder name : "+customer.name);
                                            System.out.println("Accountholder address : "+customer.address);
                                            System.out.println("Accountholder contact : "+customer.phone);
                                            System.out.println("The Customer current Balance is "+customer.balance);
                                            break;
                                        case 6:
                                            System.out.println("Enter username : ");
                                            username = sc.next();
                                            if(bank.customerMap.containsKey(username))
                                            {
                                                bank.customerMap.get(username).update(new Date());
                                            }
                                            else
                                            {
                                                System.out.println("Username doesn't exist.");
                                            }
                                            break;
                                        case 7:



                                            continue outer;
                                        default:
                                            System.out.println("Wrong choice !");
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Wrong username/password.");
                            }
                        }
                        else
                        {
                            System.out.println("Wrong username/password.");
                        }
                        break;
                    case 4:
                        int option3;
                        System.out.println("Enter username : ");
                        username = sc.next();


                        sc.nextLine();
                        if(bank.customerMap.containsKey(username)) {
                            Loan loan_customer=new Loan();
                            loan_customer.L_username=username;
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
                                        System.out.println("MR. "+username+"  your Loan Amount is "+loan_customer.L_Amount);
                                        break;
                                    case 2:
                                        System.out.println("Enter Purpose of Loan in Detail : ");
                                        loan_customer.L_Purpose = sc.next();
                                        loan_customer.L_Amount=loan_customer.L_Amount+5000;
                                        break;
                                    case 3:
                                        System.out.println("Enter Purpose of Loan in Detail : ");
                                        loan_customer.L_Purpose = sc.next();
                                        loan_customer.L_Amount=loan_customer.L_Amount+10000;
                                        break;
                                    case 4:
                                        System.out.println("Enter Purpose of Loan in Detail : ");
                                        loan_customer.L_Purpose = sc.next();
                                        loan_customer.L_Amount=loan_customer.L_Amount+15000;
                                        break;
                                    case 5:
                                        System.out.println("Enter Purpose of Loan in Detail : ");
                                        loan_customer.L_Purpose = sc.next();
                                        loan_customer.L_Amount=loan_customer.L_Amount+20000;
                                        break;
                                    case 6:
                                        System.out.println("Enter Purpose of Loan in Detail : ");
                                        loan_customer.L_Purpose = sc.next();
                                        loan_customer.L_Amount=loan_customer.L_Amount+100000;
                                        break;
                                    case 7:
                                        break;
                                    default:System.out.println("An inValid Choice:");

                                }
                            }while((option3!=7));
                        }
                        else
                            System.out.println("The user name doesn't exist ");




                        // For loan

                        break;
                    case 5:
                        System.out.println("\nThank you for choosing Allied Bank Limited.");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Wrong choice !");



                }
            }
        }
    }
}

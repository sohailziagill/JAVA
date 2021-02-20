import java.sql.*;
import java.util.Scanner;

public class Connect_Xampp_Database {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost/hospitaldb";
        String user="root";
        String password="";

        Scanner sc=new Scanner(System.in);
        int choice;
    do {
        System.out.println("Welcome to Sohail Zia Gill's Hospital Database Management System");
        System.out.println(" Enter 1 to Run Search Querires in Tables.");
        System.out.println(" Enter 2 to Display all record of Tables.");
        System.out.println(" Enter 0 to exit from Database. ");
        choice= sc.nextInt();
        if(choice<0 || choice>2)
            System.out.println("You have Entered an Invalid Choice: Enter your choice Again");
        else{
            // To Search Queries
            // To Display All the Record of Database
            switch (choice) {
                case 1 -> {
                    int option5;
                    Scanner sc3 = new Scanner(System.in);
                    do {
                        System.out.println("Enter 1 to Search  in PATIENT Table");
                        System.out.println("Enter 2 to Search  in from DOCTOR Table");
                        System.out.println("Enter 3 to Search  in from ROOM Table");
                        System.out.println("Enter 4 to Search  in from BED Table");
                        System.out.println(" Enter 0 to exit from this Menu. ");
                        option5 = sc3.nextInt();
                        if (option5 < 0 || option5 > 4)
                            System.out.println("You have Entered an Invalid Choice: Enter your choice Again");
                        else {
                            // To search  Table Record  of PATIENT
                            // Search By ID
                            // TO search Table Record  of DOCTOR
                            // Search By ID
                            // TO search Table Record  of ROOM
                            // Search By ID
                            // TO search Table Record  of BED
                            // Search By ID
                            switch (option5) {
                                case 1 -> {
                                    Scanner scanner = new Scanner(System.in);
                                    int Id1;
                                    System.out.println("Enter the ID that you want to search");
                                    Id1 = scanner.nextInt();
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT *FROM `patient` WHERE ID=" + Id1;
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of PATIENT is " + resultSet.getInt("ID"));
                                            System.out.println("Name is " + resultSet.getString("Name"));
                                            System.out.println("Blood Group is " + resultSet.getString("Blood Group"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 2 -> {
                                    Scanner scanner2 = new Scanner(System.in);
                                    int Id2;
                                    System.out.println("Enter the ID that you want to search");
                                    Id2 = scanner2.nextInt();
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT *FROM `doctor` WHERE ID=" + Id2;
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of DOCTOR is " + resultSet.getInt("ID"));
                                            System.out.println("Name is " + resultSet.getString("Name"));
                                            System.out.println("Speciality is " + resultSet.getString("Speciality"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 3 -> {
                                    Scanner scanner3 = new Scanner(System.in);
                                    int Id3;
                                    System.out.println("Enter the ID that you want to search");
                                    Id3 = scanner3.nextInt();
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT *FROM `room` WHERE ID=" + Id3;
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of ROOM is " + resultSet.getInt("ID"));
                                            System.out.println("Name is " + resultSet.getString("Name"));
                                            System.out.println("Room Nurse Name is " + resultSet.getString("Room_Nurse_Name"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 4 -> {
                                    Scanner scanner4 = new Scanner(System.in);
                                    int Id4;
                                    System.out.println("Enter the ID that you want to search");
                                    Id4 = scanner4.nextInt();
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT *FROM `bed` WHERE ID=" + Id4;
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of BED is " + resultSet.getInt("ID"));
                                            System.out.println("Bed Type is " + resultSet.getString("Bed_Type"));
                                            int i = resultSet.getInt("Occupied_Status");
                                            if (i == 1) {
                                                System.out.println("This BED is Occupied ");

                                            } else System.out.println("This BED is not Occupied");

                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    } while (option5!=0);
                }

                case 2 -> {
                    int option4;
                    Scanner sc4 = new Scanner(System.in);
                    do {
                        System.out.println("Enter 1 to See All Record from PATIENT Table");
                        System.out.println("Enter 2 to See All Record from DOCTOR Table");
                        System.out.println("Enter 3 to See All Record from ROOM Table");
                        System.out.println("Enter 4 to See All Record from BED Table");
                        System.out.println(" Enter 0 to exit from this Menu. ");
                        option4 = sc4.nextInt();
                        if (option4 < 0 || option4 > 4)
                            System.out.println("You have Entered an Invalid Choice: Enter your choice Again");
                        else {
                            switch (option4) {
                                case 1:
                                    // TO see Table Record  of PATIENT
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT * FROM patient";
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of PATIENT is " + resultSet.getInt("ID"));
                                            System.out.println("Name is " + resultSet.getString("Name"));
                                            System.out.println("Blood Group is " + resultSet.getString("Blood Group"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 2:
                                    // TO see Table Record  of DOCTOR
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT * FROM doctor";
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of DOCTOR is " + resultSet.getInt("ID"));
                                            System.out.println("Name id " + resultSet.getString("Name"));
                                            System.out.println("Speciality is " + resultSet.getString("Speciality"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 3:
                                    // TO see Table Record  of ROOM
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT * FROM room";
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of ROOM is " + resultSet.getInt("ID"));
                                            System.out.println("Name is " + resultSet.getString("Name"));
                                            System.out.println("Room Nurse Name is " + resultSet.getString("Room_Nurse_Name"));
                                            System.out.println("\n");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    // TO see Table Record  of BED
                                    int Bed_Occupied_Count = 0;
                                    try {
                                        Connection connection = DriverManager.getConnection(url, user, password);
                                        Statement statement = connection.createStatement();
                                        String sql = "SELECT * FROM bed";
                                        ResultSet resultSet = statement.executeQuery(sql);
                                        while (resultSet.next()) {
                                            System.out.println("The ID of BED is " + resultSet.getInt("ID"));
                                            System.out.println("Bed Type is " + resultSet.getString("Bed_Type"));
                                            int i = resultSet.getInt("Occupied_Status");
                                            if (i == 1) {
                                                System.out.println("This BED is Occupied ");
                                                Bed_Occupied_Count = Bed_Occupied_Count + 1;

                                            } else System.out.println("This BED is not Occupied");

                                            System.out.println("\n");
                                        }
                                        System.out.println("The Total Occupied Beds are " + Bed_Occupied_Count);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }
                    } while (option4 != 0);
                }
            }
        }
    }while(choice!=0);

    }}

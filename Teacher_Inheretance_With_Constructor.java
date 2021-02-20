import java.util.Scanner;

public class Teacher_Inheretance_With_Constructor {
    public static class Teacher{
    String Name;
    String clg_Name;
    String Designation;
    int Salary;
    Teacher(String name,String clg_name,String designation,int salary){
        this.Name=name;
        this.clg_Name=clg_name;
        this.Designation=designation;
        this.Salary=salary;
    }

    void setSalary(int salary){
        this.Salary=salary;
    }
    void setName(String name){
        this.Name=name;
    }
    void setClg_Name(String clg_name){
        this.clg_Name=clg_name;
    }
    void setDesignation(String designation){
        this.Designation=designation;
    }
    void display(){
        System.out.println("The Name is "+Name);
        System.out.println("The Clg Name is "+clg_Name);
        System.out.println("The Designation is "+Designation);
        System.out.println("The Salary of Teacher is "+Salary);
    }
}
    public static class Teacher1 extends Teacher {
        String Main_Course;
        Teacher1(String name,String clg_name,String designation,int salary,String main_course){
            super(name,clg_name,designation,salary);
            Main_Course=main_course;
        }
        void setMain_Course(String main_course){
            this.Main_Course=main_course;
        }
        String getMain_Course(){
            return Main_Course;
        }
        @Override
        void display(){
            super.display();
            System.out.println("The Main course is "+Main_Course);
        }
    }
    public  static void main(String[]args){
        Teacher1 test=new Teacher1("Ahmed","IMCG","Principal",20000,"Physics");

       System.out.println("The Constructor values are ");
       test.display();

       String name;
        Scanner input=new Scanner(System.in);
       System.out.println("Enter the Name of Teacher ");
       name=input.nextLine();
        test.setName(name);

        String clg_name;
        Scanner input1=new Scanner(System.in);
        System.out.println("Enter the clg Name of Teacher ");
        clg_name=input1.nextLine();
        test.setClg_Name(clg_name);


        String designation;
        Scanner input2=new Scanner(System.in);
        System.out.println("Enter the Designation of Teacher ");
        designation=input2.nextLine();
        test.setDesignation(designation);



        String main_course;
        Scanner input3=new Scanner(System.in);
        System.out.println("Enter the main course of Teacher ");
        main_course=input3.nextLine();
        test.setMain_Course(main_course);

        int salary;
        Scanner input4=new Scanner(System.in);
        try{
            System.out.println("Enter the  salary of Teacher ");
            salary=input4.nextInt();
            test.setSalary(salary);
        }
        catch (IllegalArgumentException ex){
            System.out.println("An invalid Input");
        }



        System.out.println("The new values are ");
        test.display();

    }
}

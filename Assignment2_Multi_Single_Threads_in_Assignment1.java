
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Assignment2_Multi_Single_Threads_in_Assignment1 {
    static class Attendance {
       // public  String path = "D:\\ACP-BSCS-18-B (2020-12-17).csv";
        public String path="C:\\Users\\Sohail Zia Gill\\Downloads\\ACP\\ACP-BSCS-18-A (2020-12-17).csv";

        public  void PrintFile(){

            try {

                BufferedReader buffer = new BufferedReader(new FileReader(path));
                String Readline;
                while((Readline= buffer.readLine())!=null){
                    String[] values=Readline.split(",");
                    int i=0;
                    while(values.length>i)
                    {
                        System.out.print(values[i]+"\t");
                        i++;
                    }
                    System.out.println();

                }

            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        public  void GetFileName() {
            //  String path = "D:\\ACP-BSCS-18-B (2020-12-17).csv";
            File tmp=new File(path);

            if(Files.exists(Path.of(path))) {
                System.out.println("The path of file is " + path);
                System.out.println("The name of file is "+tmp.getName() );
            }
        }
        public  void SearchInFile() throws IOException {
            File tmp=new File(path);
            if(tmp.exists())
            {
                System.out.println("Please Enter the Name to search (Within Double Qoutes)");
                Scanner sc= new Scanner(System.in);
                String Name=sc.nextLine();
                System.out.println("Searching the Name  "+Name );
                BufferedReader br=new BufferedReader(new FileReader(path));
                String Line;
                boolean found=false;
                while((Line= br.readLine())!=null){
                    String[] values =Line.split(",");
                    if(values[0].equals(Name)){

                        found=true;
                        break;

                    }
                }
                if(found)
                    System.out.println("The required name is found ");
                else
                    System.out.println("The Required Name is not found");
                br.close();
            }


        }
    }
    static class Test extends Thread{
        @Override
        public void run() {

            Attendance myobj=new Attendance();

            myobj.PrintFile();
            myobj.GetFileName();
            try {
                myobj.SearchInFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    static class Test1 extends Thread{
        @Override
        public void run() {

            Attendance myobj1=new Attendance();

            myobj1.PrintFile();

        }


    }
    static class Test2 extends Thread{
        @Override
        public void run() {

            Attendance myobj2=new Attendance();
            myobj2.GetFileName();

        }


    }
    static class Test3 extends Thread{
        @Override
        public void run() {

            Attendance myobj3=new Attendance();

            try {
                myobj3.SearchInFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public static  void main(String[] args) throws IOException, InterruptedException {
        long ExecutionTIme1=0;
        long ExecutionTIme2 = 0;
        boolean Case1IsVisited=false;
        boolean Case2IsVisited=false;
        int choice;
        do {

            System.out.println("To Read and Display , Get Details , To search ");
            System.out.println("Enter 1 to with Single Thread ");
            System.out.println("Enter 2 to With MultiThread");
            System.out.println("Enter 3 to compare case 1 and case 2 execution time");
            System.out.println("Enter 0 to exit ");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if(choice<0 || choice>3)
                System.out.println("An Invalid Output Enter Again:");
            else
            {
                switch (choice) {
                   case 1:

                        Case1IsVisited=true;
                        // Single Thread
                        long Start1=System.currentTimeMillis();
                        Test t=new Test();
                       // t1.start();
                        t.run();
                        long End1=System.currentTimeMillis();

                        ExecutionTIme1=(End1-Start1)/1000;
                        break;
                    case 2:
                        Case2IsVisited=true;
                        // MultiThreading
                        long Start2=System.currentTimeMillis();

                        Test1  t1=new Test1();

                        Test2 t2=new Test2();

                        Test3 t3=new Test3();

                        t1.start();
                        t2.start();

                        Thread.sleep(5000);
                        t3.run();


                        long End2=System.currentTimeMillis();
                        ExecutionTIme2=(End2-Start2)/1000;
                        break;

                    case 3 :

                        if(Case1IsVisited==true) {
                            if (Case2IsVisited == true) {
                                System.out.println("The Execution Time of Single Thread  in Seconds is " + ExecutionTIme1);
                                System.out.println("The Execution Time of Multi Thread in Seconds is " + ExecutionTIme2);

                            }
                                else
                                System.out.println("Please go to Case 2 for Multithreading");
                        }
                        else
                            System.out.println("Please go for the Case 1 for Single Threading");

                        break;
                }

            }
        }while(choice!=0);




    }



}

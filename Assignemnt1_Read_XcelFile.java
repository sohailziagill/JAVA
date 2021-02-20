import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Assignemnt1_Read_XcelFile {
   static String path = "D:\\ACP-BSCS-18-B (2020-12-17).csv";

    public static void main(String[] args) throws IOException {
        int choice;
        do {

            System.out.println("Enter 1 to Read and Display All record of File ");
            System.out.println("Enter 2 to Get Fie Details ");
            System.out.println("Enter 3 to Search in  File ");
            System.out.println("Enter 0 to exit ");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if(choice<0 || choice>3)
                System.out.println("An Invalid Output Enter Again:");
            else
            {
                switch (choice){
                        case 1:
                            PrintFile();
                        break;
                        case 2:
                            GetFileName();
                            break;
                        case 3:
                            SearchInFile();
                        break;
                }

            }
        }while(choice!=0);




    }
    public static void SearchInFile() throws IOException {
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


    public static void GetFileName() {
      //  String path = "D:\\ACP-BSCS-18-B (2020-12-17).csv";
        File tmp=new File(path);

        if(Files.exists(Path.of(path))) {
            System.out.println("The path of file is " + path.toString());
            System.out.println("The name of file is "+tmp.getName() );
        }
    }




    public static void PrintFile(){
       // Scanner sc=new Scanner(System.in);
       // System.out.println("Please enter csv file directory: ");
        //String paths = "D:\\ACP-BSCS-18-B (2020-12-17).csv";
        try {
          //  BufferedReader buffer =new BufferedReader(new FileReader(paths));
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            String Readline="";
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


}

import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
public class Object_Fileing {

   /* public static void display(){
        person tmp;
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("MyEmpFile.txt");
            objIs = new ObjectInputStream(fileIs);
            tmp = (person) objIs.readObject();
            //System.out.println(tmp);
            System.out.println("The id of person is    "+tmp.id);
            System.out.println("The name of person is     "+tmp.name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){

            }
        }



    }*/
    public static class person implements Serializable
    {
        int id;
        String name;
        person(int ID,String Name){
            this.id=ID;
            this.name=Name;
        }


    }
    public static void main(String[] args) {
        File myObj = new File("MyEmpFile.txt");
        try {

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("File name: " + myObj.getName());
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        System.out.println("Writeable: " + myObj.canWrite());
        System.out.println("Readable " + myObj.canRead());
        System.out.println("File size in bytes " + myObj.length());

        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);


        System.out.println("Enter the id of person");
        int id1= sc.nextInt();
        System.out.println("Enter the name of person");
        String name1= sc1.nextLine(); ;

        person p1=new person(id1,name1);


        // Fileing

        OutputStream ops = null;
        ObjectOutputStream objOps = null;


        try {
            ops = new FileOutputStream("MyEmpFile.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(p1);
            objOps.flush();
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



      //  display();
        person tmp;
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("MyEmpFile.txt");
            objIs = new ObjectInputStream(fileIs);
            tmp = (person) objIs.readObject();
            //System.out.println(tmp);
            System.out.println("The id of person is    "+tmp.id);
            System.out.println("The name of person is     "+tmp.name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){

            }
        }

    }
}

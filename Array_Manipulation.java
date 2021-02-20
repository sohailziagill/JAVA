import java.util.Arrays;
public class Array_Manipulation {

    public static void main(String[]args) {

        double[] Double_Aarray = {8.4, 9.3, 0.2, 7.9, 3.4};

        System.out.println();
        System.out.println("Before the Array Sorting is ");
        for (double s : Double_Aarray
        ) {
            System.out.print(s+" , ");
        }

        System.out.println();
        // To sort the Array in Ascending order
        Arrays.sort(Double_Aarray);
        System.out.println("After the Sorting");
        for (double s : Double_Aarray
        ) {
            System.out.print(s+" , ");

        }

        System.out.println();
        // Now declare an array and fill it with 7 by function
        int[] Filled_Array=new int[10];
        Arrays.fill(Filled_Array,7);
        System.out.print("The another Array with 7 is ");
        for (int s:Filled_Array
        ) {System.out.print(s+" , ");

        }

        // Copy One Array to another Aarray
        int[] Int_Array={1,2,3,4,5,6,7};
        int[] Int_Array_Copy=new int[Int_Array.length];

        //  First array and starting position
        // Second array and starting position and the lenght/ Range of array
        System.arraycopy(Int_Array,0,Int_Array_Copy,0,Int_Array.length);

        System.out.println("\nThe Copied Array is");
        System.out.println();
        for (int s:Int_Array_Copy
        ) {System.out.print(s+" , ");

        }


        // To compare the two arrays
        boolean b=Arrays.equals(Int_Array,Int_Array_Copy);
        if(b)
            System.out.println("\nThe boths Array are Equal ");
        else
            System.out.println("\n The both arrays are not equal");


        // To search in array an element
        int location =Arrays.binarySearch(Int_Array,5);
        if(location>=0)
            System.out.println("The Element 5 found at "+location);
        else
            System.out.println("The Element 5 is not found ");
    }
}


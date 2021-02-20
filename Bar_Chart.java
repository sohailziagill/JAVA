public class Bar_Chart {
    public static void main(String[] args)
    {
        // We use this Array to print the *
        int[] array={0,0,0,0,0,0,1,2,4,2,1};
        System.out.println("Grading Distribution");

        // To Display the numbers in format of 00-09,10-19.........100

        for(int count=0;count<array.length;count++)
        {
            if(count==10)
                System.out.printf("%5d: ",100);
            else
            {
                System.out.printf("%2d-%2d:",count*10,count*10+9);
            }

            // To print bar of *
            for(int stars=0;stars<array[count];stars++)
                System.out.print("*");
            System.out.println();
        }
    }
}


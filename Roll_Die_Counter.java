import java.security.SecureRandom;

public class Roll_Die_Counter {
    public static void main(String[] args)
    {
        SecureRandom Random_Number=new SecureRandom();
        // To count the 1,2,3,4,5,6 we use the switch case
        int frequency1=0;
        int frequency2=0;
        int frequency3=0;
        int frequency4=0;
        int frequency5=0;
        int frequency6=0;

        // We Roll-Die 2000 times
        for(int counter=1;counter<=2000;counter++)
        {
            int Number=1+Random_Number.nextInt(6);
            switch(Number){

                case 1:
                {
                    frequency1++;
                    break;
                }
                case 2:
                {
                    frequency2++;
                    break;
                }
                case 3:
                {
                    frequency3++;
                    break;
                }
                case 4:
                {
                    frequency4++;
                    break;
                }
                case 5:
                {
                    frequency5++;
                    break;
                }
                case 6:
                {
                    frequency6++;
                    break;
                }


            }


        }

        System.out.println("Face\tFrequency");
        System.out.println("1\t\t"+frequency1);
        System.out.println("2\t\t"+frequency2);
        System.out.println("3\t\t"+frequency3);
        System.out.println("4\t\t"+frequency4);
        System.out.println("5\t\t"+frequency5);
        System.out.println("6\t\t"+frequency6);



    }
}

import java.security.SecureRandom;

public class Secure_Random_Number_Generator {
    public static void main(String[] args){
        SecureRandom Random_Number=new SecureRandom();

        for(int counter=1;counter<=20;counter++)
        {
            // Add 1 to avoid the 0
            // It will starts froms 0-5
            int Numbers=1+Random_Number.nextInt(6);
            System.out.printf("%d  ",Numbers);
            if(counter%5==0)
                System.out.println("");
        }
    }
}

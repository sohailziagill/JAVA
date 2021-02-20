public class Polymorphism_Bank_Example {

    // Parent class
    public static class Bank{
        float GetInterestRate(){
            return 0.0f;
        }
    }

    // SBI Bank
    public static class SBI extends Bank{
        float GetInterestRate(){return 0.5f;}
    }

    // ICIC Bank
    public static class ICIC extends Bank{
        float GetInterestRate(){return  7.3f;}
    }

    // UBL Bank
    public static class UBL extends Bank{
        float GetInterestRate(){return  7.8f;}
    }

    public static void main(String[]args){

        System.out.println("We are in child class object to access it's GetInterestRate function");
        UBL ubl=new UBL();
        System.out.println("From UBL "+ubl.GetInterestRate());
        System.out.println("We are in Parent class object to access it's GetInterestRate function");
        Bank icic=new ICIC();
        System.out.println("From ICIC Bank through Bank Parent Class "+icic.GetInterestRate());
        Bank sbi =new SBI();
        System.out.println("From SBI Bank through Bank Parent Class "+sbi.GetInterestRate());


    }


}



public class Multi_Threading_Sinlge_Task_WIth_Schronization {
    static int value=10;

    public static class test extends Thread{

        // For the constructors in threads


         int val;
//int value1=value;
        test(int val1){
            this.val=val1;

        }
        public synchronized void adder(){
            for(int i=0;i<1;i++)
            {
                System.out.println("Before the Adding  "+val+"  The Original value is"+value);

                value=val+value;


            }
            System.out.println("After adding "+value);
        }
        public void run() {
            adder();



        }


    }
    public static void main(String[]args){

        System.out.println("The Threads are randomly selected to execute it will not effect for the minor process");
        System.out.println("I am making First Thread");
        test t1= new test(1);
        System.out.println("I am making Second Thread");
        test t2=new test(5);
        System.out.println("I am making Third Thread");
        test t3=new test(7);
        t1.start();
        t2.start();
        t3.start();
    }
}



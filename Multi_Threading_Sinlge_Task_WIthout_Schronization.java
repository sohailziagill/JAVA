public class Multi_Threading_Sinlge_Task_WIthout_Schronization {

    static int value=10;

    public static class test extends Thread{

        // For the constructors in threads


        int val;
        //int value1=value;
        test(int val1){
            this.val=val1;

        }
        public void run() {
            System.out.println("The Single Task is performing by Single Thread");
            for(int i=0;i<1;i++)
            {
                System.out.println("Before the Adding  "+val+"  The Original value is"+value);

                value=val+value;


            }


        }


    }
    public static void main(String[]args){

        System.out.println("I am making First Thread");
        test t1= new test(1);
        System.out.println("I am making Second Thread");
        test t2=new test(5);
        System.out.println("I am making Third Thread");
        test t3=new test(7);
        t1.start();
        System.out.println("After adding "+value);
        t2.start();
        System.out.println("After adding "+value);
        t3.start();
        System.out.println("After adding "+value);
    }
}



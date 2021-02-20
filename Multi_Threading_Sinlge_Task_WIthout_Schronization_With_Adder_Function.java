public class Multi_Threading_Sinlge_Task_WIthout_Schronization_With_Adder_Function {
    static int value=10;

    public static class test extends Thread{

        // For the constructors in threads


        int val;
        //int value1=value;
        test(int val1){
            this.val=val1;

        }
        public void adder(){
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

        System.out.println("I am making First Thread");
        Multi_Threading_Sinlge_Task_WIth_Schronization.test t1= new Multi_Threading_Sinlge_Task_WIth_Schronization.test(1);
        System.out.println("I am making Second Thread");
        Multi_Threading_Sinlge_Task_WIth_Schronization.test t2=new Multi_Threading_Sinlge_Task_WIth_Schronization.test(5);
        System.out.println("I am making Third Thread");
        Multi_Threading_Sinlge_Task_WIth_Schronization.test t3=new Multi_Threading_Sinlge_Task_WIth_Schronization.test(7);
        t1.start();
        t2.start();
        t3.start();
    }
}

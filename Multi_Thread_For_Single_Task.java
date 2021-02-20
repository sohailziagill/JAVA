public class Multi_Thread_For_Single_Task {
    public static class test extends Thread{
        @Override
        public void run() {
            System.out.println("The Single Task is performing by Single Thread");
            for(int i=0;i<5;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    public static void main(String[]args){
        System.out.println("I am making First Thread");
        test t1= new test();
        System.out.println("I am making Second Thread");
        test t2=new test();
        System.out.println("I am making Third Thread");
        test t3=new test();
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();

    }
}

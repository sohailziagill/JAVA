public class Multi_Threads_For_Multi_Tasks_With_SLeep_Methond {

        public static class test1 extends Thread{
            @Override
            public void run() {
                System.out.println("Hi i am Task 1 ");
                for(int i=0;i<5;i++)
                {
                    System.out.println(i);

                }


            }

        }
        public static class test2 extends Thread{
            @Override
            public void run() {
                System.out.println("Hi i am Task 2 ");
                for(int i=0;i<5;i++)
                {
                    System.out.println("Sohail Zia Gill");

                }


            }

        }
        public static void main(String[] args){
            test1 t1=new test1();
            test1 t2=new test1();

            // For second Task
            test2 t3=new test2();
            test2 t4=new test2();

/* In this section all the threads are execute randomly
        t1.start();
        t3.start();
        t2.start();
        t4.start();
        */

            System.out.println("Now  i am using the system sleep function.");
            System.out.println("Now checks the output.\n\n\n\n");

            t1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t3.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t4.start();

        }
    }



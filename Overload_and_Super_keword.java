public class Overload_and_Super_keword {
    public static class Animal{
        void eat(){
            System.out.println("I can eat");
        }

    }
    private static class Dog extends Animal{
        @Override
        protected void eat()
        {
            super.eat();
            System.out.println("I eat Dog Food");
        }
    }
    protected static class BabyDog extends Dog{
        @Override
       protected void eat(){
            super.eat();
            System.out.println("I eat Dog Food");
        }

    }
    public static class Cat extends Animal{
        @Override
        void eat(){
            super.eat();
            System.out.println("I eat the Cat Food");
        }
    }
    public static void main(String[]args){
        BabyDog bd=new BabyDog();
        bd.eat();
        Cat cat=new Cat();
        cat.eat();
    }
}

public class Animal_Multilevel_Inheretance {
    public static class Animal{
        void Eat(){
            System.out.println("Eating..........");
        }
    }
    public static class Dog extends Animal
    {
        void Bark(){
            System.out.println("The Dog is Barking");
        }
    }
    public static class BabyDog extends Dog{
        void Weeping(){
            System.out.println("The Baby Dog is Weeping");
        }
    }
    public static void main(String[]args){
        BabyDog babyDog=new BabyDog();
        babyDog.Eat();
        babyDog.Bark();
        babyDog.Weeping();
    }
}

public class Animal_Simple_Inheretance {
    public static class Animal{
        void eat(){
            System.out.println(" Eating............");
        }
    }
    public static class Dog extends Animal{
        void Bark()
        {
            System.out.println("Dog is Barking");
        }
    }
    public static void main(String[] args){

        Dog dog=new Dog();
        dog.eat();
        dog.Bark();
    }
}

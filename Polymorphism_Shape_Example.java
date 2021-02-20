public class Polymorphism_Shape_Example {
    public static class Shape {
        public void Drawing(){
            System.out.println("Drawing");
        }
    }

    public static class Circle extends Shape{
        public void Drawing(){
            super.Drawing();
            System.out.print("Circle.....");
        }

        public static class Rectangle extends Shape{
            public void Drawing(){
                super.Drawing();
                System.out.print("Rectangle....");
            }
        }
        public static class Triangle extends Shape{

            public void Drawing(){
                super.Drawing();
                System.out.print("Triangle....");
            }
        }
        public static void main(String[]args){
            System.out.println("\nPolymorphism\n");
            Shape circle=new Circle();
            System.out.println("From the Circle......");
            circle.Drawing();

            Shape rectangle=new Rectangle();
            System.out.println("From the Rectangle ");
            rectangle.Drawing();

            Shape triangle=new Triangle();
            System.out.println("From the Triangle ");
            triangle.Drawing();
        }
    }
}

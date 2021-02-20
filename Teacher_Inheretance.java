public class Teacher_Inheretance {
    public static class Teacher{
         String Name;
         String clg_Name;
         String Designation;
        String getName(){
            return Name;
        }
        String getClg_Name(){
            return clg_Name;
        }
        String getDesignation()
        {
            return Designation;
        }
        void setName(String name){
            this.Name=name;
        }
        void setClg_Name(String clg_name){
            this.clg_Name=clg_name;
        }
        void setDesignation(String designation){
            this.Designation=designation;
        }
    }
    public static class Teacher1 extends Teacher{
        String Main_Course;
        void setMain_Course(String main_course){
            this.Main_Course=main_course;
        }
        String getMain_Course(){
            return Main_Course;
        }
    }
    public  static void main(String[]args){
        Teacher1 test=new Teacher1();
        test.setName("Sohail");
        test.setClg_Name("IMCB");
        test.setDesignation("Teacher");
        test.setMain_Course("Maths");
        System.out.println("The Name is "+test.getName());
        System.out.println("The Clg Name is "+test.getClg_Name());
        System.out.println("The Designation is "+test.getDesignation());
        System.out.println("The Main Course is "+test.getMain_Course());

    }
}

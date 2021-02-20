import java.util.ArrayList;

public class ArrayList_Collection {
    public static void main(String[] args) {
        ArrayList<String> item = new ArrayList<>();

        // To add the item
        item.add("Red");
        item.add("Yellow");

        System.out.print("\n");
        //ot use the .get()
        for(int i=0;i<item.size();i++)
        {
            System.out.print(item.get(i)+" , ");
        }

        // To remove form Array list
        System.out.println();

        item.remove("Red");
        for (String s :item
        ) {System.out.print(s+" , ");

        }

        // To search form the array list

        if( item.contains("Yellow"))
            System.out.print("\n Yes it is found ");
        else
            System.out.print("\n Not found");

    }
}

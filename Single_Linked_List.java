import java.util.Scanner;

public class Single_Linked_List {
    public static class  node
    {
        int marks;
        node next;
    }
    static int menu()
    {
        Scanner scanner=new Scanner(System.in);
        int choice;

        System.out.println( "\n Enter 1 for creating the list            \t");
        System.out.println(  "\n Enter 2 for inserting  new list          \t");
        System.out.println( "\n Enter 3 for display  list                \t");
        System.out.println( "\n Enter 4 for deleting a number from list  \t");
        System.out.println(  "\n Enter 5 for searching a number from list \t");
        System.out.println(  "\n Enter 6 to exit                          \t");
        choice=scanner.nextInt();
        return choice;

    }
    public static void main(String[] args)
    {
        int choice;
        node first = null;
        node curr;
        node prev = null;
        int x;
        do
        {
            x=menu();

            switch (x)
            {

                case 1:
                {
                    int marks1;
                    Scanner scanner= new Scanner(System.in);
                    //          To create the new linked list
                    do
                    {
                        curr = new node();
                        System.out.println( "Enter the marks \t");
                        marks1=scanner.nextInt();
                        curr.marks=marks1;
                        curr.next = null;
                        if (first == null)
                            first = prev = curr;
                        else
                        {
                            assert prev != null;
                            prev.next = curr;
                            prev = curr;
                        }


                        do
                        {
                            System.out.println("\n Enter the choice 1 for new data and 0 for stop entering data \t");
                            choice=scanner.nextInt();

                            if (choice != 1 && choice != 0)
                                System.out.println("\n Invalid Data");
                        } while (choice != 1 && choice != 0);

                    } while (choice == 1);
                    break;
                }
                case 2:
                {
                    int marks2;
                    Scanner scanner=new Scanner(System.in);
                    //    To insert new item in link list
                    node  newitem;
                    boolean isinsert = false;
                    newitem = new node();
                    newitem.next =null;
                    System.out.println("\n Enter the new marks ");
                    marks2=scanner.nextInt();
                    newitem.marks=marks2;
                    //Insertion at the beginnig

                    assert first != null;
                    if (newitem.marks <= first.marks)
                    {
                        newitem.next = first;
                        first = newitem;
                        isinsert = true;
                    }
                    else
                    {
                        curr = prev = first;
                        while (curr != null)
                        {
                            if (newitem.marks >= curr.marks)
                            {
                                prev = curr;
                                curr = curr.next;

                            }
                            else
                            {
                                prev.next = newitem;
                                newitem.next = curr;
                                isinsert = true;
                                break;
                            }

                        }

                    }
                    if (!isinsert)
                        prev.next = newitem;
                    System.out.println("\n Insertion succesfully completed ");
                    break;
                }
                case 3:
                {
                    //                    To display the link list
                    curr = first;
                    while (curr != null)
                    {
                        System.out.println("\n The marks are " +curr.marks) ;
                        curr = curr.next;
                    }
                    break;
                }
                case 4:
                {
                    //                 To delete number from the link list
                    int dmark;
                    Scanner scanner=new Scanner(System.in);
                    boolean isdelete = false;
                    System.out.println("\n Enter the number that you want to delete \t");
                    dmark=scanner.nextInt();
                    curr = prev = first;
                    // Deletion at start
                    if (dmark == first.marks)
                    {
                        first = first.next;
                        isdelete = true;
                    }
                    //Deletion at Midlle and end
                    else
                    {
                        while (curr != null)
                        {
                            if (curr.marks == dmark)
                            {
                                prev.next = curr.next;
                                isdelete = true;
                                break;
                            }
                            else
                            {
                                prev = curr;
                                curr = curr.next;
                            }
                        }
                    }
                    if (isdelete)
                    {
                        System.out.println( "\n The deletion is performed successfully ");
                        curr = first;
                        while (curr != null)
                        {
                            System.out.println("\n The marks are "+curr.marks);
                            curr = curr.next;
                        }

                    }
                    else
                        System.out.println( "\n The givven number is not exist in this list ");
                    break;
                }
                case 5:
                {

                    //                    To search in link list
                    int smark;
                    Scanner scanner=new Scanner(System.in);
                    boolean isfound = false;
                    System.out.println("\n Enter the mark that you want to search \t");
                    smark=scanner.nextInt();
                    curr = first;
                    while (curr != null)
                    {
                        if (curr.marks == smark)
                        {
                            isfound = true;
                            break;
                        }
                        else
                            curr = curr.next;

                    }
                    if (isfound)
                        System.out.println("\n The givven number is found ");
                    else
                        System.out.println("\n The givven number is not exist in this list");
                    break;
                }


                default:
                    break;
            }
        } while (x!=6);





        System.out.println();

    }
}

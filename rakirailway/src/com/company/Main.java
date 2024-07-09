package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        bookTicket bt=new bookTicket();
        boolean aa=true;
        while(aa)
        {
            System.out.println("---Railway reservation---");
            System.out.println("1.Book\n2.Display available\n3.Cancel\n4.Display booked\n5.Exit");
            int v=sc.nextInt();

            switch(v)
            {
                case 1:

                    bt.bookTicket();
                    break;
                case 2:
                    bt.printav();
                    break;
                case 3:
                    bt.cancel();
                    break;
                case 4:
                    bt.disptic();
                    break;
                case 5:
                    aa=false;
                    break;
                default:
                    System.out.println("Invalid");
            }

        }
    }
}

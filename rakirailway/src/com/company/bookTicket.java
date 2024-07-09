package com.company;
import java.util.*;
import java.io.*;
public class bookTicket {
    int seatL=1, seatM=2, seatH=3, seatR=2,seatW=2;
    public static ArrayList<Passenger> a=new ArrayList<>();
    public void bookTicket()
    {
        Scanner sc=new Scanner(System.in);
        String pname;
        int p_age;
        char pref;
        System.out.println("Enter name:");
        pname=sc.next();
        System.out.println("Enter age:");
        p_age=sc.nextInt();
        System.out.println("Enter (L/M/H):");
        pref=sc.next().charAt(0);

        pref=Character.toUpperCase(pref);
        int id,flg=0;
        if(a.size()<1)
            id=1;
        else
            id=a.get(a.size()-1).pid+1;
        char ber=' ';
        if(pref=='L')
        {
            if(seatL>0)
            {
                ber=pref;
                seatL-=1;
            }
            else if(seatM>=1)
            {
                ber='M';
                seatM-=1;
            }
            else if(seatH>=1)
            {
                ber='H';
                seatH-=1;
            }
            else if(seatR>=1)
            {
                ber='R';
                seatR-=1;
            }
            else if(seatW>=1)
            {
                ber='W';
                seatW-=1;
            }
            else
                flg=1;
        }
        else if(pref=='M')
        {
            if(seatM>=1)
            {
                ber=pref;
                seatM-=1;
            }
            else if(seatL>=1)
            {
                ber='L';
                seatL-=1;
            }
            else if(seatH>=1)
            {
                ber='H';
                seatH-=1;
            }
            else if(seatR>=1)
            {
                ber='R';
                seatR-=1;
            }
            else if(seatW>=1)
            {
                ber='W';
                seatW-=1;
            }
            else
                flg=1;
        }
        else if(pref=='H')
        {
            if(seatH>=1)
            {
                ber=pref;
                seatH-=1;
            }
            else if(seatL>=1)
            {
                ber='L';
                seatL-=1;
            }
            else if(seatM>=1)
            {
                ber='M';
                seatM-=1;
            }
            else if(seatR>=1)
            {
                ber='R';
                seatR-=1;
            }
            else if(seatW>=1)
            {
                ber='W';
                seatW-=1;
            }
            else
                flg=1;
        }
        if(flg==1)
            System.out.println("Can't book");
        Passenger ps=new Passenger(id,pname,p_age,ber,pref);
        a.add(ps);
        System.out.println(ber +" is given ");
        System.out.println("------------------------------------");
    }
    public void printav()
    {
        System.out.println("Available Tickets");
        System.out.println("Available L : "+seatL);
        System.out.println("Available M : "+seatM);
        System.out.println("Available H : "+seatH);
        System.out.println("Available RAC : "+seatR);
        System.out.println("Available WT : "+seatW);
        System.out.println("------------------------------------");
    }
    public void cancel()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter ticketId : ");
        int tid=sc.nextInt();
        char pb=' ';
        Iterator<Passenger> it=a.iterator();
        while(it.hasNext())
        {
            Passenger pp=it.next();
            if(pp.pid==tid)
            {
                pb=pp.berth;
                it.remove();
            }
        }
        int f1=0,f2=0;
        for(Passenger p0:a)
        {
            if(p0.berth=='R')
            {
                p0.berth=pb;
                f1=1;
                break;
            }
        }
        if(f1==0)
        {
            for(Passenger p0:a)
            {
                if(p0.berth=='W') {
                    p0.berth = pb;
                    seatW++;
                    f2=1;
                    break;
                }
            }
        }
        else
        {
            for(Passenger p0:a)
            {
                if(p0.berth=='W')
                {
                    p0.berth='R';
                    seatR++;
                    f2=1;
                    break;
                }
            }
        }
        if(f2==0)
        {
            if(pb=='L')
                seatL++;
            else if(pb=='H')
                seatH++;
            else
                seatM++;
        }
    }
    public void disptic()
    {
        if(a.size()==0)
            System.out.println("No Booked tickets");
        for(Passenger j:a)
        {
            System.out.println("Id = "+j.pid);
            System.out.println("Name = "+j.pname);
            System.out.println("Age = "+j.p_age);
            System.out.println("Pref = "+j.berth);
        }
        System.out.println("------------------------------------");
    }
}

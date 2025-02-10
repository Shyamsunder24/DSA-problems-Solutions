import java.io.*;
import java.util.*;

public class Main {
    static final int secinday=86400;
    static final String[] idays={"Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday"};
    static final String[] mon={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    static final int[] dayss={31,28,31,30,31,30,31,31,30,31,30,31};

    static int daysinyear(int year){
        return isLeap(year)?366:365;
    }
    static int daysinmonth(int month,int year){
        if(month==1) return isLeap(year)?29:28;
        return dayss[month];
    }
    static boolean isLeap(int year){
        return (year%4==0 && year%100 !=0) ||(year%400==0);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            long sec=Long.parseLong(br.readLine());
            long days=sec/secinday;

            int year=1970;
            while(days>=daysinyear(year)){
                days-=daysinyear(year);
                year++;
            }
            int month=0;
            while(days>=daysinmonth(month,year)){
                days-=daysinmonth(month,year);
                month++;
            }
            int day=(int)days+1;
            String monthstr=mon[month];
            String dayofweek= idays[(int)((sec/secinday)%7)];
            System.out.println(String.format("%02d-%s-%d %s%n",day,monthstr,year,dayofweek));
        }
    }
}

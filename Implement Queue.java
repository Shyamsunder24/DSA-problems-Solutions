Implement the Queue data structure and perform Enqueue / Dequeue operations.



Note:

Do not use any inbuilt functions / libraries for the Queue.



Input Format
The first line of input contains T - number of operations. It is followed by T lines, each line contains either "Enqueue x" or "Dequeue".



Output Format

For each "Dequeue" operation, print the dequeued element, separated by a newline. If the queue is empty, print "Empty".



Constraints

1 <= T <= 10000

-100 <= x <= 100



Example

Input

8

Enqueue 5

Dequeue

Dequeue

Enqueue 10

Enqueue -15

Dequeue

Enqueue -10

Dequeue



Output

5

Empty

10

-15

import java.io.*;
import java.util.*;

public class Main {
    static int n=10000;
    static int a[]=new int[n];
    static int front=-1;
    static int rear=-1;
    static void enq(int x){
        if(rear<n){
            rear=(rear+1)%n;
            a[rear]=x;
        }
    }
    static void deq(){
        if((front-rear)!=0){
            System.out.println(a[(front+1)%n]);
            front++;
        }
        else{
            System.out.println("Empty");
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str=s.next();
            if(str.equals("Enqueue")){
                int x=s.nextInt();
                enq(x);
            }
            else{
                deq();
            }
        }
    }
}

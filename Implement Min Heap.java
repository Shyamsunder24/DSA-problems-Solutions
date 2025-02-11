Implement the Min Heap data structure and perform insert / delMin / getMin operations.

Note: 
 Do not use any inbuilt functions / libraries for the Heap.  Input Format
The first line of input contains T - the number of operations. It's followed by T lines. Each line contains either "insert x" or "delMin" or "getMin".

Output Format
For each "getMin" operation, print the minimum element, separated by a newline. If the heap is empty, print "Empty".

Constraints
1 <= T <= 106
-109 <= x <= 109

Example
Input
10
insert 5
getMin
delMin
getMin
insert -15
insert 10
insert -30
getMin
delMin
getMin

Output
5
Empty
-30
-15

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        InputStreamReader is=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(is);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String s[]=br.readLine().split(" ");
            if(s[0].equals("insert"))   insert(Integer.parseInt(s[1]));
            else if(s[0].equals("getMin")){
                if(list.isEmpty()) System.out.println("Empty");
                else getMin();
            } 
            else delMin();
        }
    }

    static int parent(int i){
        return (i-1)/2;
    }
    static int left(int i){
        return 2*i+1;
    }
    static int right(int i){
        return 2*i+2;
    }

    static void swap(int a,int b){
        int temp=list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    } 

    static void insert(int x){
        list.add(x);
        upheap(list.size()-1);
    }
    static void upheap(int idx){
        if(idx==0) return;
        int p=parent(idx);
        if(list.get(p)>list.get(idx)){
            swap(idx,p);
            upheap(p);
        }
    }

    static void getMin(){
        System.out.println(list.get(0));
    }

    static void delMin(){
        if(list.isEmpty()){
            // System.out.println("Empty");
            return;
        }
        int l=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,l);
            downheap(0);
        }
    }
    static void downheap(int idx){
        int min=idx;
        int leftc=left(idx);
        int rightc=right(idx);
        if(leftc<list.size() && list.get(leftc)<list.get(min)) min=leftc;
        if(rightc<list.size() && list.get(rightc)<list.get(min)) min=rightc;
        if(min!=idx){
            swap(min,idx);
            downheap(min);
        }
    }
}

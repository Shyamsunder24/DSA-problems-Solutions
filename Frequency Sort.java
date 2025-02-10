You are given an array of integers. Sort them by frequency. See examples for more clarifications.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, print the elements of the array sorted by frequency. In case 2 elements have the same frequency, print the smaller element first.

Constraints
1 <= T <= 100
1 <= N <= 10000
-1000 <= A[i] <= 1000

Example
Input
2
6
4 -2 10 12 -8 4
8
176 -272 -272 -45 269 -327 -945 176

Output
-8 -2 10 12 4 4
-945 -327 -45 269 -272 -272 176 176

import java.io.*;
import java.util.*;

public class Main {

    static void solve(int a[],int n){
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            hm.put(a[i],hm.getOrDefault(a[i],0)+1);
        }
        Integer[] boxed=Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed,(x,y)->{
            int freqx=hm.get(x);
            int freqy=hm.get(y);
            if(freqx!=freqy){
                return Integer.compare(freqx,freqy);
            }
            else return Integer.compare(x,y);
        });
        for(int x:boxed){
            System.out.print(x+" ");
            
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
            solve(a,n);
            System.out.println();
        }
    }
}

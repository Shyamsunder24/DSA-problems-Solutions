Santa and Banta are playing a game of coins. They have a pile containing N coins. Players take alternate turns, removing some coins from the pile. On each turn, a player can remove either one coin or coins equal to some prime power (i.e. px coins, where p - prime number and x - positive integer). The game ends when the pile becomes empty. The player who can not make a move in his turn loses.

Given the pile size, and assuming Santa always plays the first move, your task is to find out who will win the game, provided that both the players play optimally.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line contains a single integer N-pile size.

Output Format
For each test case, print the name of the winner, separated by a new line.

Constraints
1 <= T <= 10000
1 <= N <= 109

Example
Input
4
1
6
4
9

Output
Santa
Banta
Santa
Santa

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            if(n%6==0) System.out.println("Banta");
            else System.out.println("Santa");
        }
    }
}

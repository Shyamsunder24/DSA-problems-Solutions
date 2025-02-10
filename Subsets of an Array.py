Given an array of unique integer elements, print all the subsets of the given array in lexicographical order.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array and the second line contains the elements of the array.

Output Format
For each test case, print the subsets of the given array in lexicographical order, separated by new line. Print an extra newline between output of different test cases.

Constraints
1 <= T <= 100
1 <= N <= 10
0 <= A[i] <= 100

Example
Input
3
3
5 15 3 
2
57 96 
4
3 15 8 23 

Output
3 
3 5 
3 5 15 
3 15 
5 
5 15 
15 

57 
57 96 
96 

3 
3 8 
3 8 15 
3 8 15 23 
3 8 23 
3 15 
3 15 23 
3 23 
8 
8 15 
8 15 23 
8 23 
15 
15 23 
23

F=int(input())
for _ in range(F):
    p=int(input())
    p1=list(map(int,input().split()))
    p1.sort()
    B=[]
    def go(g,h):
        if h:
            B.append(h[:])
        for i in range(g,p):
            h.append(p1[i])
            go(i+1,h)
            h.pop()
    go(0, [])
    for k in B:
        print(" ".join(map(str,k)))
    if _ <F-1:
        print()

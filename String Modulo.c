 are given 2 numbers N & P. Print N % P.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line contains 2 numbers N and P, separated by space.

Output Format
For each test case, print the value of N % P, separated by a new line.

Constraints
20 points
1 <= T <= 100
1 <= N <= 1018
1 <= P <= 108

80 points
1 <= T <= 100
1 <= N <= 1010000
1 <= P <= 1015

Example
Input
4
5 2
4 10
1085377843 81765943
8290826691135830692772803 95972011

Output
1
4
22420584
60316167

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long long stringm(char *N,long long P){
    long long res=0;
    for(int i=0;N[i]!='\0';i++){
        res=(res*10+(N[i]-'0'))%P;
    }
    return res;
}



int main() {
    int T;
    scanf("%d",&T);

    while(T--){
        char N[1000001];
        long long P;
        scanf("%s %lld",N,&P);
        printf("%lld\n",stringm(N,P));
    }

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}

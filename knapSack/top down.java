/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.*;
/**
 *
 * @author misba zaidi
 */

public class JavaApplication2 {
static int knapSack(int W,int[] wt,int[] val,int n){
    
int dp[][]=new int[n+1][W+1];
for(int i=0;i<=n;i++){
    dp[i][0]=0;}
for(int i=0;i<=W;i++){
    dp[0][i]=0;}
for(int i=1;i<=n;i++){
    for(int j=1;j<=W;j++){
        if(wt[i-1]<=j)dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
        else 
            dp[i][j]=dp[i-1][j];
    }
}
return dp[n][W];
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int W=s.nextInt();
        int n=s.nextInt();
        int[] wt=new int[n];
        int[] val=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=s.nextInt();
        }
        for(int j=0;j<n;j++){
            val[j]=s.nextInt();
        }
       
            System.out.print(knapSack(W,wt,val,n));
        
    }
    
}

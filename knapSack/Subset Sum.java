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
static int subsetSum(int n,int[] arr,int sum){
    
boolean dp[][]=new boolean[n+1][sum+1];
for(int i=0;i<=sum;i++){
    dp[0][i]=false;}
for(int i=0;i<=n;i++){
    dp[i][0]=true;}

for(int i=1;i<=n;i++){
    for(int j=1;j<=sum;j++){
        if(arr[i-1]<=j){
            dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];}
        else 
            dp[i][j]=dp[i-1][j];
    }
}
if(dp[n][sum])return 1;
else return 0;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        
        int n=s.nextInt();
        int[] arr=new int[n];
        
        
        for(int j=0;j<n;j++){
            arr[j]=s.nextInt();
        }
        int sum=s.nextInt();
       
            System.out.print(subsetSum(n,arr,sum));
        
    }
    
}

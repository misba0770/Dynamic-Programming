
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misba zaidi
 */
public class MinSubsetSumDiff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
        
        int n=s.nextInt();
        int[] arr=new int[n];
        
        
        for(int j=0;j<n;j++){
            arr[j]=s.nextInt();
        }
        System.out.print(minDiff(arr,n));
       
    }

    private static int minDiff(int[] arr, int n) {
      int sum=0;
	    for(int i=0;i<n;i++){sum+=arr[i];}
	    boolean dp[][]=new boolean[n+1][sum+1];
	    for(int i=0;i<=sum;i++){
	        dp[0][i]=false;
	    }
	    for(int i=0;i<=n;i++){
	        dp[i][0]=true;
	    }
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=sum;j++){
	            if(arr[i-1]<=j)dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    int mn=Integer.MAX_VALUE;
	    for(int i=0;i<=sum/2;i++){
	        if(dp[n][i])mn=Math.min(mn,sum-(2*i));
	    }
	    return mn;
    }
    
}

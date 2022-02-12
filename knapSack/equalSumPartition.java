
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
public class equalSumPartition {
    static int equalSumPartition(int N,int[] arr){
    
 int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }if(sum%2!=0)return 0;
        sum=sum/2;
        boolean dp[][]=new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)dp[i][j]=false;
                if(j==0)dp[i][j]=true;
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j)dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        } 
        if(dp[N][sum])return 1;
        else return 0;

}

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
       
       if(equalSumPartition(n,arr)==1)
            System.out.print("Yes");
       else System.out.print("No");
    }
    
}

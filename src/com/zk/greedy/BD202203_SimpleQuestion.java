package com.zk.greedy;

import java.util.Scanner;

public class BD202203_SimpleQuestion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextLong();
        }
        input.close();

        if(n < 2){
            System.out.println("yes");
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        int i = 0;
        while (i < n){
            if(arr[i] >= max && arr[i] <= min){
                if(i + 1 >= n){
                    break;
                }
                if(arr[i] > arr[i + 1]){
                    min = arr[i++];
                }else if(arr[i] < arr[i + 1]){
                    max = arr[i++];
                }else{
                    int t = i + 1;
                    while(t < n && arr[t] == arr[t - 1]){
                        t++;
                    }
                    if(t == n){
                        break;
                    }
                    if(arr[t] > arr[t - 1]){
                        max = arr[t - 1];
                    }else{
                        min = arr[t - 1];
                    }
                    i = t;
                }
            }else if(arr[i] >= max){
                max = arr[i++];
            }else if(arr[i] <= min){
                min = arr[i++];
            }else{
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");

    }
}





















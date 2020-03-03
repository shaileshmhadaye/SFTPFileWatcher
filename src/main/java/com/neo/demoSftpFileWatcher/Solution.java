package com.neo.demoSftpFileWatcher;

public class Solution {
    public static void main(String[] args) {
        int [] arr = {6,6,2,3,4,7,6,7,8,8};
        int max=arr[0], secondmax = arr[1];
        if(arr[1] > arr[0]){
            max = arr[1];
            secondmax = arr[0];
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if(secondmax < arr[i] && arr[i]!=max)
                secondmax = arr[i];
        }
        System.out.println(max);
        System.out.println(secondmax);
    }
}

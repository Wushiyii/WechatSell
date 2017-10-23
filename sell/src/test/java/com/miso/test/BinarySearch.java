package com.miso.test;

/**
 * Created by Wushiyi on 2017-10-20.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr,int x,int p ,int r){
        int q = (p+r)/2;

        if(p >= r){
            return -1;
        }
        if(arr[q] == x){
            return q;
        }else if(arr[q] > x){
            return binarySearch(arr,x,p,q-1);
        }else {
            return binarySearch(arr,x,q,r);
        }

    }

    public static int binarySearch(int[]srcArray,int des){
        int start = 0;
        int end = srcArray.length-1;
        while (start <= end){
            int middle = (start + end) / 2;
            if(des == srcArray[middle]){
                return middle;
            }else if(des <srcArray[middle]){
                end = middle -1;
            }else {
                start = middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       int[] arr = {1,3,5,6,7,8,9};
        int i = binarySearch(arr, 7);
        System.out.println(i);
    }

}

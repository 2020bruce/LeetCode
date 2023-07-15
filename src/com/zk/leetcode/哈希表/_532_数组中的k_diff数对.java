package com.zk.leetcode.哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _532_数组中的k_diff数对 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 1, 5} ;
        int k = 0;
        int pairs = findPairs(nums, k);
        System.out.println(pairs);
    }
    public static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int repeatCounts = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int t = entry.getValue();
            if(t >= 2){
                repeatCounts++;
            }
        }
        if(k == 0){
            return repeatCounts;
        }

        Integer[] uniqueNums = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(uniqueNums);
        int n = uniqueNums.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            int t = uniqueNums[i] - k;
            int l = 0, r = n - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(t == uniqueNums[mid]){
                    res++;
                    break;
                }else if(t > uniqueNums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}

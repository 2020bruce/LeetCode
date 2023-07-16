package com.zk.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1054_DistantBarcodes {
    public static void main(String[] args) {
        int[] barcodes = {1,1,1,1,2,2,3,3};
        int[] rearrangeBarcodes = rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(rearrangeBarcodes));
    }

    /**
     * 每次从堆顶拿出一个剩余最多的元素，放入排列中，再更新剩余数量，重新放入最大堆中。如果这个元素和排列结果中的最后一个元素相同，那么我们就需要再从
     * 最大堆中取出第二多的元素，放入排列中，之后再把这两个元素放回最大堆中。
     * @param barcodes
     * @return
     */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int barcode : barcodes){
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        for(int i = 0; i < n; i++){
            int[] temp = queue.poll();
            int k = temp[0], v = temp[1];
            if(i == 0 || ans[i - 1] != k){
                ans[i] = k;
                if(v > 1){
                    queue.offer(new int[]{k, v - 1});
                }
            }else{
                int[] second = queue.poll();
                int k2 = second[0], v2 = second[1];
                ans[i] = k2;
                if(v2 > 1){
                    queue.offer(new int[]{k2, v2 - 1});
                }
                queue.offer(temp);
            }
        }
        return ans;
    }
}





















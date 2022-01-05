package com.interview.heap.easy;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int stone : stones){
            queue.offer(stone);
        }

        while(queue.size() > 1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            if(num1!= num2){
                queue.offer(num1-num2);
            }
        }

        return queue.isEmpty()?0: queue.poll();
    }
    public static void main(String args[]) {
        int[] stones = {2,7,4,1,8,1};
        lastStoneWeight(stones);
    }
}

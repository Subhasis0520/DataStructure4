package heap;

import java.util.PriorityQueue;

public class InbuildPriorityQueue {
    public static void main(String[] args) {
        int[] arr= {4,7,3,2,8,9,6,1};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i =0; i<arr.length;i++){
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }
    }
}

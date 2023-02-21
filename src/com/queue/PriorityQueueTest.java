package com.queue;

public class PriorityQueueTest {
    public static void main(String[] args) {

        Priority_Queue<String> pq = new Priority_Queue<>();

        pq.insert("abc",1);
        pq.insert("efg",7);
        pq.insert("klm",4);
        pq.insert("pqr",13);
        pq.insert("stu",17);
        pq.insert("xyz",15);

        System.out.println("Size of the queue is: "+ pq.size());
        System.out.println(pq.isEmpty());

        while (!pq.isEmpty()){
            System.out.println(pq.getMin());
            pq.removeMin();
        }
    }
}

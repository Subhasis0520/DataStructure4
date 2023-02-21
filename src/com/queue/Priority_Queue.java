package com.queue;

import java.util.ArrayList;

public class Priority_Queue<T> {
    ArrayList<Element<T>> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
     Element<T> e = new Element<>(value,priority);
     heap.add(e);
     int childIndex = heap.size() -1;
     int parentIndex = (childIndex-1)/2;

     while (childIndex>0) {
         if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
             Element<T> temp = heap.get(childIndex);
             heap.set(childIndex, heap.get(parentIndex));
             heap.set(parentIndex, temp);
             childIndex = parentIndex;
             parentIndex = (childIndex-1)/2;
         } else {
             return;
         }
     }
    }

    public T getMin(){
        if (isEmpty()){
            System.out.println("Heap is empty");
        }
        return heap.get(0).value;
    }

    public T removeMin() {
        if (isEmpty()) {
            System.out.println("We can't remove now");
        }
        Element<T> removed = heap.get(0);
        T ans = removed.value;

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex;
        while (leftChildIndex< heap.size()){
        if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
            leftChildIndex = minIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
            rightChildIndex = minIndex;
        }
        if (minIndex == parentIndex){
            break;
        }

        Element<T> temp = heap.get(minIndex);
        heap.set(minIndex, heap.get(parentIndex));
        heap.set(parentIndex, temp);

        parentIndex = minIndex;
        leftChildIndex = 2 * parentIndex + 1;
        rightChildIndex = 2 * parentIndex + 2;
    }
      return ans;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        if (size()==0){
            return true;
        }
        return false;
    }

}

package StacksAndQueues.ImplementQueueUsingStacks;

import java.util.*;
class QueueUsingStack{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //enqueue means push at end of queue
    public void enqueue(int value){
        stack1.push(value);
    }

    //dequeue operation
    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("\nQueue is empty");
        }
        if(!stack2.empty()){
            return stack2.pop();
        } else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    //top operation()
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("\nQueue is empty");
        }
        if(!stack2.empty()){
            return stack2.peek();
        } else {
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    //check if the queue is empty
    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }
}
public class QueueImplementation {

    public static void main(String[] args){
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);

//        while(!queue.isEmpty()){
//            System.out.print(queue.peek() + " ");
//            queue.dequeue();
//        }

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}

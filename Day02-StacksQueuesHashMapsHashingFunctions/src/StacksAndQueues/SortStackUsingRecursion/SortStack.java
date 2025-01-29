package StacksAndQueues.SortStackUsingRecursion;

import java.util.Stack;

public class SortStack {

    public static void insertSorted(Stack<Integer> stack, int element){

        //Base case
        if(stack.empty() || stack.peek() <= element){
            stack.push(element);
            return;
        }

        int top = stack.pop();
        //recursively insert element in correct position
        insertSorted(stack, element);
        stack.push(top);
    }

    public static void sortStack(Stack<Integer> stack){
        if(!stack.empty()){
            int top = stack.pop();

            sortStack(stack);

            insertSorted(stack, top);
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(8);
        stack.push(-5);

        System.out.println("\nOriginal stack: " + stack);
        sortStack(stack);
        System.out.println("\nSorted stack: " + stack);
    }
}

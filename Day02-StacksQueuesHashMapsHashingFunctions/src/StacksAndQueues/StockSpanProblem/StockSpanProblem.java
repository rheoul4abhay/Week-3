package StacksAndQueues.StockSpanProblem;

import java.util.Stack;

public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < n;i++){
            //pop elements while stack is not empty and currentPrice >= stockTopPrice
            while(!stack.isEmpty() && prices[i] >= prices[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                span[i] = i+1;
            } else{
                span[i] = i-stack.peek();
            }

            //push current index to stack
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        int[] prices = {100,80,60,70,60,75,85};
        int[] span = calculateSpan(prices);

        System.out.println("\nStock span: ");
        for(int s: span){
            System.out.print(s + " ");
        }
    }
}

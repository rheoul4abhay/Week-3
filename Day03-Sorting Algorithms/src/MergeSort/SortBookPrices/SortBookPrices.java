package MergeSort.SortBookPrices;

import java.util.ArrayList;

public class SortBookPrices {

    public static void mergeSort(int[] prices, int low, int high){
        if(low >= high) return;
        int mid = low + (high-low)/2;
        mergeSort(prices, low, mid);
        mergeSort(prices, mid+1, high);
        merge(prices, low, mid, high);
    }

    public static void merge(int[] prices, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high){
            if(prices[left] <= prices[right]){
                temp.add(prices[left]);
                left++;
            } else {
                temp.add(prices[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(prices[left]);
            left++;
        }

        while(right <= high){
            temp.add(prices[right]);
            right++;
        }

        //To copy back elements in original prices array
        for(int i = low; i <= high;i++){
            prices[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args){
        int[] prices = {13, 47, 23, 5, 18, 2};
        System.out.print("Before sort : ");
        for(int price: prices){
            System.out.print(price + " ");
        }

        int low = 0;
        int high = prices.length-1;
        mergeSort(prices, low, high);

        System.out.print("\nAfter sort : ");
        for(int price: prices){
            System.out.print(price + " ");
        }
    }
}

package BubbleSort.SortStudentMarks;

public class SortStudentMarks {

    public static void bubbleSort(int[] marks){

        int n = marks.length;
        boolean isSwapped = false;
        for(int i = 0;i < n-1;i++){
            for(int j = 0; j < n-i-1; j++){
                if(marks[j] > marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) return;
        }
    }

    public static void main(String[] args){
        int[] marks = {95,81,75,63,51,44,33,21,18};
        bubbleSort(marks);
        System.out.print("Sorted Marks: ");
        for(int num: marks){
            System.out.print(num + " ");
        }
    }
}

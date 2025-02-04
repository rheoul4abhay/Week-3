package StringBuffer.StringBufferBuilderComparison;

public class CompareStringBuilderBuffer {

    public static void main(String[] args) {
        int numberOfIterations = 1_000_000; //1 million
        String str = "hello";

        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        for(int i = 0;i < numberOfIterations;i++){
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

        StringBuffer sbfr = new StringBuffer();
        startTime = System.nanoTime();

        for(int i = 0;i < numberOfIterations;i++){
            sbfr.append(str);
        }
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;

        System.out.print("String builder time taken: "  + duration1);
        System.out.print("\nString buffer time taken: " + duration2);

        if(duration1 > duration2){
            System.out.print("\nString buffer is faster!");
        } else{
            System.out.print("\nString builder is faster!");
        }
    }
}
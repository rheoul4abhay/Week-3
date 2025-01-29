package StacksAndQueues.CircularTourProblem;

class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0, currentSurplus = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            int gain = petrol[i] - distance[i];
            totalSurplus += gain;
            currentSurplus += gain;

            // If current surplus is negative, reset the start index
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        // If total petrol < total distance, it's impossible to complete the tour
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = findStartingPoint(petrol, distance);
        if (result != -1) {
            System.out.println("Starting pump index: " + result);
        } else {
            System.out.println("No possible starting point.");
        }
    }
}

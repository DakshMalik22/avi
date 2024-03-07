package March6;

// Custom exception class for handling errors in NinjaTest
class StudyTimeException extends Exception {
    public StudyTimeException(String message) {
        super(message);
    }
}

public class NinjaTest {
    // Method to calculate the minimum time required to study all chapters
    public static long calculateMinimumStudyTime(int numberOfDays, int numberOfChapters, int[] chapterTimes) throws StudyTimeException {
        long totalStudyTime = 0;
        int maxChapterTime = Integer.MIN_VALUE;

        // Calculate the total study time and find the maximum chapter time
        for (int chapterTime : chapterTimes) {
            totalStudyTime += chapterTime;
            maxChapterTime = Math.max(maxChapterTime, chapterTime);
        }

        // Initialize the lower and upper limits of binary search
        long lowerLimit = maxChapterTime;
        long upperLimit = totalStudyTime;
        long minimumStudyTime = totalStudyTime;

        // Perform binary search to find the minimum study time
        while (lowerLimit <= upperLimit) {
            long mid = (lowerLimit + upperLimit) / 2;
            long days = 1;
            long currentTime = 0;

            // Calculate the number of days required to study all chapters
            for (int chapterTime : chapterTimes) {
                currentTime += chapterTime;
                if (currentTime > mid) {
                    days++;
                    currentTime = chapterTime;
                }
            }

            // Adjust the search range based on the number of days required
            if (days <= numberOfDays) {
                minimumStudyTime = mid;
                upperLimit = mid - 1;
            } else {
                lowerLimit = mid + 1;
            }
        }

        // Return the final minimum study time
        return minimumStudyTime;
    }

    public static void main(String[] args) {
        int numberOfDays = 3; // Number of days
        int numberOfChapters = 5; // Number of chapters
        int[] chapterTimes = {1, 2, 2, 3, 1}; // Time required to study each chapter

        try {
            // Calculate the minimum time required to study all chapters
            long minimumStudyTime = calculateMinimumStudyTime(numberOfDays, numberOfChapters, chapterTimes);
            System.out.println("The minimum time required to study all chapters is: " + minimumStudyTime);
        } catch (StudyTimeException e) {
            System.out.println("Error in calculating minimum study time: " + e.getMessage());
        }
    }
}
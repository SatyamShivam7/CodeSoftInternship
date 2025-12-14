import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects;
        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.print("Number of subjects must be positive. Please enter again: ");
                }
            } else {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next();
            }
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (0-100): ");
            while (true) {
                if (scanner.hasNextInt()) {
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        totalMarks += mark;
                        break;
                    } else {
                        System.out.print("Marks must be between 0 and 100. Please enter again: ");
                    }
                } else {
                    System.out.print("Invalid input. Please enter an integer: ");
                    scanner.next();
                }
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}


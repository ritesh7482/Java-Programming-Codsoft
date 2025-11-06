import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("       🎓 STUDENT GRADE CALCULATOR");
        System.out.println("=======================================\n");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= subjects; i++) {
            double marks;
            do {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                marks = sc.nextDouble();
                if (marks < 0 || marks > 100) {
                    System.out.println("⚠️  Please enter valid marks between 0 and 100.");
                }
            } while (marks < 0 || marks > 100);

            totalMarks += marks;
        }

        // Calculate results
        double average = totalMarks / subjects;
        char grade;

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else if (average >= 50) grade = 'E';
        else grade = 'F';

        // Display output
        System.out.println("\n=======================================");
        System.out.println("             🧾 RESULT");
        System.out.println("=======================================");
        System.out.println("Total Marks       : " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", average) + "%");
        System.out.println("Grade             : " + grade);
        System.out.println("=======================================\n");

        if (grade == 'F')
            System.out.println("❌ You have failed. Better luck next time!");
        else
            System.out.println("🎉 Congratulations! You passed the exam.");

        sc.close();
    }
}

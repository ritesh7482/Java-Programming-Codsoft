import java.util.ArrayList;
import java.util.Scanner;

// Class representing a student
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Roll No: " + rollNumber + " | Grade: " + grade;
    }
}

// Class to manage multiple students
class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added successfully!");
    }

    public void removeStudent(int rollNumber) {
        Student toRemove = null;
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("🗑️  Student removed successfully!");
        } else {
            System.out.println("⚠️  Student not found!");
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                System.out.println("🔍 Student Found: " + s);
                return;
            }
        }
        System.out.println("⚠️  Student not found!");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("📂 No student records available.");
        } else {
            System.out.println("\n========== STUDENT LIST ==========");
            for (Student s : students) {
                System.out.println(s);
            }
            System.out.println("==================================");
        }
    }
}

// Main program
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        int choice;
        do {
            System.out.println("\n=======================================");
            System.out.println("     🎓 STUDENT MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("⚠️  Please enter a valid number!");
                sc.next();
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    management.addStudent(new Student(name, rollNumber, grade));
                }
                case 2 -> {
                    System.out.print("Enter roll number to remove: ");
                    int roll = sc.nextInt();
                    management.removeStudent(roll);
                }
                case 3 -> {
                    System.out.print("Enter roll number to search: ");
                    int roll = sc.nextInt();
                    management.searchStudent(roll);
                }
                case 4 -> management.displayAll();
                case 5 -> System.out.println("👋 Exiting the system. Goodbye!");
                default -> System.out.println("⚠️  Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

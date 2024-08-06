import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public double calculateAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grades=" + grades + ", averageGrade=" + calculateAverageGrade() + "}";
    }
}

public class StudentGradesManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nStudent Grades Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Assign Grade");
            System.out.println("3. View Student Details");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    assignGrade();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 4:
                    calculateAverageGrade();
                    break;
                case 5:
                    System.out.println("Thank you for using the Student Grades Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    private static void assignGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);

        if (student != null) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            student.addGrade(grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudentDetails() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void calculateAverageGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);

        if (student != null) {
            System.out.printf("Average grade for %s: %.2f\n", student.getName(), student.calculateAverageGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CourseHelper {
    // Example courses, not an official university study plan.
    static Course[] courses = {
        new Course("CS101", "Programming 1"),
        new Course("MATH101", "Discrete Mathematics"),
        new Course("CS102", "Programming 2", "CS101"),
        new Course("CS201", "Data Structures", "CS102"),
        new Course("CS202", "Databases", "CS102"),
        new Course("SE201", "Software Engineering", "CS102"),
        new Course("CS301", "Algorithms", "CS201", "MATH101")
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> completed = new ArrayList<>();
        boolean running = true;

        System.out.println("Course Helper - example courses only");
        while (running) {
            System.out.println("\n1. View courses");
            System.out.println("2. Mark a course as completed");
            System.out.println("3. Undo a completed course");
            System.out.println("4. View course eligibility");
            System.out.println("5. View completed courses");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            if (!input.hasNextLine()) {
                break;
            }
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    for (Course course : courses) {
                        String requirements = course.prerequisites.length == 0
                            ? "None" : String.join(", ", course.prerequisites);
                        System.out.println(course.code + " - " + course.name
                            + " | Prerequisites: " + requirements);
                    }
                    break;
                case "2":
                case "3":
                    System.out.print("Course code: ");
                    if (!input.hasNextLine()) {
                        running = false;
                        break;
                    }
                    String code = input.nextLine().trim().toUpperCase(Locale.ROOT);
                    if (findCourse(code) == null) {
                        System.out.println("Unknown course. Choose 1 to see the codes.");
                    } else if (choice.equals("2")) {
                        if (completed.contains(code)) {
                            System.out.println("This course is already completed.");
                        } else {
                            completed.add(code);
                            System.out.println("Added: " + code);
                        }
                    } else if (completed.remove(code)) {
                        System.out.println("Removed: " + code);
                    } else {
                        System.out.println("This course is not in your completed list.");
                    }
                    break;
                case "4":
                    showEligibility(completed);
                    break;
                case "5":
                    System.out.println(completed.isEmpty()
                        ? "No completed courses yet."
                        : "Completed: " + String.join(", ", completed));
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a number from the menu.");
            }
        }
        System.out.println("Goodbye! Completed courses are not saved after exit.");
        input.close();
    }

    static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }

    static void showEligibility(ArrayList<String> completed) {
        for (Course course : courses) {
            if (completed.contains(course.code)) {
                System.out.println(course.code + " - Already completed");
                continue;
            }
            ArrayList<String> missing = new ArrayList<>();
            for (String prerequisite : course.prerequisites) {
                if (!completed.contains(prerequisite)) {
                    missing.add(prerequisite);
                }
            }
            if (missing.isEmpty()) {
                System.out.println(course.code + " - " + course.name + " | Eligible");
            } else {
                System.out.println(course.code + " - " + course.name
                    + " | Missing: " + String.join(", ", missing));
            }
        }
    }
}

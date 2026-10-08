public class Course {
    String code;
    String name;
    String[] prerequisites;

    public Course(String code, String name, String... prerequisites) {
        this.code = code;
        this.name = name;
        this.prerequisites = prerequisites;
    }
}

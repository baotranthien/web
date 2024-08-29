package iuh.fit.ktpm.Course;
/**
 * @description:  This class represents a Course
 * @author:  Tran Thien Bao
 * @version: 1.0
 * @created: 28-Au-2024
 */
public class Course {
    private int credit = 0;
    private String department = "";
    private String id = "";
    private String title = "";

    public Course() {}

    public Course(int credit, String department, String id, String title) {
        setCredit(credit);
        setDepartment(department);
        setId(id);
        setTitle(title);
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit <=0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.trim().length()<3) {
            throw new IllegalArgumentException("ID must have at least 3 character");
        }
        for (int i = 0; i < id.trim().length(); i++) {
            char c = id.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                throw new IllegalArgumentException("ID must contain only letters or digits");
            }
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %2d %2s", id, title, credit, department);
    }
}


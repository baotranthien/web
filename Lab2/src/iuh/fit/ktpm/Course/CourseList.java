/**
 * @description:  This class represents and control a list of course
 * @author:  Tran Thien Bao
 * @version: 1.0
 * @created: 28-Aug-2023 8:15:52 AM
 */

package iuh.fit.ktpm.Course;

import java.util.*;

public class CourseList {
    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of array must be greater than 0");
        }

        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    private boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(course.getId())) {
                return true;
            }
        }
        return false;
    }

    public void showCourses() {
        for (Course course: getCourses()) {
            if (course!=null) {
                System.out.println(course);
            }
        }
    }

    public boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }

        if (isExists(course)) {
            return false;
        }

        if (count == courses.length) {
            return false;
        }

        courses[count++] = course;
        return true;
    }

    public boolean removeCourse(Course course) {
        if (course == null) {
            return false;
        }

        if (!isExists(course)) {
            return false;
        }

        int indexToRemove = -1;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && course.getId().equals(courses[i].getId())) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            throw new IllegalArgumentException("Course does not exist.");
        }

        for (int i = indexToRemove; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }

        // Xóa phần tử cuối cùng và giảm số lượng khóa học
        courses[count - 1] = null;
        count--;
        return true;
    }

    public Course findCourseByCode(String courseID) {
        if (courseID == null) {
            throw new IllegalArgumentException("Course code must not be null");
        }

        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(courseID)) {
                return courses[i];
            }
        }

        return null;
    }

    public List<Course> findCoursesByName(String courseName) {
        if (courseName == null) {
            throw new IllegalArgumentException("Name must not be null");
        }

        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getTitle().toLowerCase().contains(courseName.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> findCoursesByDepartment(String department) {
        if (department == null) {
            throw new IllegalArgumentException("Department must not be null");
        }

        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && department.equalsIgnoreCase(courses[i].getDepartment())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> sortCoursesByName() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null) {
                courseList.add(courses[i]);
            }
        }

        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getTitle().compareToIgnoreCase(c2.getTitle());
            }
        });

        return courseList;
    }

    public List<Course> findCoursesWithMaxCredits() {
        if (count == 0) {
            return null;
        }

        int maxCredits = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null) {
                maxCredits = Math.max(maxCredits, courses[i].getCredit());
            }
        }

        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getCredit() == maxCredits) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return null;
        }

        // Đếm số lượng khóa học cho mỗi khoa
        Map<String, Integer> departmentCount = new HashMap<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null) {
                String department = courses[i].getDepartment();
                departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
            }
        }

        // Tìm khoa có số lượng khóa học lớn nhất
        String maxDepartment = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }

        return maxDepartment;
    }
}
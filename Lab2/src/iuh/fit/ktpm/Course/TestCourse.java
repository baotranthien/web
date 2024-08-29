/**
 * @description:  This class use to test
 * @author:  Tran Thien Bao
 * @version: 1.0
 * @created: 28-Aug-2023 8:15:55 AM
 */

package iuh.fit.ktpm.Course;

public class TestCourse {
    public static void main(String[] args) {
        CourseList courselist = new CourseList(10);
        Course c1 = new Course(3, "Cs", "CS101", "Java Programming");
        Course c2 = new Course(3, "Se", "KT201", "CSDL");
        Course c3 = new Course(6, "Se", "KT202", "OPP");
        Course c4 = new Course(3, "Cs", "CS102", "CTDl va GT");
        Course c5 = new Course(4, "Se", "KT203", "Web Programming");

        courselist.addCourse(c1);
        courselist.addCourse(c2);
        courselist.addCourse(c3);
        courselist.addCourse(c4);
        courselist.addCourse(c5);

        System.out.println("Show course list");
        courselist.showCourses();

        courselist.removeCourse(c4);
        System.out.println("Find by id");
        System.out.println(courselist.findCourseByCode("CS101"));
        System.out.println("Find by name");
        System.out.println(courselist.findCoursesByName("CSDL"));
        System.out.println("Find by department");
        System.out.println(courselist.findCoursesByDepartment("se"));

        System.out.println("Sorted list");
        for (Course c: courselist.sortCoursesByName()) {
            if (c!=null) {
                System.out.println(c);
            }
        }

        System.out.println("Find course with most credits");
        System.out.println(courselist.findCoursesWithMaxCredits());
        System.out.println("Find department with most courses");
        System.out.println(courselist.findDepartmentWithMostCourses());
    }
}

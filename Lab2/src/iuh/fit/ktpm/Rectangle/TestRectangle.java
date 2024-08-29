package iuh.fit.ktpm.Rectangle;
/**
 * @description:  This class test a rectangle function
 * @author:  Tran Thien Bao
 * @version: 1.0
 * @created: 28-Au-2024
 */
import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5f, 12f);
        Rectangle r2 = new Rectangle();
        r2.setLength(8f);
        r2.setWidth(9.5f);
        System.out.println("Nhap chieu dai: ");
        double length = new Scanner(System.in).nextDouble();
        System.out.println("Nhap chieu rong: ");
        double width = new Scanner(System.in).nextDouble();
        r2.setLength(length);
        r2.setWidth(width);
        System.out.println(r2.getArea());
        System.out.println(r2.getPerimeter());
    }
}

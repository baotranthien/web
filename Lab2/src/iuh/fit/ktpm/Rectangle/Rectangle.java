package iuh.fit.ktpm.Rectangle;

/**
 * @description:  This class represents a rectangle
 * @author:  Tran Thien Bao
 * @version: 1.0
 * @created: 28-Au-2024
 */

public class Rectangle {
    private double length = 0f;
    private double width = 0f;

    /**
     * Description:  Get area of rectangle
     */
    public double getArea() {
        return length * width;
    }

    /**
     * Description:  Get perimeter of rectangle
     */
    public double getPerimeter() {
        return (length + width)/2;
    }

    /**
     * Description:  Get Length of rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * Description:  Get Width of rectangle
     */
    public double getWidth() {
        return width;
    }

    public Rectangle() {}

    /**
     * Description:  Initialize a rectangle
     * @Param  length, width
     * @Throws IllegalArgumentException if value is negative
     */
    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Description:  Set length of rectangle
     * @Param  length
     * @Throws IllegalArgumentException if value is negative
     */
    public void setLength(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = value;
    }


    /**
     * Description:  Set width of rectangle
     * @Param  width
     * @Throws IllegalArgumentException if value is negative
     */
    public void setWidth(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = value;
    }
}



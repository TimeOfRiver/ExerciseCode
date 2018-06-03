package effectiveJava.chap4;

/**
 * 子类型化实例
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public class Subtyping {
}

abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    final double radius;// 确保初始化时初始化它的数据

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Figure{
    final double width;
    final double length;

    Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }
}

package visitor;

import visitor.shapes.*;
import visitor.visitor.XMLExportVisitor;

/**
 * Exporting shapes into XML
 * In this example, we would want to export a set of geometric shapes into XML. 
 * The catch is that we don’t want to change the code of shapes directly or at least keep it to the minimum.
 * In the end, the Visitor pattern establishes an infrastructure that allows us to add any behaviours to the shapes 
 * hierarchy without changing the existing code of those classes.
 *
 */

public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
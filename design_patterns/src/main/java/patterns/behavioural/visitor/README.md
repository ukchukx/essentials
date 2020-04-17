# Intent
**Visitor** is a behavioural design pattern that lets you separate algorithms from the objects on which they operate.

# Applicability
* Use this pattern when you need to perform an operation on all elements of a complex object structure (for example, an object tree).
* Use this pattern to clean up the business logic of auxiliary behaviours.
* Use this pattern when a behaviour makes sense only in some classes of a class hierarchy, but not in others.

# Pros
* _Single Responsibility Principle_. You can move multiple versions of the same behaviour into the same class.
* _Open/Closed Principle_. You can introduce a new behaviour that can work with objects of different classes without changing these classes.
* A visitor object can accumulate some useful information while working with various objects. This might be handy when you want to traverse some complex object structure, such as an object tree, and apply the visitor to each object of this structure.

# Cons
* You need to update all visitors each time a class gets added to or removed from the element hierarchy.
* Visitors might lack the necessary access to the private fields and methods of the elements that they’re supposed to work with.

# Relations with Other Patterns
* You can treat **Visitor** as a powerful version of the **Command** pattern. Its objects can execute operations over various objects of different classes.
* You can use **Visitor** to execute an operation over an entire **Composite** tree.
* You can use **Visitor** along with **Iterator** to traverse a complex data structure and execute some operation over its elements, even if they all have different classes.


## Usage
Visitor isn’t a very common pattern because of its complexity and narrow applicability.

Examples from the Java core libraries:
* `javax.lang.model.element.AnnotationValue` and `AnnotationValueVisitor`
* `javax.lang.model.element.Element` and `ElementVisitor`
* `javax.lang.model.type.TypeMirror` and `TypeVisitor`
* `java.nio.file.FileVisitor` and `SimpleFileVisitor`
* `javax.faces.component.visit.VisitContext` and `VisitCallback`


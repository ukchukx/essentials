# Intent
**Composite** is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.

# Applicability
* Use this pattern when you have to implement a tree-like object structure.
* Use this pattern when you want the client code to treat both simple and complex elements uniformly.

# Pros
* _Open/Closed Principle_. You can introduce new element types into the app without breaking the existing code, which now works with the object tree.
* You can work with complex tree structures more conveniently: use polymorphism and recursion to your advantage.

# Cons
* It might be difficult to provide a common interface for classes whose functionality differs too much. In certain scenarios, you’d need to overgeneralize the component interface, making it harder to comprehend.

# Relations with Other Patterns
* You can use **Builder** when creating complex **Composite** trees because you can program its construction steps to work recursively.
* **Chain of Responsibility** is often used in conjunction with **Composite**. In this case, when a leaf component gets a request, it may pass it through the chain of all of the parent components down to the root of the object tree.
* You can use **Iterators** to traverse **Composite** trees.
* You can use **Visitor** to execute an operation over an entire **Composite** tree.
* You can implement shared leaf nodes of the **Composite** tree as **Flyweights** to save some RAM.
* **Composite** and **Decorator** have similar structure diagrams since both rely on recursive composition to organize an open-ended number of objects.
A Decorator is like a **Composite** but only has one child component. There’s another signicant difference: Decorator adds additional responsibilities to the wrapped object, while **Composite** just "sums up" its children’s results.
However, the patterns can also cooperate: you can use Decorator to extend the behavior of a specific object in the **Composite** tree.
* Designs that make heavy use of **Composite** and **Decorator** can often benefit from using **Prototype**. Applying the pattern lets you clone complex structures instead of re-constructing them from scratch.

## Usage
The Composite pattern is pretty common in Java code. It’s often used to represent hierarchies of user interface components or the code that works with graphs.

Examples from the Java core libraries:
* `java.awt.Container#add(Component)` (practically all over Swing components)
* `javax.faces.component.UIComponent#getChildren()` (practically all over JSF UI components)

## Identification
The composite is easy to recognize by behavioral methods taking an instance of the same abstract/interface type into a tree structure.

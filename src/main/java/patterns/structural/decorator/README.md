# Intent
**Decorator** is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

# Applicability
* Use this pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the code that uses these objects.
* Use this pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.

# Pros
* _Single Responsibility Principle_. You can divide a monolithic class that implements many possible variants of behavior into several smaller classes.
* You can combine several behaviors by wrapping an object into multiple decorators.
* You can add or remove responsibilities from an object at runtime.
* You can extend an object’s behavior without making a new subclass.

# Cons
* It’s hard to remove a specific wrapper from the wrappers stack.
* It’s hard to implement a decorator in such a way that its behavior doesn’t depend on the order in the decorators stack.
* The initial configuration code of layers might look pretty ugly.

# Relations with Other Patterns
* **Adapter** changes the interface of an existing object, while **Decorator** enhances an object without changing its interface. In addition, **Decorator** supports recursive composition, which isn’t possible when you use **Adapter**.
* **Adapter** provides a different interface to the wrapped object, **Proxy** provides it with the same interface, and **Decorator** provides it with an enhanced interface.
* **Chain of Responsibility** and **Decorator** have very similar class structures. Both patterns rely on recursive composition to pass the execution through a series of objects. However, there are several crucial differences.
The **Chain of Responsibility** handlers can execute arbitrary operations independently of each other. They can also stop passing the request further at any point. On the other hand, various **Decorators** can extend the object’s behavior while keeping it consistent with the base interface. In addition, decorators aren’t allowed to break the flow of the request.
* **Composite** and **Decorator** have similar structure diagrams since both rely on recursive composition to organize an open-ended number of objects.
A Decorator is like a **Composite** but only has one child component. There’s another signicant difference: Decorator adds additional responsibilities to the wrapped object, while **Composite** just "sums up" its children’s results.
However, the patterns can also cooperate: you can use Decorator to extend the behavior of a specific object in the **Composite** tree.
* Designs that make heavy use of **Composite** and **Decorator** can often benefit from using **Prototype**. Applying the pattern lets you clone complex structures instead of re-constructing them from scratch.
* **Decorator** lets you change the skin of an object, while **Strategy** lets you change the guts.
* **Decorator** and **Proxy** have similar structures, but very different intents. Both patterns are built on the composition principle, where one object is supposed to delegate some of the work to another. The difference is that a **Proxy** usually manages the life cycle of its service object on its own, whereas the composition of **Decorators** is always controlled by the client.

## Usage
The Decorator is pretty standard in Java code, especially in code related to streams.

Examples from the Java core libraries:
* All subclasses of `java.io.InputStream`, `OutputStream`, `Reader` and `Writer` have constructors that accept objects of their own type.
* `java.util.Collections`, methods `checkedXXX()`, `synchronizedXXX()` and `unmodifiableXXX(`).
* `javax.servlet.http.HttpServletRequestWrapper` and `HttpServletResponseWrapper`

## Identification
Decorator can be recognized by creation methods or constructor that accept objects of the same class or interface as a current class.

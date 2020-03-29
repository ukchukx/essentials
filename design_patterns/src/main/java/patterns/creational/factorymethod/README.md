# Intent
**Factory Method** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

# Applicability
* Use this pattern when you don’t know beforehand the exact types and dependencies of the objects your code should work with.
* Use this pattern when you want to provide users of your library or framework with a way to extend its internal components.
* Use this pattern when you want to save system resources by reusing existing objects instead of rebuilding them each time.

# Pros
* You avoid tight coupling between the creator and the concrete products.
* _Open/Closed Principle_. You can introduce new types of products into the program without breaking existing client code.
* _Single Responsibility Principle_. You can move the product creation code into one place in the program, making the code easier to support.

# Cons
* The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.

# Relations with Other Patterns
* Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
* **Abstract Factory** classes are often based on a set of **Factory Methods**, but you can also use **Prototype** to compose the methods on these classes.
* You can use **Factory Method** along with **Iterator** to let collection subclasses return different types of iterators that are compatible with the collections.
* **Prototype** isn’t based on inheritance, so it doesn’t have its drawbacks. On the other hand, **Prototype** requires a complicated initialization of the cloned object. **Factory Method** is based on inheritance but doesn’t require an initialization step.
* **Factory Method** is a specialization of **Template Method**. At the same time, a **Factory Method** may serve as a step in a large **Template Method**.

## Usage
The Factory Method pattern is widely used in Java code. It’s very useful when you need to provide a high level of flexibility for your code.

Examples from the Java core libraries:
* `java.util.Calendar#getInstance()`
* `java.util.ResourceBundle#getBundle()`
* `java.text.NumberFormat#getInstance()`
* `java.nio.charset.Charset#forName()`
* `java.net.URLStreamHandlerFactory#createURLStreamHandler(String)` (Returns different singleton objects, depending on a protocol)
* `java.util.EnumSet#of()`
* `javax.xml.bind.JAXBContext#createMarshaller()` and other similar methods.

## Identification
Factory methods can be recognized by creation methods, which create objects from concrete classes, but return them as objects of abstract type or interface.

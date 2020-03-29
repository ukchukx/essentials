# Intent
**Abstract Factory** is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

# Applicability
* Use this pattern when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.
* Use this pattern when you have several classes that contain almost identical algorithms with some minor differences. As a result, you might need to modify all classes when the algorithm changes.

# Pros
* You can be sure that the products you’re getting from a factory are compatible with each other.
* You avoid tight coupling between concrete products and client code.
* _Single Responsibility Principle_. You can extract the product creation code into one place, making the code easier to support.
* _Open/Closed Principle_. You can introduce new variants of products without breaking existing client code.

# Cons
* The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.

# Relations with Other Patterns
* Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
* **Builder** focuses on constructing complex objects step by step. **Abstract Factory** specializes in creating families of related objects. **Abstract Factory** returns the product immediately, whereas **Builder** lets you run some additional construction steps before fetching the product.
* **Abstract Factory** classes are often based on a set of **Factory Methods**, but you can also use **Prototype** to compose the methods on these classes.
* **Abstract Factory** can serve as an alternative to Facade when you only want to hide the way the subsystem objects are created from the client code.
* You can use **Abstract Factory** along with **Bridge**. This pairing is useful when some abstractions defined by **Bridge** can only work with specific implementations. In this case, **Abstract Factory** can encapsulate these relations and hide the complexity from the client code.
* **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.

## Usage
The Abstract Factory pattern is pretty common in Java code. Many frameworks and libraries use it to provide a way to extend and customize their standard components.

Examples from the Java core libraries:
* `javax.xml.parsers.DocumentBuilderFactory#newInstance()`
* `javax.xml.transform.TransformerFactory#newInstance()` 
* `javax.xml.xpath.XPathFactory#newInstance()`

## Identification
The pattern is easy to recognize by methods, which return a factory object. Then, the factory is used for creating specific sub-components.

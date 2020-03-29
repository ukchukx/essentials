# Intent
**Builder** is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

# Applicability
* Use this pattern to get rid of a "telescopic constructor".
* Use this pattern when you want your code to be able to create different representations of some product (for example, stone and wooden houses).
* Use this pattern to construct Composite trees or other complex objects.

# Pros
* You can construct objects step-by-step, defer construction steps or run steps recursively.
* You can reuse the same construction code when building various representations of products
* _Single Responsibility Principle_. You can isolate complex construction code from the business logic of the product.

# Cons
* The overall complexity of the code increases since the pattern requires creating multiple new classes.

# Relations with Other Patterns
* Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
* **Builder** focuses on constructing complex objects step by step. **Abstract Factory** specializes in creating families of related objects. **Abstract Factory** returns the product immediately, whereas **Builder** lets you run some additional construction steps before fetching the product.
* You can use **Builder** when creating complex **Composite** trees because you can program its construction steps to work recursively.
* You can combine **Builder** with **Bridge**: the director class plays the role of the abstraction, while different builders act as implementations.
* You can use **Abstract Factory** along with **Bridge**. This pairing is useful when some abstractions defined by **Bridge** can only work with specific implementations. In this case, **Abstract Factory** can encapsulate these relations and hide the complexity from the client code.
* **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.

## Usage
The Builder pattern is a well-known pattern in Java world. It’s especially useful when you need to create an object with lots of possible configuration options.

Examples from the Java core libraries:
* `java.lang.StringBuilder#append()` (unsynchronized)
* `java.lang.StringBuffer#append()` (synchronized)
* `javax.swing.GroupLayout.Group#addComponent()`
* All implementations of `java.lang.Appendable`
* `java.nio.ByteBuffer#put()` (also in `CharBuffer`, `ShortBuffer`, `IntBuffer`, `LongBuffer`, `FloatBuffer` and `DoubleBuffer`)

## Identification
The Builder pattern can be recognized in class, which has a single creation method and several methods to configure the resulting object. Builder methods often support chaining (for example, `someBuilder->setValueA(1)->setValueB(2)->create()`).

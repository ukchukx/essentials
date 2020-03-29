# Intent
**Adapter** is a structural design pattern that allows objects with incompatible interfaces to collaborate.

# Applicability
* Use the Adapter class when you want to use some existing class, but its interface isn’t compatible with the rest of your code.
* Use the pattern when you want to reuse several existing subclasses that lack some common functionality that can’t be added to the superclass.

# Pros
* _Single Responsibility Principle_. You can separate the interface or data conversion code from the primary business logic of the program.
* _Open/Closed Principle_. You can introduce new types of adapters into the program without breaking the existing client code, as long as they work with the adapters through the client interface.

# Cons
* The overall complexity of the code increases because you need to introduce a set of new interfaces and classes. Sometimes it’s simpler just to change the service class so that it matches the rest of your code.

# Relations with Other Patterns
* **Bridge** is usually designed up-front, letting you develop parts of an application independently of each other. On the other hand, **Adapter** is commonly used with an existing app to make some otherwise-incompatible classes work together nicely.
* **Adapter** changes the interface of an existing object, while **Decorator** enhances an object without changing its interface. In addition, **Decorator** supports recursive composition, which isn’t possible when you use **Adapter**.
* **Adapter** provides a different interface to the wrapped object, **Proxy** provides it with the same interface, and **Decorator** provides it with an enhanced interface.
* **Facade** defines a new interface for existing objects, whereas **Adapter** tries to make the existing interface usable. **Adapter** usually wraps just one object, while **Facade** works with an entire subsystem of objects.
* **Bridge**, **State**, **Strategy** (and to some degree **Adapter**) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.

## Usage
The Adapter pattern is pretty common in Java code. It’s very often used in systems based on some legacy code. In such cases, Adapters make legacy code with modern classes.

Examples from the Java core libraries:
* `java.util.Arrays#asList()`
* `java.util.Collections#list()`
* `java.util.Collections#enumeration()`
* `java.io.InputStreamReader(InputStream)` (returns a `Reader` object)
* `java.io.OutputStreamWriter(OutputStream)` (returns a `Writer` object)
* `javax.xml.bind.annotation.adapters.XmlAdapter#marshal()` and `#unmarshal()`

## Identification
Adapter is recognizable by a constructor which takes an instance of different abstract/interface type. When the adapter receives a call to any of its methods, it translates parameters to the appropriate format and then directs the call to one or several methods of the wrapped object.

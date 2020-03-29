# Intent
**Facade** is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

# Applicability
* Use this pattern when you need to have a limited but straightforward interface to a complex subsystem.
* Use this pattern when you want to structure a subsystem into layers.

# Pros
* You can isolate your code from the complexity of a subsystem.

# Cons
* A facade can become a god object coupled to all classes of an app.

# Relations with Other Patterns
* **Facade** defines a new interface for existing objects, whereas **Adapter** tries to make the existing interface usable. **Adapter** usually wraps just one object, while **Facade** works with an entire subsystem of objects.
* **Abstract Factory** can serve as an alternative to **Facade** when you only want to hide the way the subsystem objects are created from the client code.
* **Flyweight** shows how to make lots of little objects, whereas **Facade** shows how to make a single object that represents an entire subsystem.
* A **Facade** class can often be transformed into a **Singleton** since a single facade object is sufcient in most cases.
* **Facade** is similar to **Proxy** in that both buffer a complex entity and initialize it on its own. Unlike **Facade**, **Proxy** has the same interface as its service object, which makes them interchangeable.
* **Facade** and **Mediator** have similar jobs: they try to organize collaboration between lots of tightly coupled classes.
  * **Facade** defines a simplified interface to a subsystem of objects, but it doesn’t introduce any new functionality. The subsystem itself is unaware of the facade. Objects within the subsystem can communicate directly.
  * **Mediator** centralizes communication between components of the system. The components only know about the mediator object and don’t communicate directly.

## Usage
The Facade pattern is commonly used in apps written in Java. It’s especially handy when working with complex libraries and APIs.

Examples from the Java core libraries:
* `javax.faces.context.FacesContext` uses `LifeCycle`, `ViewHandler`, `NavigationHandler` classes under the hood, but most clients aren’t aware of that.
* `javax.faces.context.ExternalContext` uses `ServletContext`, `HttpSession`, `HttpServletRequest`, `HttpServletResponse` and others inside.

## Identification
Facade can be recognized in a class that has a simple interface, but delegates most of the work to other classes. Usually, facades manage full life cycle of objects they use.

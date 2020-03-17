# Intent
**Prototype** is a creational design pattern that lets you copy existing objects without making your
code dependent on their classes.

# Applicability
* Use the Prototype pattern when your code shouldn’t depend on the concrete classes of objects that you need to copy.
* Use the pattern when you want to reduce the number of subclasses that only differ in the way they initialize their respective objects. Somebody could have created these subclasses to be able to create objects with a specific conguration.

# Pros
* You can clone objects without coupling to their concrete classes.
* You can get rid of repeated initialization code in favor of cloning pre-built prototypes.
* You can produce complex objects more conveniently.
* You get an alternative to inheritance when dealing with conguration presets for complex objects.

# Cons
* Cloning complex objects that have circular references might be very tricky.

# Relations with Other Patterns
* Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
* **Abstract Factory** classes are often based on a set of **Factory Methods**, but you can also use **Prototype** to compose the methods on these classes.
* **Prototype** can help when you need to save copies of **Commands** into history.
* Designs that make heavy use of **Composite** and **Decorator** can often benefit from using **Prototype**. Applying the pattern lets you clone complex structures instead of re-constructing them from scratch.
* **Prototype** isn’t based on inheritance, so it doesn’t have its drawbacks. On the other hand, **Prototype** requires a complicated initialization of the cloned object. **Factory Method** is based on inheritance but doesn’t require an initialization step.
* Sometimes **Prototype** can be a simpler alternative to **Memento**. This works if the object, the state of which you want to store in the history, is fairly straightforward and doesn’t have links to external resources, or the links are easy to re-establish.
* **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.

## Usage
The Prototype pattern is available in Java out of the box with a `Cloneable` interface.

Examples from the Java core libraries:
* `java.lang.Object#clone()` (class should implement the `java.lang.Cloneable` interface)

## Identification
The prototype can be easily recognized by a clone or copy methods, etc.

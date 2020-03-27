# Intent
**Flyweight** is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.

# Applicability
* Use this pattern only when your program must support a huge number of objects which barely fit into available RAM.

# Pros
* You can save lots of RAM, assuming your program has tons of similar objects.

# Cons
* You might be trading RAM over CPU cycles when some of the context data needs to be recalculated each time somebody calls a flyweight method.
* The code becomes much more complicated. New team members will always be wondering why the state of an entity was separated in such a way.

# Relations with Other Patterns
* You can implement shared leaf nodes of the **Composite** tree as **Flyweights** to save some RAM.
* **Flyweight** shows how to make lots of little objects, whereas **Facade** shows how to make a single object that represents an entire subsystem.
* **Flyweight** would resemble **Singleton** if you somehow managed to reduce all shared states of the objects to just one flyweight object. But there are two fundamental differences between these patterns:
  1. There should be only one **Singleton** instance, whereas a **Flyweight** class can have multiple instances with different intrinsic states.
  2. The **Singleton** object can be mutable. **Flyweight** objects are immutable.

## Usage
The Flyweight pattern has a single purpose: minimizing memory intake. If your program doesn’t struggle with a shortage of RAM, then you might just ignore this pattern for a while.

Examples from the Java core libraries:
* `java.lang.Integer#valueOf(int)` (also `Boolean`, `Byte`, `Character`, `Short`, `Long` and `BigDecimal`)

## Identification
Flyweight can be recognized by a creation method that returns cached objects instead of creating new.

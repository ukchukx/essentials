# Intent
**Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

# Applicability
* Use this pattern when a class in your program should have just a single instance available to all clients; for example, a single database object shared by different parts of the program.
* Use this pattern when you need stricter control over global variables.

# Pros
* You can be sure that a class has only a single instance.
* You gain a global access point to that instance.
* The singleton object is initialized only when it’s requested for the first time.

# Cons
* Violates the _Single Responsibility Principle_. The pattern solves two problems at the time.
* The Singleton pattern can mask bad design, for instance, when the components of the program know too much about each other.
* The pattern requires special treatment in a multithreaded environment so that multiple threads won’t create a singleton object several times.
* It may be difficult to unit test the client code of the **Singleton** because many test frameworks rely on inheritance when producing mock objects. Since the constructor of the singleton class is private and overriding static methods is impossible in most languages, you will need to think of a creative way to mock the singleton. Or just don’t write the tests. Or don’t use the **Singleton** pattern.

# Relations with Other Patterns
* A **Facade** class can often be transformed into a **Singleton** since a single facade object is sufficient in most cases
* **Flyweight** would resemble **Singleton** if you somehow managed to reduce all shared states of the objects to just one **Flyweight** object. But there are two fundamental differences between these patterns:
  1. There should be only one **Singleton** instance, whereas a **Flyweight** class can have multiple instances with different intrinsic states.
  2. The **Singleton** object can be mutable. **Flyweight** objects are immutable.
* **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.

## Usage
A lot of developers consider the Singleton pattern an antipattern. That’s why its usage is on the decline in Java code.

Examples from the Java core libraries:
* `java.lang.Runtime#getRuntime()`
* `java.awt.Desktop#getDesktop()`
* `java.lang.System#getSecurityManager()`

## Identification
Singleton can be recognized by a static creation method, which returns the same cached object.

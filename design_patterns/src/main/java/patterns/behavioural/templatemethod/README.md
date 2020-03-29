# Intent
**Template Method** is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

# Applicability
* Use the Template Method pattern when you want to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure.
* Use the pattern when you have several classes that contain almost identical algorithms with some minor differences. As a result, you might need to modify all classes when the algorithm changes.

# Pros
* You can let clients override only certain parts of a large algorithm, making them less affected by changes that happen to other parts of the algorithm.
* You can pull the duplicate code into a superclass.

# Cons
* Some clients may be limited by the provided skeleton of an algorithm.
* You might violate the Liskov Substitution Principle by suppressing a default step implementation via a subclass.
* Template methods tend to be harder to maintain the more steps they have.

# Relations with Other Patterns
* **Factory Method** is a specialization of **Template Method**. At the same time, a **Factory Method** may serve as a step in a large **Template Method**.
* **Template Method** is based on inheritance: it lets you alter parts of an algorithm by extending those parts in subclasses. **Strategy** is based on composition: you can alter parts of the object’s behavior by supplying it with different strategies that correspond to that behavior. **Template Method** works at the class level, so it’s static. **Strategy** works on the object level, letting you switch behaviors at runtime.

## Usage
The Template Method pattern is quite common in Java frameworks. Developers often use it to provide framework users with a simple means of extending standard functionality using inheritance.

Examples from the Java core libraries:
* All non-abstract methods of `java.io.InputStream`, `java.io.OutputStream`, `java.io.Reader` and `java.io.Writer`.
* All non-abstract methods of `java.util.AbstractList`, `java.util.AbstractSet` and `java.util.AbstractMap`.
* `javax.servlet.http.HttpServlet`, all the `doXXX()` methods by default send a HTTP 405 “Method Not Allowed” error as a response. You’re free to override any of them.

## Identification
Strategy pattern can be recognized by a method that lets nested object do the actual work, as well as the setter that allows replacing that object with a different one.

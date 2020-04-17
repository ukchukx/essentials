# Intent
**Strategy** is a behavioural design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

# Applicability
* Use this pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
* Use this pattern when you have a lot of similar classes that only differ in the way they execute some behaviour.
* Use this pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
* Use this pattern when your class has a massive conditional operator that switches between different variants of the same algorithm.

# Pros
* You can swap algorithms used inside an object at runtime.
* You can isolate the implementation details of an algorithm from the code that uses it.
* You can replace inheritance with composition.
* _Open/Closed Principle_. You can introduce new strategies without having to change the context.

# Cons
* If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern.
* Clients must be aware of the differences between strategies to be able to select a proper one.
* A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces.

# Relations with Other Patterns
* **Bridge**, **State**, **Strategy** (and to some degree **Adapter**) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.
* **Command** and **Strategy** may look similar because you can use both to parameterize an object with some action. However, they have very different intents.
  * You can use **Command** to convert any operation into an object. The operation’s parameters become fields of that object. The conversion lets you defer execution of the operation, queue it, store the history of commands, send commands to remote services, etc.
  * On the other hand, **Strategy** usually describes different ways of doing the same thing, letting you swap these algorithms within a single context class.
* **Decorator** lets you change the skin of an object, while **Strategy** lets you change the guts.
* **Template Method** is based on inheritance: it lets you alter parts of an algorithm by extending those parts in subclasses. **Strategy** is based on composition: you can alter parts of the object’s behaviour by supplying it with different strategies that correspond to that behaviour. **Template Method** works at the class level, so it’s static. **Strategy** works on the object level, letting you switch behaviours at runtime.
* **State** can be considered as an extension of **Strategy**. Both patterns are based on composition: they change the behaviour of the context by delegating some work to helper objects. Strategy makes these objects completely independent and unaware of each other. However, State doesn’t restrict dependencies between concrete states, letting them alter the state of the context at will.

## Usage
The Strategy pattern is very common in Java code. It’s often used in various frameworks to provide users a way to change the behaviour of a class without extending it.

Examples from the Java core libraries:
* `java.util.Comparator#compare()` called from `Collections#sort()`.
* `javax.servlet.http.HttpServlet`: `service()` method, plus all of the `doXXX()` methods that accept `HttpServletRequest` and `HttpServletResponse` objects as arguments.
* `javax.servlet.Filter#doFilter()`

## Identification
Strategy pattern can be recognized by a method that lets nested object do the actual work, as well as the setter that allows replacing that object with a different one.


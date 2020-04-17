# Intent
**Mediator** is a behavioural design pattern that lets you reduce chaotic dependencies between
objects. The pattern restricts direct communications between the objects and forces them to
collaborate only via a mediator object.

# Applicability
* Use this pattern when it’s hard to change some of the classes because they are tightly coupled to a bunch of other classes.
* Use this pattern when you can’t reuse a component in a different program because it’s too dependent on other components.
* Use this pattern when you find yourself creating tons of component subclasses just to reuse some basic behaviour in various contexts.

# Pros
* _Single Responsibility Principle_. You can extract the communications between various components into a single place, making it easier to comprehend and maintain.
* _Open/Closed Principle_. You can introduce new mediators without having to change the actual components.
* You can reduce coupling between various components of a program.
* You can reuse individual components more easily.

# Cons
* Over time a mediator can evolve into a God Object.

# Relations with Other Patterns
* **Chain of Responsibility**, **Command**, **Mediator** and **Observer** address various ways of connecting senders and receivers of requests:
  * *Chain of Responsibility* passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
  * *Command* establishes unidirectional connections between senders and receivers.
  * *Mediator* eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
  * *Observer* lets receivers dynamically subscribe to and unsubscribe from receiving requests.
* **Facade** and **Mediator** have similar jobs: they try to organize collaboration between lots of tightly coupled classes.
  * **Facade** defines a simplified interface to a subsystem of objects, but it doesn’t introduce any new functionality. The subsystem itself is unaware of the facade. Objects within the subsystem can communicate directly.
  * **Mediator** centralizes communication between components of the system. The components only know about the mediator object and don’t communicate directly.
* The difference between **Mediator** and **Observer** is often elusive. In most cases, you can implement either of these patterns; but sometimes you can apply both simultaneously. Let’s see how we can do that. The primary goal of **Mediator** is to eliminate mutual dependencies among a set of system components. Instead, these components become dependent on a single mediator object. The goal of **Observer** is to establish dynamic one-way connections between objects, where some objects act as subordinates of others.

## Usage
The most popular usage of the Mediator pattern in Java code is facilitating communications between GUI components of an app. The synonym of the Mediator is the Controller part of MVC pattern.

### Examples from the Java core libraries
`java.util.Timer` (all `scheduleXXX()` methods)

`java.util.concurrent.Executor#execute()`

`java.util.concurrent.ExecutorService` (`invokeXXX()` and `submit()` methods)

`java.util.concurrent.ScheduledExecutorService` (all `scheduleXXX()` methods)

`java.lang.reflect.Method#invoke()`

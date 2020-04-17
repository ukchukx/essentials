# Intent
**Observer** is a behavioural design pattern that lets you define a subscription mechanism to notify
multiple objects about any events that happen to the object they’re observing.

# Applicability
* Use this pattern when changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.
* Use this pattern when some objects in your app must observe others, but only for a limited time or in specific cases.

# Pros
* You can establish relations between objects at runtime.
* _Open/Closed Principle_. You can introduce new subscriber classes without having to change the publisher’s code (and vice versa if there’s a publisher interface).

# Cons
* Subscribers are notified in random order.

# Relations with Other Patterns
* **Chain of Responsibility**, **Command**, **Mediator** and **Observer** address various ways of connecting senders and receivers of requests:
  * *Chain of Responsibility* passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
  * *Command* establishes unidirectional connections between senders and receivers.
  * *Mediator* eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
  * *Observer* lets receivers dynamically subscribe to and unsubscribe from receiving requests.
* The difference between **Mediator** and **Observer** is often elusive. In most cases, you can implement either of these patterns; but sometimes you can apply both simultaneously. Let’s see how we can do that. The primary goal of **Mediator** is to eliminate mutual dependencies among a set of system components. Instead, these components become dependent on a single mediator object. The goal of **Observer** is to establish dynamic one-way connections between objects, where some objects act as subordinates of others.

## Usage
The Observer pattern is pretty common in Java code, especially in the GUI components. It provides a way to react to events happening in other objects without coupling to their classes.

Examples from the Java core libraries:
* `java.util.Observer`/`java.util.Observable`
* All implementations of `java.util.EventListener`
* `javax.servlet.http.HttpSessionBindingListener`
* `javax.servlet.http.HttpSessionAttributeListener`
* `javax.faces.event.PhaseListener`

## Identification
The pattern can be recognized by subscription methods, that store objects in a list and by calls to the update method issued to objects in that list.


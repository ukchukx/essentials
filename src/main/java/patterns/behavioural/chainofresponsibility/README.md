# Intent
**Chain of Responsibility** is a patterns.behavioural design pattern that lets you pass requests along a chain
of handlers. Upon receiving a request, each handler decides either to process the request or to
pass it to the next handler in the chain.

# Applicability
* Use this pattern when your program is expected to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand.
* Use this pattern when it’s essential to execute several handlers in a particular order.
* Use this pattern when the set of handlers and their order are supposed to change at runtime.

# Pros
* You can control the order of request handling.
* _Single Responsibility Principle_. You can decouple classes that invoke operations from classes that perform operations.
* _Open/Closed Principle_. You can introduce new handlers into the app without breaking the existing client code.

# Cons
* Some requests may end up unhandled.

# Relations with Other Patterns
* **Chain of Responsibility**, **Command**, **Mediator** and **Observer** address various ways of connecting senders and receivers of requests:
  * *Chain of Responsibility* passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
  * *Command* establishes unidirectional connections between senders and receivers.
  * *Mediator* eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
  * *Observer* lets receivers dynamically subscribe to and unsubscribe from receiving requests.
* **Chain of Responsibility** is often used in conjunction with **Composite**. In this case, when a leaf component gets a request, it may pass it through the chain of all of the parent components down to the root of the object tree.
* Handlers in **Chain of Responsibility** can be implemented as **Commands**. In this case, you can execute a lot of different operations over the same context object, represented by a request. However, there’s another approach, where the request itself is a Command object. In this case, you can execute the same operation in a series of different contexts linked into a chain.
* **Chain of Responsibility** and **Decorator** have very similar class structures. Both patterns rely on recursive composition to pass the execution through a series of objects. However, there are several crucial differences. The **Chain of Responsibility** handlers can execute arbitrary operations independently of each other. They can also stop passing the request further at any point. On the other hand, various Decorators can extend the object’s behavior while keeping it consistent with the base interface. In addition, decorators aren’t allowed to break the ow of the request.


## Usage
The Chain of Responsibility pattern isn’t a frequent guest in a Java program since it’s only relevant when code operates with chains of objects.
One of the most popular use cases for the pattern is bubbling events to the parent components in GUI classes. Another notable use case is sequential access filters. 

Examples from the Java core libraries:
* `javax.servlet.Filter#doFilter()`
* `java.util.logging.Logger#log()`

## Identification
The pattern is recognizable by behavioral methods of one group of objects indirectly calling the same methods in other objects, while all the objects follow the common interface.


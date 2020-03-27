# Intent
**Command** is a behavioural design pattern that turns a request into a stand-alone object that
contains all information about the request. This transformation lets you parameterize methods
with different requests, delay or queue a request’s execution, and support undoable operations.

# Applicability
* Use this pattern when you want to parameterize objects with operations.
* Use this pattern when you want to queue operations, schedule their execution, or execute them remotely.
* Use this pattern when you want to implement reversible operations.

# Pros
* _Single Responsibility Principle_. You can decouple classes that invoke operations from classes that perform these operations.
* _Open/Closed Principle_. You can introduce new commands into the app without breaking existing client code.
* You can implement undo/redo.
* You can implement deferred execution of operations.
* You can assemble a set of simple commands into a complex one.

# Cons
* The code may become more complicated since you’re introducing a whole new layer between senders and receivers.

# Relations with Other Patterns
* **Chain of Responsibility**, **Command**, **Mediator** and **Observer** address various ways of connecting senders and receivers of requests:
  * *Chain of Responsibility* passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
  * *Command* establishes unidirectional connections between senders and receivers.
  * *Mediator* eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
  * *Observer* lets receivers dynamically subscribe to and unsubscribe from receiving requests.
* You can use **Command** and **Memento** together when implementing "undo" In this case, commands are responsible for performing various operations over a target object, while mementos save the state of that object just before a command gets executed.
* Handlers in **Chain of Responsibility** can be implemented as **Commands**. In this case, you can execute a lot of different operations over the same context object, represented by a request. However, there’s another approach, where the request itself is a Command object. In this case, you can execute the same operation in a series of different contexts linked into a chain.
* **Prototype** can help when you need to save copies of **Commands** into history
* You can treat **Visitor** as a powerful version of the **Command** pattern. Its objects can execute operations over various objects of different classes.
* **Command** and **Strategy** may look similar because you can use both to parameterize an object with some action. However, they have very different intents.
  * You can use **Command** to convert any operation into an object. The operation’s parameters become fields of that object. The conversion lets you defer execution of the operation, queue it, store the history of commands, send commands to remote services, etc.
  * On the other hand, **Strategy** usually describes different ways of doing the same thing, letting you swap these algorithms within a single context class.

## Usage
The Command pattern is pretty common in Java code. Most often it’s used as an alternative for callbacks to parameterizing UI elements with actions. It’s also used for queueing tasks, tracking operations history, etc.

Examples from the Java core libraries:
* All implementations of `java.lang.Runnable`
* All implemantations of `javax.swing.Action`

## Identification
The Command pattern is recognizable by behavioral methods in an abstract/interface type (sender) which invokes a method in an implementation of a different abstract/interface type (receiver) which has been encapsulated by the command implementation during its creation. Command classes are usually limited to specific actions.

# Intent
**Memento** is a behavioural design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.

# Applicability
* Use this pattern when you want to produce snapshots of the object’s state to be able to restore a previous state of the object.
* Use this pattern when direct access to the object’s fields/getters/setters violates its encapsulation.
* Use this pattern when you find yourself creating tons of component subclasses just to reuse some basic behaviour in various contexts.

# Pros
* You can produce snapshots of the object’s state without violating its encapsulation.
* You can simplify the originator’s code by letting the caretaker maintain the history of the originator’s state.

# Cons
* The app might consume lots of RAM if clients create mementos too often.
* Caretakers should track the originator’s lifecycle to be able to destroy obsolete mementos.
* Most dynamic programming languages, such as PHP, Python and JavaScript, can’t guarantee that the state within the memento stays untouched.

# Relations with Other Patterns
* You can use **Command** and **Memento** together when implementing “undo”. In this case, commands are responsible for performing various operations over a target object, while mementos save the state of that object just before a command gets executed.
* You can use **Memento** along with **Iterator** to capture the current iteration state and roll it back if necessary.
* Sometimes **Prototype** can be a simpler alternative to **Memento**. This works if the object, the state of which you want to store in the history, is fairly straightforward and doesn’t have links to external resources, or the links are easy to re-establish.

## Usage
The Memento’s principle can be achieved using the serialization, which is quite common in Java. While it’s not the only and the most efficient way to make snapshots of an object’s state, it still allows storing state backups while protecting the originator’s structure from other objects.

Examples from the Java core libraries:
* All `java.io.Serializable` implementations can simulate the Memento.
* All `javax.faces.component.StateHolder` implementations.

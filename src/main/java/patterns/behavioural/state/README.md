# Intent
**State** is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.

# Applicability
* Use this pattern when you have an object that behaves differently depending on its current state, the number of states is enormous, and the state-specific code changes frequently.
* Use this pattern when you have a class polluted with massive conditionals that alter how the class behaves according to the current values of the class’s fields.
* Use this pattern when you have a lot of duplicate code across similar states and transitions of a condition-based state machine.

# Pros
* _Single Responsibility Principle_. Organize the code related to particular states into separate classes.
* _Open/Closed Principle_. Introduce new states without changing existing state classes or the context.
* Simplify the code of the context by eliminating bulky state machine conditionals.

# Cons
* Subscribers are notified in random order.

# Relations with Other Patterns
* **Bridge**, **State**, **Strategy** (and to some degree **Adapter**) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.
* **State** can be considered as an extension of **Strategy**. Both patterns are based on composition: they change the behavior of the context by delegating some work to helper objects. Strategy makes these objects completely independent and unaware of each other. However, State doesn’t restrict dependencies between concrete states, letting them alter the state of the context at will.

## Usage
The State pattern is commonly used in Java to convert massive switch-base state machines into the objects.

Examples from the Java core libraries:
* `javax.faces.lifecycle.LifeCycle#execute()` (controlled by the `FacesServlet`: behaviour is dependent on current phase (state) of JSF lifecycle)

## Identification
State pattern can be recognized by methods that change their behavior depending on the objects’ state, controlled externally.


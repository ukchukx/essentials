# Intent
**Iterator** is a behavioural design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

# Applicability
* Use this pattern when your collection has a complex data structure under the hood, but you want to hide its complexity from clients (either for convenience or security reasons).
* Use this pattern to reduce duplication of the traversal code across your app.
* Use this pattern when you want your code to be able to traverse different data structures or when types of these structures are unknown beforehand.

# Pros
* _Single Responsibility Principle_. You can clean up the client code and the collections by extracting bulky traversal algorithms into separate classes.
* _Open/Closed Principle_. You can implement new types of collections and iterators and pass them to existing code without breaking anything.
* You can iterate over the same collection in parallel because each iterator object contains its own iteration state.
* For the same reason, you can delay an iteration and continue it when needed.

# Cons
* Applying the pattern can be an overkill if your app only works with simple collections.
* Using an iterator may be less efficient than going through elements of some specialized collections directly.

# Relations with Other Patterns
* You can use **Iterators** to traverse **Composite** trees.
* You can use **Factory Method** along with **Iterator** to let collection subclasses return different types of iterators that are compatible with the collections.
* You can use **Memento** along with **Iterator** to capture the current iteration state and roll it back if necessary.
* You can use **Visitor** along with **Iterator** to traverse a complex data structure and execute some operation over its elements, even if they all have different classes.

## Usage
The pattern is very common in Java code. Many frameworks and libraries use it to provide a standard way for traversing their collections.

Examples from the Java core libraries:
* All implementations of `java.util.Iterator` (also `java.util.Scanner`).
* All implementations of `java.util.Enumeration`

## Identification
Iterator is easy to recognize by the navigation methods (such as `next`, `previous` and others). Client code that uses iterators might not have direct access to the collection being traversed.

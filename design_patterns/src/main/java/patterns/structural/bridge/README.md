# Intent
**Bridge** is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

# Applicability
* Use this pattern when you want to divide and organize a monolithic class that has several variants of some functionality (for example, if the class can work with various database servers).
* Use this pattern when you need to extend a class in several orthogonal (independent) dimensions.
* Use this pattern if you need to be able to switch implementations at runtime.

# Pros
* _Single Responsibility Principle_. You can focus on high-level logic in the abstraction and on platform details in the implementation.
* _Open/Closed Principle_. You can introduce new abstractions and implementations independently from each other.
* You can create platform-independent classes and apps.
* The client code works with high-level abstractions. It isn’t exposed to the platform details.

# Cons
* You might make the code more complicated by applying the pattern to a highly cohesive class.

# Relations with Other Patterns
* **Bridge** is usually designed up-front, letting you develop parts of an application independently of each other. On the other hand, **Adapter** is commonly used with an existing app to make some otherwise-incompatible classes work together nicely.
* You can combine **Builder** with **Bridge**: the director class plays the role of the abstraction, while different builders act as implementations.
* You can use **Abstract Factory** along with **Bridge**. This pairing is useful when some abstractions dened by **Bridge** can only work with specic implementations. In this case, **Abstract Factory** can encapsulate these relations and hide the complexity from the client code.
* **Bridge**, **State**, **Strategy** (and to some degree **Adapter**) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.

## Usage
The Bridge pattern is especially useful when dealing with cross-platform apps, supporting multiple types of database servers or working with several API providers of a certain kind (for example, cloud platforms, social networks, etc.)

## Identification
Bridge can be recognized by a clear distinction between some controlling entity and several different platforms that it relies on.

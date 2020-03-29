# Intent
**Proxy** is a structural design pattern that lets you provide a substitute or placeholder for another
object. A proxy controls access to the original object, allowing you to perform something either
before or after the request gets through to the original object.

# Applicability
* Lazy initialization (virtual proxy). This is when you have a heavyweight service object that wastes system resources by being always up, even though you only need it from time to time.
* Access control (protection proxy). This is when you want only specic clients to be able to use the service object; for instance, when your objects are crucial parts of an operating system and clients are various launched applications (including malicious ones).
* Local execution of a remote service (remote proxy). This is when the service object is located on a remote server.
*  Logging requests (logging proxy). This is when you want to keep a history of requests to the service object.
* Caching request results (caching proxy). This is when you need to cache results of client requests and manage the life cycle of this cache, especially if results are quite large.
* Smart reference. This is when you need to be able to dismiss a heavyweight object once there are no clients that use it.

# Pros
* You can control the service object without clients knowing about it.
* You can manage the lifecycle of the service object when clients don’t care about it.
* The proxy works even if the service object isn’t ready or is not available.
* _Open/Closed Principle_. You can introduce new proxies without changing the service or clients.

# Cons
* The code may become more complicated since you need to introduce a lot of new classes.
* The response from the service might get delayed.

# Relations with Other Patterns
* **Adapter** provides a different interface to the wrapped object, **Proxy** provides it with the same interface, and **Decorator** provides it with an enhanced interface.
* **Facade** is similar to **Proxy** in that both buffer a complex entity and initialize it on its own. Unlike **Facade**, **Proxy** has the same interface as its service object, which makes them interchangeable.
* **Decorator** and **Proxy** have similar structures, but very different intents. Both patterns are built on the composition principle, where one object is supposed to delegate some of the work to another. The difference is that a **Proxy** usually manages the life cycle of its service object on its own, whereas the composition of **Decorators** is always controlled by the client.

## Usage
While the Proxy pattern isn’t a frequent guest in most Java applications, it’s still very handy in some special cases. It’s irreplaceable when you want to add some additional behaviors to an object of some existing class without changing the client code.

Examples from the Java core libraries:
* `java.lang.reflect.Proxy`
* `java.rmi.*`
* `javax.ejb.EJB (see comments)`
* `javax.inject.Inject (see comments)`
* `javax.persistence.PersistenceContext`

## Identification
Proxies delegate all of the real work to some other object. Each proxy method should, in the end, refer to a service object unless the proxy is a subclass of a service.

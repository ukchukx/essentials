package patterns.behavioural.chainofresponsibility;

import patterns.behavioural.chainofresponsibility.middleware.Middleware;
import patterns.behavioural.chainofresponsibility.middleware.RoleCheckMiddleware;
import patterns.behavioural.chainofresponsibility.middleware.ThrottlingMiddleware;
import patterns.behavioural.chainofresponsibility.middleware.UserExistsMiddleware;
import patterns.behavioural.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Filtering access.
 * This example shows how a request containing user data passes a sequential chain of handlers that perform 
 * various things such as authentification, authorization, and validation.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
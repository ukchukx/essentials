package patterns.creational.abstractfactory;

import patterns.creational.abstractfactory.app.Application;
import patterns.creational.abstractfactory.factories.GUIFactory;
import patterns.creational.abstractfactory.factories.MacOSFactory;
import patterns.creational.abstractfactory.factories.WindowsFactory;

/**
 * Families of cross-platform GUI components and their production.
 * In this example, buttons and checkboxes will act as products. They have two variants: macOS and Windows.
 * The abstract factory defines an interface for creating buttons and checkboxes. 
 * There are two concrete factories, which return both products in a single variant.
 * Client code works with factories and products using abstract interfaces. It makes the same client code working 
 * with many product variants, depending on the type of factory object.
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
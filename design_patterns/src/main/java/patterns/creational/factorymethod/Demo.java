package patterns.creational.factorymethod;

import patterns.creational.factorymethod.factory.Dialog;
import patterns.creational.factorymethod.factory.HtmlDialog;
import patterns.creational.factorymethod.factory.WindowsDialog;

/**
 * Production of cross-platform GUI elements
 * In this example, Buttons play a product role and dialogs act as creators.
 * Different types of dialogs require their own types of elements. That’s why we create a subclass for each 
 * dialog type and override their factory methods.
 * Now, each dialog type will instantiate proper button classes. Base dialog works with products using their 
 * common interface, that’s why its code remains functional after all changes.
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
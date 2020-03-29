package patterns.creational.abstractfactory.app;

import patterns.creational.abstractfactory.buttons.Button;
import patterns.creational.abstractfactory.checkboxes.Checkbox;
import patterns.creational.abstractfactory.factories.GUIFactory;

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
package patterns.creational.abstractfactory.factories;

import patterns.creational.abstractfactory.buttons.Button;
import patterns.creational.abstractfactory.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
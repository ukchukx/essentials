package patterns.creational.abstractfactory.factories;

import patterns.creational.abstractfactory.buttons.Button;
import patterns.creational.abstractfactory.buttons.WindowsButton;
import patterns.creational.abstractfactory.checkboxes.Checkbox;
import patterns.creational.abstractfactory.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
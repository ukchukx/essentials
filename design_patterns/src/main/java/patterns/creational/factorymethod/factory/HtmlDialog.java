package patterns.creational.factorymethod.factory;

import patterns.creational.factorymethod.buttons.Button;
import patterns.creational.factorymethod.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
package patterns.behavioural.mediator;

import patterns.behavioural.mediator.components.*;
import patterns.behavioural.mediator.mediator.Editor;
import patterns.behavioural.mediator.mediator.Mediator;

import javax.swing.*;

/**
 * Notes app. 
 * This example shows how to organize lots of GUI elements so 
 * that they cooperate with the help of a mediator but don’t depend on each other.
 */
public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
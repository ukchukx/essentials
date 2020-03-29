package patterns.behavioural.memento;

import patterns.behavioural.memento.editor.Editor;
import patterns.behavioural.memento.shapes.Circle;
import patterns.behavioural.memento.shapes.CompoundShape;
import patterns.behavioural.memento.shapes.Dot;
import patterns.behavioural.memento.shapes.Rectangle;

import java.awt.*;

/**
 * Shape editor and complex undo/redo.
 * This graphical editor allows changing the color and position of the shapes on the screen. 
 * Any modification can be undone and repeated, though.
 * The “undo” is based on the collaboration between the Memento and Command patterns. 
 * The editor tracks a history of performed commands. Before executing any command, it makes a backup 
 * and connects it to the command object. After the execution, it pushes the executed command into history.
 * When a user requests the undo, the editor fetches a recent command from the history and restores the state 
 * from the backup kept inside that command. If the user requests another undo, the editor takes a following 
 * command from the history and so on.
 * Reverted commands are kept in history until the user makes some modifications to the shapes on the screen. 
 * This is crucial for redoing undone commands.
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
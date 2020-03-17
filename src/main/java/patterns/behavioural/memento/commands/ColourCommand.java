package patterns.behavioural.memento.commands;

import patterns.behavioural.memento.editor.Editor;
import patterns.behavioural.memento.shapes.Shape;

import java.awt.*;

public class ColourCommand implements Command {
    private Editor editor;
    private Color color;

    public ColourCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
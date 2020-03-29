package patterns.behavioural.command;

import patterns.behavioural.command.editor.Editor;

/**
 * Text editor commands and undo.
 * The text editor in this example creates new command objects each time a user interacts with it. 
 * After executing its actions, a command is pushed to the history stack.
 * Now, to perform the undo operation, the application takes the last executed command from the history 
 * and either performs an inverse action or restores the past state of the editor, saved by that command.
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
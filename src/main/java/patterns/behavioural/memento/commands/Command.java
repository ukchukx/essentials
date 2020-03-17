package patterns.behavioural.memento.commands;

public interface Command {
    String getName();
    void execute();
}
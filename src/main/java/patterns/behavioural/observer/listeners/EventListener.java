package patterns.behavioural.observer.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
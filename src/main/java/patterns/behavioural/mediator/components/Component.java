package patterns.behavioural.mediator.components;

import patterns.behavioural.mediator.mediator.Mediator;

/**
 * Common component interface.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
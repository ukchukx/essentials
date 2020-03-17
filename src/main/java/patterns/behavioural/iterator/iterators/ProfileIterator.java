package patterns.behavioural.iterator.iterators;

import patterns.behavioural.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
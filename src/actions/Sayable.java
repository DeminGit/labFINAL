package actions;

import Exceptions.IllegalLanguageException;

public interface Sayable {
    void say(String words) throws IllegalLanguageException;
}

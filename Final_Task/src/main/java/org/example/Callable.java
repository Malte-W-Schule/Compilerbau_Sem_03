package org.example;

import java.util.List;

public interface Callable {
    public void call(Environment env, List<Object> args);
}

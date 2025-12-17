import java.util.List;

// Ein Interface für alles, was man aufrufen kann
public interface LispFunction {
    Object apply(List<Object> args);
}
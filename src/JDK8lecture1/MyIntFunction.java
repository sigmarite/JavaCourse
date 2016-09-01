package JDK8lecture1;

import java.util.function.Function;

/**
 * Created by mpividori on 31/08/2016.
 */

@FunctionalInterface
public interface MyIntFunction<T> {

    public T apply(int i);
}

package exception;

import java.util.Set;
import java.util.HashSet;

public class OneInstanceException extends Throwable {

    private static Set<Class> instances = new HashSet<>();
    public OneInstanceException() {
        if (instances.contains(this.getClass())) {
            throw new IllegalStateException();
        }
        instances.add(getClass());
    }
    
}

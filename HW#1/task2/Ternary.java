package Task2;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ternary <T> {
    private T ifTrue(T obj)
    {
        return obj;
    }

    private T ifFalse(T obj)
    {
        return null;
    }

    private Predicate<T> condition = (obj) -> obj.toString().length() % 2 == 0;

    public UnaryOperator<T> ternaryOperator = (obj)->
    {
        if (condition.test(obj))
            return ifTrue(obj);
        else
            return ifFalse(obj);
    };
}

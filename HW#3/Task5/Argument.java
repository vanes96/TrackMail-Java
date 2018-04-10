package Task5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface Argument {
    String value();
    String type() default "Integer";
}


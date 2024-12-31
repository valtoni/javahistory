package org.github.valtoni.java8;

import java.lang.annotation.*;

@Repeatable(AnnotationsSample.class)
@interface AnnotationSample {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotationsSample {
    AnnotationSample[] value();
}


@AnnotationSample("First")
@AnnotationSample("Second")
public class RepeatedAnnotationExample {

    public static void main(String[] args) {
        AnnotationSample[] annotations = RepeatedAnnotationExample.class.getAnnotationsByType(AnnotationSample.class);
        for (AnnotationSample annotation: annotations) {
            System.out.println(annotation.value());
        }
    }

}

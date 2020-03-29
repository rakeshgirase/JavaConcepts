package com.exuberant.tutorials.javaconcept.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MyAnnotation(lastName = "Girase", name = "Rakesh")
public class AnnotateDemo {

    private static Logger logger = LoggerFactory.getLogger(AnnotateDemo.class);

    @MyAnnotation(lastName = "integer", name = "long")
    private int number;

    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException, NoSuchFieldException {
        AnnotateDemo a = new AnnotateDemo();
        MyAnnotation clazz = a.getClass().getAnnotation(MyAnnotation.class);
        logger.info("================Object================");
        logger.info("Class: {} {}", clazz.name(), clazz.lastName());
        logger.info("================Method================");
        MyAnnotation meth = a.getClass().getMethod("brother").getAnnotation(MyAnnotation.class);
        logger.info("Brother {} {}", meth.name(), meth.lastName());

        logger.info("================Instance Variable================");
        MyAnnotation instance = a.getClass().getDeclaredField("number").getAnnotation(MyAnnotation.class);
        logger.info("Instance Variable {} {}", instance.name(), instance.lastName());

        logger.info("================Local Variable================");
        a.getClass().getMethod("brother").getDeclaredAnnotations();

		/*MyAnnotation local = a.getClass().getMethod("brother");
        logger.info("Instance Variable " + local.name() + " " + local.lastName());*/
    }

    @MyAnnotation(lastName = "Girase", name = "Roshan")
    public void brother() {
        @MyAnnotation(lastName = "Local", name = "Roshan")
        int test = 1;
        logger.info("Inside Print: {}", test);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

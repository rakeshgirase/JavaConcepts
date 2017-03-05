package com.exuberant.tutorials.javaconcept.annotation;


@MyAnnotation(lastName = "Girase", name = "Rakesh")
public class AnnotateDemo {

    @MyAnnotation(lastName = "integer", name = "long")
    private int number;

    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException, NoSuchFieldException {
        AnnotateDemo a = new AnnotateDemo();
        MyAnnotation clazz = a.getClass().getAnnotation(MyAnnotation.class);
        System.out.println("================Object================");
        System.out.println("Class " + clazz.name() + " " + clazz.lastName());
        System.out.println("================Method================");
        MyAnnotation meth = a.getClass().getMethod("brother").getAnnotation(MyAnnotation.class);
        System.out.println("Brother " + meth.name() + " " + meth.lastName());

        System.out.println("================Instance Variable================");
        MyAnnotation instance = a.getClass().getDeclaredField("number").getAnnotation(MyAnnotation.class);
        System.out.println("Instance Variable " + instance.name() + " " + instance.lastName());

        System.out.println("================Local Variable================");
        a.getClass().getMethod("brother").getDeclaredAnnotations();

		/*MyAnnotation local = a.getClass().getMethod("brother");
        System.out.println("Instance Variable " + local.name() + " " + local.lastName());*/
    }

    @MyAnnotation(lastName = "Girase", name = "Roshan")
    public void brother() {
        @MyAnnotation(lastName = "Local", name = "Roshan")
        int test = 1;
        System.out.println("Inside Print" + test);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

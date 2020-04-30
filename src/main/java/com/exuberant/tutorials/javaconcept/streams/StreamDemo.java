package com.exuberant.tutorials.javaconcept.streams;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDemo {

    static Predicate<Integer> isOdd = number -> number % 2 != 0;
    private static Predicate<Integer> isDivisibleByTen = number -> number % 10 == 0;
    private static Predicate<Integer> isDivisibleByFive = number -> number % 5 == 0;


    static Function<Integer, Predicate<Integer>> divisibleBy = divisor -> (number -> {
        System.err.println("number " + number + "divisor: " + divisor);
        return number % divisor == 0;
    });

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 6, 8, 9, 8, 9);

        Optional<Integer> firstNumberDivisibleByTen = getFirstDivsibleByTen(numbers);
        if (firstNumberDivisibleByTen.isPresent()) {
            System.err.println("First Number is " + firstNumberDivisibleByTen.get());
        }
        Optional<Integer> firstNumberDivisibleByFive = getFirstDivsibleByFive(numbers);
        if (firstNumberDivisibleByFive.isPresent()) {
            System.err.println("First Number is " + firstNumberDivisibleByFive.get());
        }

        Optional<Integer> firstNumberDivisibleByFive2 = numbers.stream().filter(divisibleBy.apply(5)).findFirst();
        Optional<Integer> firstNumberDivisibleByTen2 = numbers.stream().filter(divisibleBy.apply(10)).findFirst();


        long start = System.currentTimeMillis();
        numbers.stream().forEach(n -> sleepAndPrint(n));
        long end = System.currentTimeMillis();
        System.err.println("Time Taken " + (end - start));
        //Terminal Operations - forEach, collect,
        //Intermediate Operations - filter, stream, map
        //Method Reference - When you have one argument - represented by ::
        Employee e = new Employee(1, null, null);
        List<Integer> evenNumbers = numbers.stream().filter(StreamDemo::isEven).map(StreamDemo::doubleIt).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(isOdd).map(StreamDemo::doubleIt).collect(Collectors.toList());
        if (isOdd.test(5)) {
            System.err.println("5 is odd");
        }
        //System.err.println(evenNumbers);
        /*System.err.println(isPrime(1));
        System.err.println(isPrime(2));
        System.err.println(isPrime(3));
        System.err.println(isPrime(4));
        System.err.println(isPrime(4656544));*/
    }

    private static Optional<Integer> getFirstDivsibleByFive(List<Integer> numbers) {
        return numbers.stream().filter(isDivisibleByFive).findFirst();
    }

    private static Optional<Integer> getFirstDivsibleByTen(List<Integer> numbers) {
        return numbers.stream().filter(isDivisibleByTen.negate()).findFirst();
    }

    private static int doubleIt(Integer n) {
        return n * 2;
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    private static void sleepAndPrint(Integer number) {

        System.err.println(number);
    }

    private static boolean isPrime(int number) {
        /*for (int index = 2; index < number - 1; index++) {
            if (number % index == 0) {
                return false;
            }
        }
        return number > 1;*/
        return number > 1 && IntStream.range(2, number - 1).noneMatch(
                index -> number % index == 0);
    }
}

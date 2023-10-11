package Functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProbs {

    // doubling
    public List<Integer> doubling(List<Integer> nums) {
        // solution one
        // nums.replaceAll(num -> num * 2);
        // return nums;

        // solution two
        return nums.stream() // convert list into stream of integers
                .map(num -> num * 2) // map operation to double each element
                .collect(Collectors.toList()); // collect modified elements into new list
    }


    // square
    public List<Integer> square(List<Integer> nums) {
        return nums.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }


    // addStar
    public List<String> addStar(List<String> strings) {

        strings.replaceAll(str -> str + "*");
        return strings;


    }


    // copies3
    public List<String> copies3(List<String> strings) {
        return strings.stream()
                .map(str -> str + str + str)
                .collect(Collectors.toList());
    }


    // moreY
    public List<String> moreY(List<String> strings) {
        return strings.stream()
                .map(str -> "y" + str + "y")
                .collect(Collectors.toList());
    }



    // math1
    public List<Integer> math1(List<Integer> nums) {

        return nums.stream()
                .map(num -> (num + 1) * 10)
                .collect(Collectors.toList());


    }


    // rightDigit
    public List<Integer> rightDigit(List<Integer> nums) {

        return nums.stream()
                .map(num -> num % 10)
                .collect(Collectors.toList());
    }



    // lower
    public List<String> lower(List<String> strings) {

        return strings.stream()
                .map(word -> word.toLowerCase())
                .collect(Collectors.toList());


    }



    // noX
    public List<String> noX(List<String> strings) {

        return strings.stream()
                .map(str -> str.replaceAll("x", ""))
                .collect(Collectors.toList());

    }


    // noNeg
    public List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(num -> num < 0);
        return nums;
    }


    // no9
    public List<Integer> no9(List<Integer> nums) {

        nums.removeIf(num -> num % 10 == 9);
        return nums;

    }


    // noTeen
    public List<Integer> noTeen(List<Integer> nums) {

        nums.removeIf(num -> num >= 13 && num <= 19);
        return nums;


    }



    // noZ
    public List<String> noZ(List<String> strings) {

        strings.removeIf(str -> str.contains("z"));

        return strings;

    }

    // noLong
    public List<String> noLong(List<String> strings) {

        strings.removeIf(str -> str.length() >= 4);
        return strings;


    }


    // no34
    public List<String> no34(List<String> strings) {


        strings.removeIf(str -> str.length() == 3 || str.length() == 4);
        return strings;

    }


    // noYY
    public List<String> noYY(List<String> strings) {

        return strings.stream()
                .map(str -> str + "y")
                .filter(str -> !str.contains("yy"))
                .collect(Collectors.toList());


    }

    // two2
    public List<Integer> two2(List<Integer> nums) {

        return nums.stream()
                .map(num -> num * 2)
                .filter(num -> num % 10 != 2)
                .collect(Collectors.toList());

    }








}

package com.cloud3.web.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: HeYongLiu
 * @create: 08-20-2019
 * @description: 泛型测试
 **/
public class TestDifferenceBetweenObjectAndT {

    public static void printList1(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    public static <T> void printList2(List<T> list) {
        for (T elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    public static void printList3(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3);
        List<String> test2 = Arrays.asList("one", "two", "three");
        List<Object> test3 = Arrays.asList(1, "two", 1.23);
        List<Fruit> test4 = Arrays.asList(new Apple(), new Banana());
        List<Object> test5 = Arrays.asList(new Apple(), new Banana());

        //printList1(test4)这句会编译报错，因为参数不能转化成功，List指定为Object，则传进去必须为Object
        //
        //printList1(test4);
        printList1(test5);
        printList1(test3);
        printList1(test3);
        printList2(test1);
        printList2(test2);
        printList2(test3);
        printList3(test1);
        printList3(test2);
        printList3(test3);
    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Banana extends Fruit {
    }

}

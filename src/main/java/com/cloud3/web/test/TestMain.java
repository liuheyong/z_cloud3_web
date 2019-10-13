package com.cloud3.web.test;

import java.util.Optional;

/**
 * @author: HeYongLiu
 * @create: 07-17-2019
 * @description:
 **/
public class TestMain {

    public static void main(String[] args) throws Exception {

        //Lock lock = new ReentrantLock();
        //static int[] value = new int[]{1, 2};
        //static AtomicIntegerArray ai = new AtomicIntegerArray(value);
        //Lock lock = new ReentrantLock();
        //ai.getAndSet(0, 3);
        //System.out.println(ai.get(0));
        //List<String> list1 = new ArrayList();
        //List<String> list2 = null;
        //    Optional.ofNullable(list1).orElseThrow(()->new RuntimeException("error1"));
        //    Optional.ofNullable(list2).orElseThrow(()->new RuntimeException("error2"));

        //private void dontStop() {
        //    while (true) {
        //    }
        //}
        //
        //public void stackLeakByThread() {
        //    while (true) {
        //        Thread thread = new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                dontStop();
        //            }
        //        });
        //        thread.start();
        //    }
        //}
        //
        //public static void main(String[] args) {
        //    Method method = null;
        //    if (Object.class.equals(TestMain.class)) {
        //        try {
        //            System.out.println("1");
        //        } catch (Throwable t) {
        //        }
        //    }

        /*TestMain test = new TestMain();
        test.stackLeakByThread();*/

        /*ArrayList<TestMain> arrayList = new ArrayList<TestMain>();
        while (true) {
            arrayList.add(new TestMain());
        }*/

        /* Student student = new Student("liu", 99);
        System.out.println(student);*/

       /*String str2 = new String("str") + new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2.equals(str1));
        System.out.println(str2 == str1);*/
    }
}



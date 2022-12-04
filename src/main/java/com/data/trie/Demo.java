package com.data.trie;

/**
 * @Author: drainli
 **/
public class Demo {

    public static void main(String[] args) {
        Test1 test1 = new Test1() ;
        test1.setTest2(new Test2());
        test1.getTest2().setValue(5);
        Test3 test3 = new Test3() ;
        test3.setTest1(test1);

        Test2 test2 = test1.getTest2();
        test2.setValue(10);

        System.out.println(test1);
    }

    static class Test1{
        Test2 test2 ;

        public Test2 getTest2() {
            return test2;
        }

        public void setTest2(Test2 test2) {
            this.test2 = test2;
        }
    }

    static class Test2{
        private Integer value ;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
    static class Test3{
        Test1 test1 ;

        public Test1 getTest1() {
            return test1;
        }

        public void setTest1(Test1 test1) {
            this.test1 = test1;
        }
    }

}

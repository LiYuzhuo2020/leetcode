package com.draini.multiThread;

/**
 * @Author: Drainli
 **/
public class PrintABInTurn {

    private  int n ;
    private volatile int num ;

    public PrintABInTurn(int n){
        this.n = n ;;
        this.num = 1 ;
    }

    class ThreadA implements Runnable {
        private Object preLock ;
        private Object nextLock ;


        public ThreadA(Object preLock,Object nextLock) {
            this.preLock = preLock ;
            this.nextLock = nextLock ;
        }

        @Override
        public void run() {
            synchronized (preLock){
                synchronized (nextLock){
                    while(num <= n){
                        if(num % 3 != 1){
                            try {
                                preLock.wait(); // wait and release the lock
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                        System.out.print("A");
                        num++ ;
                        nextLock.notifyAll();
                    }
                }
            }
        }
    }

    class ThreadB implements Runnable {

        private Object thirdLock ;
        private Object nextLock ;

        public ThreadB(Object nextLock,Object thirdLock) {
            this.nextLock = nextLock ;
            this.thirdLock = thirdLock ;
        }

        @Override
        public void run() {
            synchronized (nextLock){
                synchronized (thirdLock){
                    while(num <= n) {
                        if (num % 3 != 2)
                            try {
                                nextLock.wait(); // wait and release the lock
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        System.out.print("B");
                        num++ ;
                        thirdLock.notifyAll();
                    }
                }
            }
        }
    }

    class ThreadC implements Runnable {

        private Object thirdLock ;
        private Object preLock ;

        public ThreadC(Object thirdLock , Object preLock){
            this.thirdLock = thirdLock ;
            this.preLock = preLock ;
        }

        @Override
        public void run() {
            synchronized (thirdLock){
                synchronized (preLock){
                    while(num <= n){
                        if (num % 3 != 0) {
                            try {
                                thirdLock.wait(); // wait and release the lock
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.print("C");
                        num++ ;
                        preLock.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABInTurn printABInTurn = new PrintABInTurn(10) ;
        printABInTurn.beginPrint();
    }

    public void beginPrint() {

        Object preLock = new Object() ;
        Object nextLock = new Object() ;
        Object thirdLock = new Object() ;

        ThreadA a = new ThreadA(preLock,nextLock) ;
        ThreadB b = new ThreadB(nextLock,thirdLock) ;
        ThreadC c = new ThreadC(thirdLock,preLock) ;
        new Thread(a).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(b).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(c).start();
    }

}
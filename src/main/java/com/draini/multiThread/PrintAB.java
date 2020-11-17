package com.draini.multiThread;

/**
 *
 * 按顺序交替打印AB
 *
 * @Author: Drainli
 **/
public class PrintAB {

    public static void main(String[] args) throws Exception {
        Object A = new Object() ;
        Object B = new Object() ;
        Object C = new Object() ;

        Printer a = new Printer(A,B,"A") ;
        Printer b = new Printer(B,C,"B") ;
        Printer c = new Printer(C,A,"C") ;

        new Thread(a).start();
        Thread.sleep(50);
        new Thread(b).start();
        Thread.sleep(50);
        new Thread(c).start();

    }

}

class Printer implements Runnable {

    private Object pre ;
    private Object self ;
    private String name ;

    public Printer(Object pre,Object self , String name) {
        this.pre = pre ;
        this.self = self ;
        this.name = name ;
    }

    @Override
    public void run() {
        int count = 5 ;
        while (count > 0){
            synchronized (pre){
                synchronized (self){
                    System.out.print(name);
                    count -- ;
                    self.notify();
                }

                try {
                    pre.wait();
                }catch (InterruptedException e){

                }
            }

        }
        System.exit(0);
    }
}

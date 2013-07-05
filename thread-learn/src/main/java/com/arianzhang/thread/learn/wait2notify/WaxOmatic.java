/**
 * All rights reserved by DigitNexus Technology INC.
 */
package com.arianzhang.thread.learn.wait2notify;

import static com.arianzhang.thread.learn.wait2notify.WaxOmatic.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.testng.log4testng.Logger;

/**
 * Description:
 * 
 * @author Arian Zhang
 * @email hzhang@digitnexus.com
 * @Date 2013-7-5 下午3:52:42
 * @since v1.0.0
 */
public class WaxOmatic {

    final static Logger logger = Logger.getLogger(WaxOmatic.class);

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car(); 
        ExecutorService exec = Executors.newCachedThreadPool(); 
        exec.execute(new WaxOff(car)); 
        exec.execute(new WaxOn(car)); 
        TimeUnit.SECONDS.sleep(5); // Run for a while... 
        exec.shutdownNow(); // Interrupt all tasks 
    }
}

class Car {

    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForbuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                logger.info("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForbuffing();
            }
        } catch (InterruptedException e) {
            WaxOmatic.logger.warn("Exiting via interrupt", e);
        }
        logger.info("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing(); 
                logger.info("Wax Off! "); 
                TimeUnit.MILLISECONDS.sleep(200); 
                car.buffed();
            }
        }catch(InterruptedException e){
            logger.warn("Exiting via interrupt",e);
        }
        logger.info("Ending Wax Off task");
    }

}

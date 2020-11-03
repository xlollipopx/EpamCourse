package com.epam.task.nine.model;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    private static final int CASHBOXES_AMOUNT = 5;
    private final Semaphore semaphore = new Semaphore(CASHBOXES_AMOUNT, true);
    private final Queue<CashBox> cashBoxes;
    private static final ReentrantLock INSTANCE_LOCK = new ReentrantLock();
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static Restaurant instance;
    int customersAmount;

    private Restaurant() {
        cashBoxes = new LinkedList<CashBox>();
        customersAmount = 0;
        for(int i = 0; i < CASHBOXES_AMOUNT; i++){
            CashBox cashBox = new CashBox();
            cashBoxes.add(cashBox);
        }
    }

    public static Restaurant getInstance(){
        if (!instanceCreated.get()) {
            INSTANCE_LOCK.lock();
            try {
                if (!instanceCreated.get()) {
                    instance = new Restaurant();
                    instanceCreated.set(true);
                }
            }
            finally {
                INSTANCE_LOCK.unlock();
            }
        }
        return instance;
    }

    public CashBox getCashBox(long maxWaitMillis) throws ResourceException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                CashBox res = cashBoxes.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
        throw new ResourceException();
    }

    public void returnCashBox(CashBox resource) {
        cashBoxes.add(resource);
        semaphore.release();
    }

}

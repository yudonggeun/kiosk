package com.example.service;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

    public static AtomicInteger waitingNumber = new AtomicInteger(0);

    public static int waiting(){
        return waitingNumber.getAndIncrement();
    }

    public static void quit(){
        waitingNumber.decrementAndGet();
    }
}

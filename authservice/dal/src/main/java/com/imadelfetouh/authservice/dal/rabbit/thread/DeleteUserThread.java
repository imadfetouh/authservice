package com.imadelfetouh.authservice.dal.rabbit.thread;

import com.imadelfetouh.authservice.dal.rabbit.RabbitNonStopConsumer;
import com.imadelfetouh.authservice.dal.rabbit.consumer.DefaultConsumer;
import com.imadelfetouh.authservice.dal.rabbit.delivercallback.DeleteUserDeliverCallback;
import com.rabbitmq.client.DeliverCallback;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUserThread implements Runnable {

    private final static Logger logger = Logger.getLogger(DeleteUserThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public DeleteUserThread() {
        queue_name = "authservice_deleteuserconsumer";
        exchange_name = "deleteuserexchange";
        deliverCallback = new DeleteUserDeliverCallback();
    }

    @Override
    public void run() {
        StartConsuming startConsuming = new StartConsuming(queue_name, exchange_name, deliverCallback);
        startConsuming.start();
    }
}

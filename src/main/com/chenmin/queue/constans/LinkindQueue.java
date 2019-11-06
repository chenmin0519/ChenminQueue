package com.chenmin.queue.constans;

import com.chenmin.queue.config.QueueMessage;
import com.chenmin.queue.model.TestQuerueModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkindQueue {

    public static final BlockingQueue<QueueMessage> QUEUE = new LinkedBlockingQueue<>();


    /**
     * 模拟代替书库 鉴定是否消费队列
     */
    public static final BlockingQueue<TestQuerueModel> TESTQUEUE = new LinkedBlockingQueue<>();


    /**
     * 模拟代替书库 消费失败
     */
    public static final BlockingQueue<QueueMessage> ERROR_QUEUE = new LinkedBlockingQueue<>();
}

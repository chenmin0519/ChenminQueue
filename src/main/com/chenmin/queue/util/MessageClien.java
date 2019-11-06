package com.chenmin.queue.util;

import com.chenmin.queue.config.QueueMessage;
import com.chenmin.queue.constans.LinkindQueue;

public class MessageClien {
    public static void sendMessage(QueueMessage queueMessage){
        LinkindQueue.QUEUE.add(queueMessage);
    }


}

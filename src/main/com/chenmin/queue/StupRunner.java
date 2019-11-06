package com.chenmin.queue;

import com.alibaba.fastjson.JSONObject;
import com.chenmin.queue.config.QueueMessage;
import com.chenmin.queue.constans.LinkindQueue;
import com.chenmin.queue.model.TestQuerueModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class StupRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(StupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        //单独的线程 监测队列状态
        while (true){
            QueueMessage queueMessage = LinkindQueue.QUEUE.take();
            this.consumeQueue(queueMessage,0);
        }
    }

    /**
     * 仿照ack机制 失败重试 5次 进入失败队列
     * @param queueMessage
     * @param count
     */
    private void consumeQueue(QueueMessage queueMessage ,Integer count){
        try {
            TestQuerueModel testQuerueModel = JSONObject.parseObject(queueMessage.getMessage(), TestQuerueModel.class);
            //可以基于key来搞不同的操作 或者什么什么
            LinkindQueue.TESTQUEUE.add(testQuerueModel);
        }catch (Exception e){
            //可以对异常进行分析使其更只能对资源消耗更小
            //我这里没有弄 因为没有定义异常啥的直接重试5次 丢到失败消息里面
            if(count <= 5){
                consumeQueue(queueMessage,count++);
            }else{
                try {
                    LinkindQueue.ERROR_QUEUE.add(queueMessage);
                }catch (Exception ex){
                    log.info("error_queue:{}",JSONObject.toJSONString(queueMessage));
                }
            }
        }

    }
}

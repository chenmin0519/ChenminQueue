package com.chenmin.queue.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenmin.queue.QueueKeyEnum;
import com.chenmin.queue.config.QueueMessage;
import com.chenmin.queue.constans.LinkindQueue;
import com.chenmin.queue.model.TestQuerueModel;
import com.chenmin.queue.service.IndexService;
import com.chenmin.queue.util.MessageClien;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public String addqueue(String name,String age,Integer status) {
        TestQuerueModel testQuerueModel = new TestQuerueModel();
        testQuerueModel.setAge(age);
        testQuerueModel.setName(name);
        testQuerueModel.setStatus(status);
        QueueMessage queueMessage = new QueueMessage();
        queueMessage.setKey(QueueKeyEnum.BROADCAST.getKey());
        queueMessage.setMessage(JSONObject.toJSONString(testQuerueModel));
        MessageClien.sendMessage(queueMessage);
        return JSONObject.toJSONString(testQuerueModel);
    }
}

package com.code.kafka.springbootkafkaproducerexample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.kafka.springbootkafkaproducerexample.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateJson;

    private static final String TOPIC_JSON = "Kafka_Example_Json";
    
    private static final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/json/{name}")
    public String postJson(@PathVariable("name") final String name) {

    	kafkaTemplateJson.send(TOPIC_JSON, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
    
    @GetMapping("/publish/{name}")
    public String postString(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, name);

        return "Published successfully";
    }
}

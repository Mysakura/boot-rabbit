package com.example.demo.controller;

import com.example.demo.request.RabbitRequest;
import com.example.demo.response.RabbitResponse;
import com.example.demo.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: boot-rabbitmq
 * @description:
 * @author: 001977
 * @create: 2018-07-02 16:59
 */
@RestController
public class SimpleController {

    @Autowired
    private RabbitService rabbitService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/directPage")
    public ModelAndView directPage(){
        ModelAndView mv = new ModelAndView("direct");
        mv.addObject("title","DirectExchange");
        return mv;
    }

    @RequestMapping("/fanoutPage")
    public ModelAndView fanoutPage(){
        ModelAndView mv = new ModelAndView("fanout");
        mv.addObject("title","FanoutExchange");
        return mv;
    }

    @RequestMapping("/topicPage")
    public ModelAndView topicPage(){
        ModelAndView mv = new ModelAndView("topic");
        mv.addObject("title","TopicExchange");
        return mv;
    }

    @RequestMapping("/sendDirect")
    public RabbitResponse sendDirect(RabbitRequest rabbitRequest){
        rabbitService.sendDirect(rabbitRequest);
        return new RabbitResponse();
    }

    @RequestMapping("/sendFanout")
    public RabbitResponse sendFanout(RabbitRequest rabbitRequest){
        rabbitService.sendFanout(rabbitRequest);
        return new RabbitResponse();
    }

    @RequestMapping("/sendTopic")
    public RabbitResponse sendTopic(RabbitRequest rabbitRequest){
        rabbitService.sendTopic(rabbitRequest);
        return new RabbitResponse();
    }



}

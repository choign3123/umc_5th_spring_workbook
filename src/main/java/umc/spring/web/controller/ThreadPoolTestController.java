package umc.spring.web.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Date;

@RestController
@RequestMapping("/thread")
@Slf4j
public class ThreadPoolTestController {

    @GetMapping("/sleep")
    public String sleep(@RequestParam(value = "t") int time){

        try {
            log.info("요청 시작 - {}초", time);
            Thread.sleep(Duration.ofSeconds(time).toMillis());
            log.info("요청 처리 완료 - {}초", time);
        } catch (Exception e){
            e.printStackTrace();
        }

        Date date = new Date();
        return "[time stamp:"+ date.getTime() + "] sleep " + time ;
    }
}

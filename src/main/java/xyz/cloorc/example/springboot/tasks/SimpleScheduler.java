package xyz.cloorc.example.springboot.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhangh on 12/1/2016.
 *
 * @author : zhangh@dtdream.com
 * @version : 1.0.0
 * @since : 1.8
 */
@Slf4j
@Component
public class SimpleScheduler {

    @Scheduled(cron = "* * * * * ?")
    public void simple() {
        log.info("{} : hello world ...", new Date().getTime());
    }
}

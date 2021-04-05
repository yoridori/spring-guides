package com.example.springguides.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    
    private static final Logger log =
            LoggerFactory.getLogger(ScheduledTasks.class);
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    // 実行開始の5秒後に再実行
    //@Scheduled(fixedRate = 5000)
    public void reportBeforeExec5000millisec() {
        log.info("The time is now {} fixedRate", dateFormat.format(new Date()));
    }
    
    // 実行完了の5秒後に再実行
    //@Scheduled(fixedDelay = 5000)
    public void reportAfterExec5000millisec() {
        log.info("The time is now {} fixedDelay", dateFormat.format(new Date()));
    }
    
    // App起動1秒後から実行完了の10秒後に再実行
    //@Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public void reportInitAfter1000millisecDelay10000millisec() {
        log.info("The time is 10000 millisecond delay {}", dateFormat.format(new Date()));
    }
}

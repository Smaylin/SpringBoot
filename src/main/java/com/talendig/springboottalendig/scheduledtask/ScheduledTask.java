package com.talendig.springboottalendig.scheduledtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class ScheduledTask {

    //@Scheduled(fixedRate = 3000)
    //@Scheduled(cron = "19 23 * * * ?") //todos los dias a las 23.19
    public void miTarea() {
      log.info("Tarea programada. Ejecucion: " + LocalDateTime.now().toString());
    }

}

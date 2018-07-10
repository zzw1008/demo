package com.zzw.demo.schedule;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Description:
 * 定时任务
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/5 9:34
 */
@Component
@Log4j2
public class TimeSchedule {

	/**
	 * 固定频率执行
	 */
//	@Scheduled(fixedRate = 5000)
//	public void printTime(){
//		log.info (LocalTime.now ());
//	}

	/**
	 * 定时执行
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void schduleTime(){
		log.info (LocalTime.now ());
	}
}

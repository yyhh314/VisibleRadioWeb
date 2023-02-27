package com.example.radio.tools;

import com.example.radio.mp3.MP3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MP3Service mp3Service;

    /**
     * [수정할 것]
     * 1. 스케줄링 시간
     * 2. 배치파일 구동 후 mp3 얻은 것을 확인 후 updateMP3() 시행하도록 하기
     */
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul") // 스케줄에 등록된다.
    public void updateMP3Schedule(){
        // 배치파일 구동
        // mp3Service.startRecode();
        // logger.info("[BatchScheduler] mp3Service.startRecode() is invoked!");
        // (필수 결과물 : 라디오가 녹음된 mp3)

        // mp3를 얻었다면, 아래 실행
        mp3Service.updateMP3();
        logger.info("[BatchScheduler] mp3Service.updateMP3() is invoked!");
    }


    // mp3를 얻은 후
    // 구글 STT api 호출하여 STT 고고싱
    public void STT(){

    }
}

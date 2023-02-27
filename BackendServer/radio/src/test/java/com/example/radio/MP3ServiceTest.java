package com.example.radio;

import com.example.radio.mp3.MP3;
import com.example.radio.mp3.MP3Repository;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

@ActiveProfiles("local")
@SpringBootTest
class MP3ServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mp3-path}")
    String mp3Path;

    @Autowired
    MP3Repository mp3Repository;


    @Test
    public void updateMP3(){
        // 업뎃 방법? : JPA를 통해 update되도록 하자.

        // 1. mp3폴더의 전체 리스트를 가져온다.
        File dir = new File(System.getProperty("user.dir") + mp3Path);
        String[] fileNameList = dir.list();

        // 2. 해당 경로를 DB에 넣는다. by JPA
        //    JPA가 알아서 update처리할 것임. (공부: 영속성컨텍스트)
        for(String fileName : fileNameList){
            String path = mp3Path + "\\" + fileName;
            mp3Repository.save(new MP3(path));
        }

//        for(String fileName : fileNameList){
//            String path = mp3Path + "\\" + fileName;
//            MP3 saved = mp3Repository.findById(path).get();
//            org.assertj.core.api.Assertions.assertThat(saved.getUrl()).isEqualTo(path);
//            logger.info("[UpdateMP3 Test] at DB, {} stored!", path);
//        }
    }

}
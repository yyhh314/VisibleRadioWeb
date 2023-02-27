package com.example.radio.mp3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MP3Service {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${mp3-path}")
    String mp3Path;

    @Autowired
    MP3Repository mp3Repository;

    public void updateMP3(){

        // mp3폴더에서 파일 전체 로드
        File dir = new File(System.getProperty("user.dir") + mp3Path);
        String[] fileNameList = dir.list();

        // db에 업데이트
        for(String fileName : fileNameList){
            String path = mp3Path + "\\" + fileName;
            mp3Repository.save(new MP3(path));
        }

    }
}

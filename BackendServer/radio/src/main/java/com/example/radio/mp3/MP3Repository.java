package com.example.radio.mp3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MP3Repository extends JpaRepository<MP3, String> {

}

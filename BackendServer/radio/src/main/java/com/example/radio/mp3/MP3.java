package com.example.radio.mp3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class MP3 {
    @Id
    private String url;

    public MP3(String url) {
        this.url = url;
    }
}

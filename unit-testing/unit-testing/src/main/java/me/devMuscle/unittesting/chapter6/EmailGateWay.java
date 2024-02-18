package me.devMuscle.unittesting.chapter6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailGateWay {

    public void sendGreetingEmail(String email) {
        log.info(email);
    }
}

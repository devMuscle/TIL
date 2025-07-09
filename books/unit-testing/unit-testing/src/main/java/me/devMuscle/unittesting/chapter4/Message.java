package me.devMuscle.unittesting.chapter4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Message {

    public String header;
    public String body;
    public String footer;
}

package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailChangedEvent {

    private int userId;
    private String newEmail;
}

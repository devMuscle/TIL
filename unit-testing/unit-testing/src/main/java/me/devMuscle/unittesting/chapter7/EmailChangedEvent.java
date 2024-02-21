package me.devMuscle.unittesting.chapter7;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class EmailChangedEvent {

    private int userId;
    private String newEmail;
}

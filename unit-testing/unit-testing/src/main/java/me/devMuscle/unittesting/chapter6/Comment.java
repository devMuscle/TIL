package me.devMuscle.unittesting.chapter6;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
public class Comment {

    public String text;
    public String author;
    public LocalDate dateCreated;
}

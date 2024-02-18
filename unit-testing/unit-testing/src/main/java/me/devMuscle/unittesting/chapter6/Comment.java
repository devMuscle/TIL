package me.devMuscle.unittesting.chapter6;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Comment {

    public String text;
    public String author;
    public LocalDate dateCreated;
}

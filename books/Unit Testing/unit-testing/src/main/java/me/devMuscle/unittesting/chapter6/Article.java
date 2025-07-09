package me.devMuscle.unittesting.chapter6;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {

    private final List<Comment> comments = new ArrayList<>();

    public void addComment(String text, String author, LocalDate now) {
        comments.add(new Comment(text, author, now));
    }

    public Article shouldContainNumberOfComments(int numberOfComments) {
        if(numberOfComments == comments.size()) {
            return this;
        }

        throw new AssertionError("예상했던 갯수와 다릅니다.");
    }

    public void withComment(String text, String author, LocalDate now) {
        Comment expectedComment = new Comment(text, author, now);

        boolean exist = comments.stream().anyMatch(comment -> comment.text.equals(text)
                            && comment.author.equals(author) && comment.dateCreated == now);

        if(exist == false) {
            throw  new AssertionError("해당 Comment는 존재하지 않습니다.");
        }
    }
}

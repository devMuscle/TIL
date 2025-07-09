package me.devMuscle.unittesting.chapter6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    public void adding_a_comment_to_an_article() {
        Article sut = new Article();
        String text = "Comment text";
        String author = "John Doe";
        LocalDate now = LocalDate.of(2024, 2, 18);

        sut.addComment(text, author, now);

        //글의 상태를 검증
        assertEquals(1, sut.getComments().size());
        assertEquals(text, sut.getComments().get(0).text);
        assertEquals(author, sut.getComments().get(0).author);
        assertEquals(now, sut.getComments().get(0).dateCreated);
    }

    @Test
    public void adding_a_comment_to_an_article_verify_with_helper_method() {
        Article sut = new Article();
        String text = "Comment text";
        String author = "John Doe";
        LocalDate now = LocalDate.of(2024, 2, 18);

        sut.addComment(text, author, now);

        // 헬퍼 메서드로 글의 상태를 검증
        sut.shouldContainNumberOfComments(1).withComment(text, author, now);
    }

    @Test
    public void adding_a_comment_to_an_article_verify_with_assertj() {
        Article sut = new Article();
        Comment comment = new Comment("Comment text", "John Doe", LocalDate.of(2024,2,18));

        sut.addComment(comment.text, comment.author, comment.dateCreated);

        Assertions.assertThat(sut.getComments()).contains(comment);
    }
}
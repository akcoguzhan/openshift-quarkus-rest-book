package org.vermilionturtle.quarkus.microservices.book;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;

@Schema(description = "This is a book")
public class Book {
    @JsonbProperty("ISBN_13")
    @Schema(required = true)
    public String isbn13;
    @JsonbProperty("Title")
    @Schema(required = true)
    public String title;
    @JsonbProperty("Author")
    public String author;
    @JsonbProperty("Year_Of_Publication")
    public int yearOfPublication;
    @JsonbProperty("Genre")
    public String genre;
    @JsonbDateFormat("yyyy/MM/dd")
    @JsonbProperty("Creation_Date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

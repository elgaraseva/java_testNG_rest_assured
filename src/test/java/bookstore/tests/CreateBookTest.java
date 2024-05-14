package bookstore.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateBookTest {

    @Test
    public void testCreateBook() {

        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Book.Category.Adventures);

        TestClient client = new TestClient();

        client.create(book).assertThat().
                statusCode(201).
                body("id", Matchers.notNullValue()).
                body("title", Matchers.equalTo("The Adventures of Tom Sawyer")).
                body("description", Matchers.equalTo("The story about Tom Sawyer.")).
                body("author", Matchers.equalTo("Mark Twain")).
                body("price", Matchers.equalTo(350)).
                body("count", Matchers.equalTo(10)).
                log().all();
    }
}

package muyinatech.core;

/**
 * Representation class for JSON data, e.g. { "id": 1, "content": "Hello, stranger!"}
 * 
 * @author Tosin
 */
public class Saying {
    private final long id;
    private final String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
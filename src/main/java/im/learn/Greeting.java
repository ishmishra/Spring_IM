package im.learn;

/**
 * @author IM
 * @apiNote Create a resource representation class
 *
 * The service will handle GET requests for /greeting, optionally with a name parameter in the query string.
 * The GET request should return a 200 OK response with JSON in the body that represents a greeting.
 * It should look something like this:
 * {"id": 1,"content": "Hello, World!"}
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
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

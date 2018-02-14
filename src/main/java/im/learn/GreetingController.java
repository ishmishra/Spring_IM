package im.learn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author IM
 * Create a resource controller
 * <p>
 * In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are easily identified by the @RestController annotation, and the GreetingController
 * below handles GET requests for /greeting by returning a new instance of the Greeting class:
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    //The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        //@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method.
        // This query string parameter is explicitly marked as optional (required=true by default): if it is absent in
        // the request, the defaultValue of "World" is used.

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    //The above example does not specify GET vs. PUT, POST, and so forth, because @RequestMapping maps
    // all HTTP operations by default. Use @RequestMapping(method=GET) to narrow this mapping.

    //The implementation of the method body creates and returns a new Greeting object with id and content
    // attributes based on the next value from the counter, and formats the given name by using the greeting template.


}

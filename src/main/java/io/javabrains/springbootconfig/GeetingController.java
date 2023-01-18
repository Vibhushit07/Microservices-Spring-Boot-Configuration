package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GeetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${my.greetings: default value}")
    private String greetingsMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value("#{${dbValues}}")
//    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment env;

    @GetMapping("/greeting-controller")
    public String GreetingController() {
        return dbSettings.getConnection() + " " + dbSettings.getHost();
    }

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage + " " + greetingsMessage + " " + staticMessage + " " + listValues + " ";
//        + dbValues;
    }

    @GetMapping("/envdetails")
    public String envDetails() {
        return env.toString();
    }
}

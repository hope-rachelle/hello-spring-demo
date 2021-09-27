package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //@GetMapping("hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")//added to post response
    //@ResponseBody  //added to top
    public String helloQuery(@RequestParam String name, @RequestParam String language){
        String selectLanguageGreeting = HelloController.createMessage(name, language);
        return"<h3 style='color:goldenrod;'> "+selectLanguageGreeting+"</h3>";
    }
    @GetMapping("goodbye")//lives at /hello/goodbye
    //@ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    @GetMapping("{name}")//("hello/{name}")
    //@ResponseBody
    public String helloPath(@PathVariable String name){
        return "Hello, " + name;
    }

    @GetMapping("form")
    //@ResponseBody
    public String helloForm(){
        return "<html>"+"<body>"
                +"<form action='hello' method='post'>"//submit request hello
                +"<input type='text' name='name'>"
                + "<select name=language>"
                + "<option value='English'>English</option>"
                + "<option value='French'>French</option>"
                + "<option value='Spanish'>Spanish</option>"
                + "</select>"
                +"<input type='submit' value='Greet me!'>"
                +"</form>"+"</body>"+"</html>";
    }
    public static String createMessage(String name, String language){
        switch (language){
            case "French":
                return "Bonjour, "+name;
            case "Spanish":
                return "Hola, "+name;
            case "English":
            default:
                return "Hello, "+name;
        }
    }
}


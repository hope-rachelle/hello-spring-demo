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
    public String helloQuery(@RequestParam String name){
        return "Hello, " + name;
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
    /*@GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>"+"<body>"
                +"<form action='hello'>"
                +"<input type='text' name='name'>"
                +"<input type='submit' value='Greet me!'>"
                +"</form>"+"</body>"+"</html>";*/
    @GetMapping("form")
    //@ResponseBody
    public String helloForm(){
        return "<html>"+"<body>"
                +"<form action='hello' method='post'>"//added method
                +"<input type='text' name='name'>"
                +"<input type='submit' value='Greet me!'>"
                +"</form>"+"</body>"+"</html>";
    }
}


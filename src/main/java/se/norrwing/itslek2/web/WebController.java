package se.norrwing.itslek2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebController {


    @GetMapping
    public String welcome(){
        return "Welcome to my site!";
    }
}

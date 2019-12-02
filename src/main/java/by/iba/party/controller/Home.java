package by.iba.party.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Home {

    @GetMapping (value = "")
    public String get(){
        return "hello world";
    }
}

package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path= arrayOf("templates"))
class HelloWorldController {

    @GetMapping(path=arrayOf("hello"))
    fun sayHello(model: Model): String {
        model.addAttribute("hello","Hello, World");
        return "hello";
    }


    @GetMapping(path=arrayOf("hello/{name}"))
    fun sayHello(@PathVariable name: String, model: Model): String {
        model.addAttribute("hello","Hello, $name");
        return "hello";
    }

}

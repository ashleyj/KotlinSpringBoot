package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldRestController {

    @GetMapping(path = arrayOf("/hello"))
    fun sayHello(): Greeting {
        return Greeting("Hello");
    }

    @GetMapping(path = arrayOf("/hello/{name}"))
    fun sayHello(@PathVariable name: String): Greeting {
        return Greeting("Hello, $name" );
    }
}

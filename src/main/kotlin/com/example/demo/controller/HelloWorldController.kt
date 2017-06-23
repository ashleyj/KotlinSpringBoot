package com.example.demo.controller

import com.example.demo.Greeting
import com.example.demo.repository.GreetingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path= arrayOf("templates"))
open class HelloWorldController {


    @Autowired
    private val greetingRepository: GreetingRepository? = null


    @GetMapping(path=arrayOf("/hello"))
    fun sayHello(model: Model): String {
        model.addAttribute("greeting",Greeting(1,"World"));
        return "hello";
    }

    @RequestMapping(path=arrayOf("/hello/{id}"))
    fun sayHello(@PathVariable("id") greetingId: Int, model: Model): String {
        val greeting = greetingRepository?.findOne(greetingId)
        model.addAttribute("greeting", greeting)
        return "hello";
    }

}

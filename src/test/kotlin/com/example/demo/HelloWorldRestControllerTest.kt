package com.example.demo

import com.example.demo.rest.HelloWorldRestController
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(HelloWorldRestController::class)
open class HelloWorldRestControllerTest {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper : ObjectMapper? = null

    @Test
    fun testHelloWorldNoArgs() {
        val greeting = Greeting("Hello")
        val greetingAsString = objectMapper?.writeValueAsString(greeting)
        mockMvc!!.perform(get("/rest/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(greetingAsString))
    }


    @Test
    fun testHelloWorldWithArg() {
        val greeting = Greeting("Hello, Test")
        val greetingAsString = objectMapper?.writeValueAsString(greeting)
        mockMvc!!.perform(get("/rest/hello/Test"))
                .andExpect(status().isOk())
                .andExpect(content().string(greetingAsString))
    }


}
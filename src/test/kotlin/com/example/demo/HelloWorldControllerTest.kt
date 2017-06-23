package com.example.demo

import com.example.demo.controller.HelloWorldController
import com.example.demo.repository.GreetingRepository
import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(HelloWorldController::class)
class HelloWorldControllerTest {

    @Autowired
    private var mockMvc: MockMvc? = null

    @MockBean
    private val greetingRepository: GreetingRepository? = null

    @Test
    fun testHelloWorldTemplateWithRepoIdLookup() {
        val greeting = Greeting(1,"Test")
        BDDMockito.given(greetingRepository?.findOne(1)).willReturn(greeting)
        mockMvc!!.perform(MockMvcRequestBuilders.get("/templates/hello/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Hello, Test")))
    }

    @Test
    fun testHelloWorldTemplateWithNoArgs() {
        val greeting = Greeting(1,"World")
        BDDMockito.given(greetingRepository?.findOne(1)).willReturn(greeting)
        mockMvc!!.perform(MockMvcRequestBuilders.get("/templates/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Hello, World")))
    }
}

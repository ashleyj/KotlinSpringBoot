package com.example.demo;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinSpringApplication {

    companion object {
        @JvmStatic fun main (args: Array<String>) {
            SpringApplication.run(KotlinSpringApplication::class.java, *args);
        }
    }
}




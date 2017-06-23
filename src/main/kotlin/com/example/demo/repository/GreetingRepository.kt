package com.example.demo.repository

import com.example.demo.Greeting
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface GreetingRepository : CrudRepository<Greeting, Int> {


}

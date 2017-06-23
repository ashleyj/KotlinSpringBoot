package com.example.demo

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Greeting (@Id var id: Int = 0 , var greetingString: String = "") {

    constructor(greetingString: String) : this(0, greetingString)
    constructor() : this(0, "")
}

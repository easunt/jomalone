package com.perfume.jomalone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class JomaloneApplication

fun main(args: Array<String>) {
    runApplication<JomaloneApplication>(*args)
}

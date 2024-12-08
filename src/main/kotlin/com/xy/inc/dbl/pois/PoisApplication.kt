package com.xy.inc.dbl.pois

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(exclude = [
	DataSourceAutoConfiguration::class
])
@EnableMongoRepositories(basePackages = ["com.xy.inc.dbl.pois.poi"])
class PoisApplication

fun main(args: Array<String>) {
	runApplication<PoisApplication>(*args)
}

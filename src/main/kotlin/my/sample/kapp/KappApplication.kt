package my.sample.kapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KappApplication

fun main(args: Array<String>) {
	runApplication<KappApplication>(*args)
}

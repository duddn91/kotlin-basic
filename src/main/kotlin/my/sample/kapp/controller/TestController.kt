package my.sample.kapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun restorePrivateKey(): String {
        return "Hello, API"
    }

    @GetMapping("/test/request-param")
    fun restorePrivateKey(@RequestParam param1: String, param2: String): String {
        return "Hello, API - (param1: ${param1}, param2: ${param2})"
    }
}
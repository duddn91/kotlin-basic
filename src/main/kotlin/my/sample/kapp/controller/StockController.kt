package my.sample.kapp.controller

import my.sample.kapp.model.Stock
import my.sample.kapp.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController(
    private val stockService: StockService
)
{
    @GetMapping("/stocks")
    fun listStocks(): List<Stock> {
        return stockService.getStocks()
    }

}
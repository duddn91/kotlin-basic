package my.sample.kapp.service

import my.sample.kapp.model.Stock
import my.sample.kapp.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService(
    private val stockRepository: StockRepository
)
{
    fun getStocks() : List<Stock> {
        return stockRepository.findAllAsModelBy();
    }
}
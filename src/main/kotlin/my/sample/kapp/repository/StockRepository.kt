package my.sample.kapp.repository

import my.sample.kapp.entity.StockEntity
import my.sample.kapp.entity.toModel
import my.sample.kapp.model.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository : JpaRepository<StockEntity, String> {

    fun findAllAsModelBy() : List<Stock> {
        return this.findAll().map { it.toModel() }
    }
}
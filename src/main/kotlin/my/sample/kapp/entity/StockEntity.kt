package my.sample.kapp.entity

import my.sample.kapp.model.Stock
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "stocks")
class StockEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String,
    val type: String,
    val name: String,
    val code: String,
    val ticker: String,
    val updatedDate: LocalDateTime,
    val createdDate: LocalDateTime,
)

fun StockEntity.toModel() : Stock {
    return Stock(
        id = this.id,
        type = this.type,
        name = this.name,
        code = this.code,
        ticker = this.ticker,
    )
}
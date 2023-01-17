package my.sample.kapp.service

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import my.sample.kapp.model.Stock
import my.sample.kapp.repository.StockRepository
import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class StockServiceTest {
    @InjectMockKs
    private lateinit var underTest: StockService

    @MockK
    private lateinit var stockRepository: StockRepository

    @Test
    fun listStocks() {
        // given
        val stocks = generateSequence {
            randomStock()
        }
            .distinct()
            .take(randomSmallPlural())
            .toList()
        every {
            stockRepository.findAllAsModelBy()
        } returns stocks

        // when
        val actual = underTest.getStocks()

        // then
        assertThat(actual).isEqualTo(stocks)
        verify(exactly = 1) {
            stockRepository.findAllAsModelBy()
        }
        confirmVerified(stockRepository)
    }

}

fun randomStock() = Stock(
    id = randomShortAlphanumeric(),
    type = randomShortAlphanumeric(),
    name = randomShortAlphanumeric(),
    code = randomShortAlphanumeric(),
    ticker = randomShortAlphanumeric(),
)

fun randomSmallPlural(): Int = RandomUtils.nextInt(2, 10)

fun randomShortAlphanumeric(): String = RandomStringUtils.randomAlphanumeric(randomSmallPlural())

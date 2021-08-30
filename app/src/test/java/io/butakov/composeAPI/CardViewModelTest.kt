package io.butakov.composeAPI

import io.butakov.composeAPI.viewmodel.CardViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CardViewModelTest {

    private val dataSize = 6

    lateinit var viewModel: CardViewModel
    lateinit var testNetworkService: TestNetworkService


    @Before
    fun setUp(){
        viewModel = CardViewModel()
        testNetworkService = TestNetworkService()
        viewModel.initViewModel(TestRepo(testNetworkService))
    }

    @Test
    fun checkResponseSize(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards.size, dataSize)
        }
    }

    @Test
    fun checkType_card0(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[0].card_type, "text")
        }
    }
    @Test
    fun checkType_card1(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[1].card_type, "title_description")
        }
    }
    @Test
    fun checkType_card2(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[2].card_type, "image_title_description")
        }
    }
    @Test
    fun checkValue_card0(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[0].card.value, "Hello, Welcome to App!")
        }
    }
    @Test
    fun checkValue_card1(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[1].card.title.value, "Check out our App every week for exciting offers.")
        }
    }
    @Test
    fun checkValue_card2(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[2].card.title.value, "Movie ticket to Dark Phoenix!")
        }
    }
    @Test
    fun checkTextColor_card0(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[0].card.attributes.text_color, "#262626")
        }
    }
    @Test
    fun checkTextColor_card1(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[1].card.title.attributes.text_color, "#262626")
        }
    }
    @Test
    fun checkTextColor_card2(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[2].card.title.attributes.text_color, "#FFFFFF")
        }
    }
    @Test
    fun checkFontSize_card0(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[0].card.attributes.font.size, 30)
        }
    }
    @Test
    fun checkFontSize_card1(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[1].card.title.attributes.font.size, 24)
        }
    }
    @Test
    fun checkFontSize_card2(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[2].card.title.attributes.font.size, 18)
        }
    }
}
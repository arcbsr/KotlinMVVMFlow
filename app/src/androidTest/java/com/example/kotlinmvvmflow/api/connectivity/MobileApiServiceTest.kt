package com.example.kotlinmvvmflow.api.connectivity

import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidTest
class MobileApiServiceTest {

    var mockWebServer:MockWebServer = MockWebServer()

    @Test
    fun testApiRequest( ) = runTest{
        val mockResponse = MockResponse()
        val responseJson = "{}"
        mockResponse.setBody(responseJson)
        mockWebServer.enqueue(mockResponse)
        mockWebServer.start()
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(MovieApiService::class.java)
        val response = apiService.getmovieList()
        Assert.assertEquals(true, response.Search.size==0)
        mockWebServer.shutdown()
    }
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
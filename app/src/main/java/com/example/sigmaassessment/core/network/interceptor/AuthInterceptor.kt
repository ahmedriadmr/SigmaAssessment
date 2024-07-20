package com.example.sigmaassessment.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = TokenProvider.getToken()

        if (token.isEmpty()) {
            // Handle missing or invalid token gracefully
            // (e.g., refresh token, return error response, etc.)
            return chain.proceed(chain.request())
        }

        val authenticatedRequest = chain.request().newBuilder().header("Authorization", "Bearer $token").build()

        return chain.proceed(authenticatedRequest)
    }
}


/** UPDATE TOKEN HERE */
object TokenProvider {
    fun getToken(): String = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiUFJFUEFJRCIsInVzZXJfbmFtZSI6IjYxMTExMTExMSIsInNjb3BlIjpbInJlYWQiLCIgd3JpdGUiXSwiZXhwIjoxNzIzOTMyMDUxLCJhdXRob3JpdGllcyI6WyJNT0JJTElTX0RBU0hCT0FSRCIsIk1PQklMSVNfUVVFUllfQkFMQU5DRSIsIk1PQklMSVNfUVVFUllfQVZBSUxBQkxFX09GRkVSUyIsIk1PQklMSVNfU0VORF9TTVMiLCJNT0JJTElTX1FVRVJZX1NVQlNDUklCRURfT0ZGRVJTIiwiTU9CSUxJU19DSEFOR0VfT0ZGRVJJTkciLCJNT0JJTElTX1NUT1JFX0xPQ0FUT1IiLCJNT0JJTElTX1JFQ0hBUkdFX0hJU1RPUlkiLCJNT0JJTElTX1FVRVJZX0ZSRUVfVU5JVCIsIk1PQklMSVNfVFJBTlNGRVJfSElTVE9SWSIsIk1PQklMSVNfTU9ESUZZX1BBU1NXT1JEIiwiTU9CSUxJU19CQUxBTkNFX1JFQ0hBUkdFIiwiTU9CSUxJU19HRVRfUFJPRklMRV9JTkZPIl0sImp0aSI6ImNjYjhlMDYyLTQzYzAtNDI4OS04YmQwLWQ5YTlmOTE1NWZjMiIsImNsaWVudF9pZCI6Im1vYmlsaXMtYXBwIn0.SjCdUaFPLg3J6-u5YEz7O8kzzTYRM5vgl8E1Bd3OkhejPycR3SNqzny7U7oCW5cTg74VpqgPB3oXzzM4jXItc-Yz74zsEUlJintyUAnJeqJ2x7vcBSzdbxciLfRWvmri_QhONglK-KQGhrSwK7-pHBnwzAYoeKueMmt5YzQDzd9wBGMNDhEdCK4-i4XYcgQmtdFHyXljMUXfpIstLkZPbRKeOFjcAJEJHLkzEiliYktwk3GSUamjhFwDKcvhrK5b5kWG2IJo1GEpeG49O2sojk-2BTq3hgHGQyxuHJ5pvObJH-zy3Tb7z4ffOMkIxQlJg--S8TPHz6NpQtuHytuH2Q"
}

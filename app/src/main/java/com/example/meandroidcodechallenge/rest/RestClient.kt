package com.example.meandroidcodechallenge.rest

import com.example.meandroidcodechallenge.BuildConfig
import com.example.meandroidcodechallenge.Common.constants.DomainConstants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object RestClient {
    private var mClient: OkHttpClient? = null
    private var mGSonConverter: GsonConverterFactory? = null

    fun create(): APIService {

        val retrofit = Retrofit.Builder()
            .baseUrl(DomainConstants.SERVER_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gSonConverter)
            .client(client)
            .build()

        return retrofit.create(APIService::class.java)

    }

    private val client: OkHttpClient
        @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
        get() {
            if (mClient == null) {
                val interceptor = HttpLoggingInterceptor()
                if (BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY
                else interceptor.level = HttpLoggingInterceptor.Level.NONE

                val httpBuilder = OkHttpClient.Builder()
                httpBuilder
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)  /// show all JSON in logCat
                mClient = httpBuilder.build()

            }
            return mClient!!
        }


    private val gSonConverter: GsonConverterFactory
        get() {
            if (mGSonConverter == null) {
                mGSonConverter = GsonConverterFactory
                    .create(
                        GsonBuilder()
                            .setLenient()
                            .disableHtmlEscaping()
                            .create()
                    )
            }
            return mGSonConverter!!
        }
}

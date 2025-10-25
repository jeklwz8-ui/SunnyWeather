package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    /**
     * 网络请求服务创建工具类
     * 用于创建Retrofit服务接口实例
     */
    private const val BASE_URL = "https://api.caiyunapp.com/"

    /**
     * Retrofit实例
     * 配置了基础URL和Gson数据转换器
     */
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    /**
     * 创建指定类型的服务接口实例
     * @param serviceClass 服务接口的Class对象
     * @return 指定类型的服务接口实例
     */
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    /**
     * 创建指定类型的服务接口实例（内联重载版本）
     * 使用内联函数和reified类型参数简化调用
     * @return 指定类型的服务接口实例
     */
    inline fun <reified T> create(): T = create(T::class.java)


}
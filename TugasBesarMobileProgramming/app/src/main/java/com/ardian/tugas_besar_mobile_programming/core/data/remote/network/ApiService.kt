package com.ardian.tugas_besar_mobile_programming.core.data.remote.network

import com.ardian.tugas_besar_mobile_programming.core.data.remote.response.ListResponse
import com.ardian.tugas_besar_mobile_programming.core.data.remote.response.MovieResponse
import com.ardian.tugas_besar_mobile_programming.core.data.remote.response.TvShowResponse
import com.ardian.tugas_besar_mobile_programming.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getMovies(): ListResponse<MovieResponse>

    @GET("tv/airing_today?api_key=$API_KEY")
    suspend fun getTvShow(): ListResponse<TvShowResponse>

}
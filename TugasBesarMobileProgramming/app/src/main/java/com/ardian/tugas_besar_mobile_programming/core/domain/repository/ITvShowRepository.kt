package com.ardian.tugas_besar_mobile_programming.core.domain.repository

import com.ardian.tugas_besar_mobile_programming.core.data.remote.Resource
import com.ardian.tugas_besar_mobile_programming.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface ITvShowRepository {
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}
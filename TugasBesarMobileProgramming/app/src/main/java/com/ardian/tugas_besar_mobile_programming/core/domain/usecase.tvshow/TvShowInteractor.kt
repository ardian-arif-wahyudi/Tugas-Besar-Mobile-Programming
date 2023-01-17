package com.ardian.tugas_besar_mobile_programming.core.domain.usecase.tvshow

import com.ardian.tugas_besar_mobile_programming.core.data.remote.Resource
import com.ardian.tugas_besar_mobile_programming.core.domain.model.Movie
import com.ardian.tugas_besar_mobile_programming.core.domain.model.TvShow
import com.ardian.tugas_besar_mobile_programming.core.domain.repository.ITvShowRepository
import kotlinx.coroutines.flow.Flow
import com.ardian.tugas_besar_mobile_programming.core.domain.usecase.tvshow.TvShowUseCase


class TvShowInteractor(private val repository: ITvShowRepository): TvShowUseCase {
    override fun getTvShow(): Flow<Resource<List<TvShow>>> = repository.getTvShow()
}
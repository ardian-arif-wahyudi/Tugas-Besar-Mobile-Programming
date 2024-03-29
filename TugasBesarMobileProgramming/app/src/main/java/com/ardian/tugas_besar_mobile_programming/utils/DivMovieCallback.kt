package com.ardian.tugas_besar_mobile_programming.utils

import androidx.recyclerview.widget.DiffUtil
import com.ardian.tugas_besar_mobile_programming.core.domain.model.Movie

class DivMovieCallback(private val oldItem: List<Movie>, private val newItem: List<Movie>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id
}
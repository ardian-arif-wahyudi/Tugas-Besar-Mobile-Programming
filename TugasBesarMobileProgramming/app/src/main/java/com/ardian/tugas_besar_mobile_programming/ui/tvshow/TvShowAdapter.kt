package com.ardian.tugas_besar_mobile_programming.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ardian.tugas_besar_mobile_programming.core.domain.model.TvShow
import com.ardian.tugas_besar_mobile_programming.databinding.ItemMovieOrTvshowBinding
import com.ardian.tugas_besar_mobile_programming.utils.BASE_URL_API_IMAGE
import com.ardian.tugas_besar_mobile_programming.utils.DivTvShowCallback
import com.ardian.tugas_besar_mobile_programming.utils.POSTER_SIZE_W185
import com.ardian.tugas_besar_mobile_programming.utils.loadImageTvShow

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private var listener: ((TvShow) -> Unit)? = null

    var tvshow = mutableListOf<TvShow>()
        set(value) {
            val callback = DivTvShowCallback(field, value)
            val result = DiffUtil.calculateDiff(callback)
            field.clear()
            field.addAll(value)
            result.dispatchUpdatesTo(this)
        }

    inner class ViewHolder(private val binding: ItemMovieOrTvshowBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow){
            binding.apply {
                tvShow.poster?.let {
                    poster.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W185$it")
                }
                tvTitle.text = tvShow.name
                tvDesc.text = if (tvShow.desc?.isNotBlank() as Boolean) tvShow.desc else "No Description"

                listener?.let { itemView.setOnClickListener { it(tvShow) } }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieOrTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvshow[position])
    }

    override fun getItemCount(): Int = tvshow.size

    fun onClick(listener: ((TvShow) -> Unit)?){
        this.listener = listener
    }
}
package com.indialone.bottomnavgraphapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.bottomnavgraphapp.R
import com.indialone.bottomnavgraphapp.api.news.ArticlesItem
import com.indialone.bottomnavgraphapp.databinding.NewsItemLayoutBinding

class NewsRecyclerAdapter(
    private val news : ArrayList<ArticlesItem>
) : RecyclerView.Adapter<NewsRecyclerAdapter.NewsRecyclerViewHolder>() {

    class NewsRecyclerViewHolder(itemView: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val tvTitle = itemView.tvNewsTitle
        val tvAuthor = itemView.tvNewsAuthor
        val tvPublishedAt = itemView.tvNewsPublishAt
        val ivNewsImage = itemView.ivNews

        fun bind(article: ArticlesItem) {
            tvTitle.text = article.title
            tvAuthor.text = article.author
            tvPublishedAt.text = article.publishedAt
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .centerCrop()
                .into(ivNewsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerViewHolder {
        val view = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewHolder, position: Int) {
        val news = news[position]
        holder.bind(news)
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                "news" to news
            )
            it.findNavController()
                .navigate(R.id.action_newsListFragment_to_newsDetailFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }


}
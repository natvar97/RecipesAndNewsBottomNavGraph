package com.indialone.bottomnavgraphapp.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.indialone.bottomnavgraphapp.R
import com.indialone.bottomnavgraphapp.api.news.ArticlesItem
import com.indialone.bottomnavgraphapp.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentNewsDetailBinding
    private lateinit var news: ArticlesItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            news = arguments?.getParcelable("news")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news.let {
            mBinding.tvTitle.text = news.title
            mBinding.tvAuthor.text = news.author
            mBinding.tvPublishedAt.text = news.publishedAt
            mBinding.tvUrl.text = news.url
            mBinding.tvDescription.text = news.description
            mBinding.tvContent.text = news.content
            Glide.with(mBinding.root.context)
                .load(news.urlToImage)
                .centerCrop()
                .into(mBinding.ivImageNews)

            mBinding.tvUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(news.url)
                it.context.startActivity(intent)
            }
        }

    }

}
package com.indialone.bottomnavgraphapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.bottomnavgraphapp.R
import com.indialone.bottomnavgraphapp.adapters.NewsRecyclerAdapter
import com.indialone.bottomnavgraphapp.api.news.ArticlesItem
import com.indialone.bottomnavgraphapp.databinding.FragmentNewsListBinding
import com.indialone.bottomnavgraphapp.viewmodel.NewsViewModel
import com.indialone.bottomnavgraphapp.viewmodel.ViewModelFactory

class NewsListFragment : Fragment() {

    private lateinit var mBinding: FragmentNewsListBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNewsListBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = ViewModelProvider(this, ViewModelFactory()).get(NewsViewModel::class.java)

        val news = ArrayList<ArticlesItem>()

        newsViewModel.getTopHeadlines().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        newsViewModel.getTechCrunchNews().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        newsViewModel.getAppleNews().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        newsViewModel.getTeslaNews().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        newsViewModel.getWsjComNews().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        mBinding.recyclerView.layoutManager = LinearLayoutManager(mBinding.root.context)
        mBinding.recyclerView.adapter =
            NewsRecyclerAdapter(news)

    }

}
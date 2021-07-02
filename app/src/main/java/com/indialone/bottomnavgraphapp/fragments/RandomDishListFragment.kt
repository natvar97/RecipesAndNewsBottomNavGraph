package com.indialone.bottomnavgraphapp.fragments

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.indialone.bottomnavgraphapp.R
import com.indialone.bottomnavgraphapp.api.dish.Recipes
import com.indialone.bottomnavgraphapp.databinding.FragmentRandomDishListBinding
import com.indialone.bottomnavgraphapp.viewmodel.DishesViewModel
import com.indialone.bottomnavgraphapp.viewmodel.ViewModelFactory

class RandomDishListFragment : Fragment(R.layout.fragment_random_dish_list) {

    private lateinit var mBinding: FragmentRandomDishListBinding
    private lateinit var dishesViewModel: DishesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentRandomDishListBinding.inflate(inflater, container, false)

        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishesViewModel =
            ViewModelProvider(this, ViewModelFactory()).get(DishesViewModel::class.java)

        //for initial value of random dish
        getRandomDishDetails()

        mBinding.srlRandomDish.setOnRefreshListener {
            //while i refresh this it will refresh it on more time
            dishesViewModel.fetchRandomDishes()
        }

    }

    fun getRandomDishDetails() {
        dishesViewModel.getRandomDishes().observe(viewLifecycleOwner) {
            if (mBinding.srlRandomDish.isRefreshing) {
                mBinding.srlRandomDish.isRefreshing = false
            }
            setUpRandomDishUI(it)
        }
    }

    fun setUpRandomDishUI(dishes: Recipes?) {
        val recipes = dishes!!.recipes?.get(0)!!

        Glide.with(mBinding.root.context)
            .load(recipes.image)
            .into(mBinding.ivDishImage)

        mBinding.tvTitle.text = recipes.title
        mBinding.tvCategory.text = "Other"
        var type = ""
        if (recipes.dishTypes!!.isNotEmpty()) {
            type = recipes.dishTypes.get(0)!!
            mBinding.tvCookingDirection.text = type
        }


        var ingredients = ""

        for (item in recipes.extendedIngredients!!) {
            if (ingredients.isEmpty()) {
                ingredients = item?.original!!
            } else {
                ingredients = ingredients + ",\n" + item?.original
            }
        }

        mBinding.tvIngredients.text = ingredients

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mBinding.tvCookingDirection.text = Html.fromHtml(
                recipes.instructions,
                Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            mBinding.tvCookingDirection.text = Html.fromHtml(recipes.instructions)
        }

        mBinding.tvCookingTime.text =
            "Time to prepare this dish is ${recipes.readyInMinutes.toString()} minutes"


    }


}
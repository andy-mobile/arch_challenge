package com.example.coding.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.coding.R
import com.example.coding.di.MainActivityScope
import com.example.coding.images.api.ImagesNavigator
import com.example.coding.images.presentation.common.model.DetailItemModel
import com.example.coding.images.presentation.detail.DetailFragment
import javax.inject.Inject

@MainActivityScope
class NavigationManagerImpl @Inject constructor() : ImagesNavigator {

    private fun add(fragment: Fragment, fragmentManager: FragmentManager) {

        fragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    override fun toDetailsScreen(param: DetailItemModel, fragmentManager: FragmentManager) {
        add(DetailFragment(param), fragmentManager)
    }
}
package com.example.coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coding.common.di.ComponentDependenciesProvider
import com.example.coding.common.di.HasComponentDependencies
import com.example.coding.di.MainComponent
import com.example.coding.di.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
package com.kalashnyk.denys.oollatest.presentation.activities.splash

import android.os.Handler
import com.kalashnyk.denys.oollatest.R
import com.kalashnyk.denys.oollatest.databinding.SplashBinding
import com.kalashnyk.denys.oollatest.di.component.ViewModelComponent
import com.kalashnyk.denys.oollatest.presentation.base.BaseActivity
import com.kalashnyk.denys.oollatest.utils.DELAY_3000

class SplashActivity : BaseActivity<SplashBinding>() {

    override fun injectDependency(component: ViewModelComponent) {
       component.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun setupViewLogic(binding: SplashBinding) {
        Handler().postDelayed({
            navigator.openMainScreen()
            finish()
        }, DELAY_3000)
    }
}

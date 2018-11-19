package net.stefano.fruitveg.di.component

import dagger.BindsInstance
import dagger.Component
import net.stefano.fruitveg.BaseApp


import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule
import com.stefano.network.ApiModule
import net.stefano.fruitveg.di.module.NiceFeatureModule


// I dont need the appmodule but is to show how to deal with multi com singleton instance creation and using  them . For stefano I could have the DAO interface and other interfaces here


@Singleton
@Component(modules = arrayOf(
        ApiModule::class,

        AndroidSupportInjectionModule::class,

        NiceFeatureModule::class)
)

interface ApplicationComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: BaseApp)

}
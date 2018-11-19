package net.stefano.fruitveg.di.component

import dagger.BindsInstance
import dagger.Component


import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule
import com.stefano.network.TestApiModule
import net.stefano.fruitveg.TestBaseApp
import net.stefano.fruitveg.di.module.NiceFeatureModule


// I dont need the appmodule but is to show how to deal with multi com singleton instance creation and using  them . For stefano I could have the DAO interface and other interfaces here


@Singleton
@Component(modules = arrayOf(
        TestApiModule::class,

        AndroidSupportInjectionModule::class,

        NiceFeatureModule::class)
)
interface TestApplicationComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TestBaseApp): Builder

        fun build(): TestApplicationComponent
    }

    fun inject(app: TestBaseApp)

}
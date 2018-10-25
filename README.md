## Dagger2Simple

 * Dagger2 - Android 使用步骤
 * 1.创建App继承自DaggerApplication实现抽象方法applicationInjector（） 并在Manifest.xml中配置
 * 2.创建全局AppModule 和空的BuildersModule
 * 3.创建全局AppComponet 配置类注解
 *                       @Singleton
                         @Component(modules = {
                             AppModule.class,
                             BuildersModule.class,
                             AndroidSupportInjectionModule.class
                         })
 * 如何在Activity中使用Dagger2
 * 1.MainActivity继承DaggetActivity
 * 2.在super.onCreate(savedInstanceState)之前加上 AndroidInjection.inject(this)(如果继承DaggetActivity也可以不加 因为在DaggetActivity已经添加了)
 * 3.创建MainModule
 * 4.创建MainComponet  配置类注解
 *                  @ActivityScope
                    @Subcomponent(modules = {MainModule.class})
     添加抽象方法泛型中添加准备注入的类 并添加注解
     @Subcomponent.Builder
     abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
 * 5.在BuildersModule类中添加
 *        @ActivityScope
          @ContributesAndroidInjector(modules = MainModule.class)
          abstract MainActivity bindMainActivityInjectorFactory();

 * 这样就可以使用在MainActivity 中就可以愉快的使用AppModule和MainModule中提供的数据了
 * 使用建议
 * 创建BaseActivity继承DaggerActivity
 * 如果已经存在BaseActivity 可以仿写 DaggerActivity
   在BaseActivity中调用
 * AndroidInjection.inject(this)
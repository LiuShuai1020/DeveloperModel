### 应用内部的开发者模式
###### 在我们日常开发过程中，遇到Bug经常需要打Log来跟踪定位问题，但是测试同学拿着手机找到你的时候，你更多的时候是一脸懵，只能将手机与电脑连接，然后run一下，打开Studio的控制台，然后过滤你需要的信息，才可能看到你需要的信息，但有时候由于部分机型打印的Log过多，你想要的信息可能刷一下就跳过去了，你想要看到的信息没有拿到，就算你拿到了，也有可能是服务端数据的问题，导致占用你很长的时间来跟踪，如果我们的log信息在应用内可以很直观的看到，是不是就省去了这些步骤呢？
------------
### Developer 开发者模式
###### 目前主要的核心功能是日志打印，以及一些周边逻辑，本期版本相对单一，后面有时间到话，会陆陆续续加入一些其他的功能，慢慢完善。
------------
### 使用
###### 首先需要初始化。
`DeveloperModelManager.init(this);`
### 开启开发者模式
###### 在“关于我们”页面的应用图标或者版本号上面或者任意控件增加点击事件并执行下面的方法：
`DeveloperModelManager.onClick();`
###### 你会发现点击了好几下都没有反应，是因为默认设置点击次数为10，才会进入开发者模式，如果你想改变点击次数，请参考：
`DeveloperModelManager.setClickNumber(5);`
###### 表示点击5次就可以进入开发者模式，如果你一次都不想点，想自己控制开发者模式的状态？也可以，你可以这样做：
`DeveloperModelManager.setDeveloperModelState(DeveloperStateModel.DEVELOPER_STATE_OPEN);`
###### 来进入开发者模式，退出开发者模式是这样做：
`DeveloperModelManager.setDeveloperState(DeveloperStateModel.DEVELOPER_STATE_CLOSE);`
###### 如果你不想要弹出 “您已进入开发者模式” 的话，可以这样:
 `DeveloperModelManager.setDeveloperState(DeveloperStateModel.DEVELOPER_STATE_CLOSE, false);`
### 数据注入
###### 下面进入正题，Log类型分为三种：
* 正常信息(normal 默认色)
* 警告信息(warn 黄色)
* 错误信息(error 红色)
###### 可调用方式：
`DeveloperModelManager.setLog(TAG, "Developer 正常信息");`
      `DeveloperModelManager.setNormalLog(TAG, "Developer 正常信息");`
 `DeveloperModelManager.setWarnLog(TAG, "Developer 警告信息");`
  `DeveloperModelManager.setErrorLog(TAG, "Developer 错误信息");`

### 展示数据
###### 在你的布局文件中加入下面的代码：
        <com.liushiyu.developer.DeveloperLogView
            android:id="@+id/mDeveloperLogView"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

###### 就可以了，效果图：![developer.png](https://upload-images.jianshu.io/upload_images/13761067-e2d320f505f851a8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 需要注意的是，数据的插入和删除都是异步处理的，数据查询目前是同步查来的，所以在for循环中打印信息的话，来到开发者模式的页面，有可能数据没有打印完成，这时候需要你手动查询。清除数据也是异步来处理的，如果数据量大的话，会有清除不干净的问题，所以在当前页面点击清除数据后，列表没有数据了，这时表示删除成功了。

###### 项目中使用的库
        implementation 'com.github.LiuShuai1020:Tooltip:1.0.1.1'
        implementation 'org.greenrobot:greendao:3.2.2'
        implementation 'net.zetetic:android-database-sqlcipher:3.5.4'

        implementation 'io.reactivex.rxjava2:rxjava:2.1.9'
        implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'
        implementation 'com.google.code.gson:gson:2.7'

        implementation 'com.android.support:recyclerview-v7:27.1.1'
# Android 组件化架构概要

组件化相信大家都很清楚他是什么，Android的一种开发架构，并且备受团队推崇，确实组件化在我看来对团队协作方面是帮助巨大的，随着应用开发的业务不断累积，我觉得我们更加应该关注架构的搭建，而不是一味的实现代码，这种重复工作以及无效时间就太多了，最近也阅读了很多关于架构的书籍，收获良多，所以今天的文章，就带领大家来领略一下组件化架构的美妙。

我在慕课网的Android新课核心知识点如下：

**Android X/音视频开发/社交匹配算法/即时通信/语音识别/App优化/安全加固**

[手把手完成商业级社交App开发进阶Android高级工程师](https://coding.imooc.com/class/390.html)

## 一.组件化概括
相对于Mvp来讲，组件化更多的是面向Module，而不是为了解耦而解耦，在我看来，组件化更多的是团队协作分工清晰，且划分明确，每个人都有自己负责的模块，避免无意义的穿插以及Git的代码冲突。

我们常见的架构分层，包括MVC,MVP,都是以如下的架构形式出现：

![图片1](https://uploader.shimo.im/f/ZOIALLjUGiQOw8pA.png)

主流的一个App和一个BaseModule，或者多个BaseModule，不管你是MVC,还是MVP都是如此，针对的是代码的解耦，而不是真正意义上的业务解耦，如果项目十分的庞大，你可能还会有BaseLibrary等存在，随着时间的推移，互相调用代码的揉合，你会发现框架会变得越来越糟糕，哪怕你使用MVP去解耦，也如下图中所示，纯属针对代码层的解耦，而不是真正意义上的架构解耦。

![图片2](https://uploader.shimo.im/f/FokPXMm0RTY3RP0N.png)

这个时候就要反思以及思考如何解决这个问题了，组件化就诞生了，组件化面对的是组件

**“多Module划分业务和基础功能”**

这就是组件化的核心思想了，我们一定要分清楚，组件，模块，以及库，是不一样的。

**组件** ：指单一职责的功能模块，如视频组件，支付组件，数据库组件。

**模块** ：指具体的业务逻辑模块，比如微信主页的四个页面，我们就可以定义为四个模块，由于模块的对象是业务，所以比组件的广度来讲要大许多，因为随着他的业务进展，他会包含越来越多的组件。

**库** ：单一职责的提供某个或者某些功能。

有了这些概念，就会诞生出很多的抽象名称，比如组件化，模块化，插件化等，追源溯本你会发现，其实他们的出发点，都是为了架构的不断演进而努力，只是趋向于目标不一致，所以文章开头我才说MVC，MVP之类的是针对代码的解耦，也就是让代码看得更加的清晰，一个View中实现一个Presenter后单一职责即可，但是组件化就不一样，他是针对业务模块进行区分，并且它也算是海纳百川，你具体代码怎么写，他也不负责，他维护好更大的框架即可。

其实说白了，就是将业务多Module的分层，比如大家常常用微信来举例子，微信有四个Tab，分别是：微信，通讯录，发现，我，那么我们是不是可以将其分成四个Module呢？

的确是的，如图：

![图片3](https://uploader.shimo.im/f/NAiLdiNsuhUY6oMl.png)

从图中可以看到，App作为一个UI的基础空壳，他将主页的逻辑实现即可，然后则是引入四个Module，他们都将依赖BaseModule，而BaseModule纯粹就是一个Library，主要封装一些工具类，管理类，和帮助类，我们的组件化历程则是从四个Module开始，他们既可以作为Module存在让App互相调用，又可以作为App单独存在调试，假设组内五个人开发，刚好可以让组长负责App和BaseModule，而其余四人分别负责微信，联系人，发现，我，即可，分工明确。

那么我们现在分工是明确了，如何在Android Studio中搭建组件化，则又是另外一回事儿了，既要考虑到App作为单独存在时的配置，也要考虑合并时主程序的运行。所以困难的一点在于如何初始化这个组件化项目的基础上，那么我们来开始搭建吧。

## 二.组件化项目
### 1.开发思路
我们既然要创建一个组件化的项目，那么首先就必须理清楚开发思路，首当其冲就是组件间的跳转，由于组件之间并没有直接的依赖关系，那么startActivity显然是无法使用了，这个时候我们可以使用阿里的Arouter来实现跳转：

[ARouter](https://github.com/alibaba/ARouter)

紧接着就是合并问题了，我们可以定义一个自定义的Gradle文件来控制是否Module单独编译。

其次就是注解了，说实话，注解的帮助还是很大的，至少我们少了很多的findViewById,我们可以使用Butterknife黄油刀来实现初始化，不过这个是选学，可以选择性添加，不添加也不碍事。

[Butterknife](https://github.com/JakeWharton/butterknife)

那么回到问题的根本，开发思路就是如此，先构建好每个Module的Gradle文件，然后再来统筹，不过这些都是给予一个完整的App Module来实现的，想单一的运行Module为Apk，我们至少还需要单独创建一个Activity作为启动项，以及一个清单文件作为配置项才行。

那么我们开始吧...
### 2.创建Module
首先我们创建五个Module，只要点击 File - New - New Module - Android Library 即可，以此类推，我们分别创建 ：

- ChatModule
- ContactModule
- FindModule
- MeModule
- BaseModule

分别对应的是微信，联系人，发现，我和基类。

![图片4](https://uploader.shimo.im/f/uu40GIrpieAlEhjg.png)

### 3.自定义Gradle
我们在Project的根目录创建一个config.gradle来统筹我们的依赖和版本信息

![图片5](https://uploader.shimo.im/f/56zHs1F9pe4Lfhn4.png)

里面比较关键的还是我们配置的 IS_BUILD_MODULE 变量，如果可以设置当为true的时候，Module可以单独运行，即Application，如果为false，那么我们就只能让Module作为Library来执行，至于其他的，都是一些普通的配置。

IS_BUILD_MODULE 这个开关还可以放在gradle.properties中，实际上我觉得放在gradle.properties会更好，这样对Git提交也不会在不严谨的时候造成代码冲突，不过既然团队已经在构建组件化，想必技术选型也其实早就配置好了，那么该用到哪些框架，也都提前配置好了，倒不会引起太大的骚乱。
### 4.主App配置
主App的配置主要集中于如何添加依赖，不管是组件Module还是BaseModule，都是一个过程

![图片6](https://uploader.shimo.im/f/p2AtPBflBXQF3eHG.png)

我们可以看到，BaseModule的添加是必然的，其次就是四个组件了，四个组件我们通过判断IS_BUILD_MODULE这个值来确定是否添加，下面是ARouter和Butterknife的添加，这两个比较特殊，所以才每个build.gradle都要添加，而普通的依赖项，我们只需要在BaseModule中添加即可。

而其他要关注的点就如下：

![图片7](https://uploader.shimo.im/f/YJGVOKUYctka1NMQ.png)

我们要添加黄油刀的插件，以及在defaultConfig中加上路由的配置，以及支持Java 8 ，这三个配置在每一个Module中都需要配置。

如果没有添加路由的配置，则无法跳转，如果没有添加Java 8 的支持，则会报错：

 **Exception from call site #1 bootstrap method**

当然，我们配置黄油刀，还需要在Project的build.gradle中配置插件

![图片8](https://uploader.shimo.im/f/wr0c1ZXlFvAJd09n.png)
### 5.组件的配置
组件的配置在于两方面，一方面是作为依赖，一方面作为一个独立的App

还是先来看下他的build.gradle

![图片9](https://uploader.shimo.im/f/yoXWAgEctfcVLTk8.png)

可以看到，这就是他的配置文件，其实很普通，路由和黄油刀的标配，以及添加BaseModule，之后哪怕是添加其他第三方框架也是在BaseModule中配置。当然，正如我们主Module的配置一样，组件Module也需要配置黄油刀的插件，以及在defaultConfig中加上路由的配置，以及支持Java 8 ，这是必然的，除此之外，他有两个特殊的地方：

![图片10](https://uploader.shimo.im/f/SDx6c0uGjfc4hsLy.png)

可以看到，我们会根据我们定义的变量来加载他到底是App还是Module,这样就能做到我们的随意切换了，如果是App的话，我们还需要给他配置一个包名ID，你可以给他设置相同的包名，我这里做了一些小区分而已。

还有一个地方则是清单文件的配置了
![图片11](https://uploader.shimo.im/f/Xfvb1n5u38grZMA1.png)
sourceSets可以帮助我们替换加载的文件，我们如果是App的话，重新配置了一个清单文件，因为他包含了App所需要的一切，如果是module，则不处理。来看下他们之间的区别：

首先是作为Module的清单文件：

![图片12](https://uploader.shimo.im/f/10AMBaL8qtIzdtcf.png)

可以看出，他只有必要的四大组件需要配置的时候则配置，不然的话就是空的了

而再看下作为App的清单文件：

![图片13](https://uploader.shimo.im/f/2eX1iSzU0LIxJjy0.png)

他可能比你想象的东西要多，他有一个Application根节点配置App的参数，还需要一个启动项Activity，不然也启动不起来。
### 6.BaseModule
基类的Module给我们更多的是封装的帮助，我们需要使用到的资源以及第三方框架都是可以放在这里的，老规矩，来看下他的build.gradle

![图片14](https://uploader.shimo.im/f/Xq55Soc8HscAv1XJ.png)

你理解了他，他就变得透明，就是一些常规的添加，并且黄油刀的插件，以及在defaultConfig中加上路由的配置，以及支持Java 8 必不可少。
### 7.Base类
作为高度统筹的项目架构，在Base方面实际上也是有一定的约束的，这里我以三个类为案例，分别是BaseApp，BaseActivity以及BaseFragment

**A.BaseApp**

![图片15](https://uploader.shimo.im/f/ovU3c7ItpA4aPrBl.png)

BaseApp方面主要还是做一些初始化的作用，不过你也可以在BaseModule中添加一个统一初始化的方法，BaseApp需要注意的点：

- 1.组件统一Context可以单例Application
- 2.组件Module需要继承自BaseApp

**B.BaseActivity**

![图片16](https://uploader.shimo.im/f/qvgxVo2rTWMulE9W.png)

BaseActivity中，我们初始化了黄油刀，以及封装了View，这样的好处就是不用写这么多onCreate了，使用起来也异常的方便

![图片17](https://uploader.shimo.im/f/rqjTCiXB7u0x1WYn.png)

**C.BaseFragment**

至于Fragment，和Activity的封装是一样的

![图片18](https://uploader.shimo.im/f/WBPzWaoNki0sXDlE.png)

唯一要注意的就是黄油刀的使用了，不过这个我们会在黄油刀中所讲到
### 8.ARouter
路由是帮助我们组件间跳转的，根据Github上添加好依赖之后，我们需要注意一下的几点

- 1.Path至少是两个层级 类似于 /Test/AppMain 程序会先去找Test再去找AppMain
- 2.Path第一层级不能重复，如果又出现一个 /Test/AppTest 则会出现找不到的异常

只要在Activity前一行添加path即可定义目标地址

![图片19](https://uploader.shimo.im/f/BIn69IDL9Z0Ar2dw.png)

这里我封装了一个帮助类提供跳转
![图片20](https://uploader.shimo.im/f/8cmtBC2eO5cReF3y.png)

地址也是自己定义的
![图片21](https://uploader.shimo.im/f/TjuJSy7xJY4X74S6.png)
### 9.Butterknife
黄油刀只是作为高效开发的组件，你也同样可以使用原生的findViewById，那么如果我们使用到黄油刀，需要注意什么呢？

- 1.Activity中绑定ButterKnife.bind(this);
- 2.Fragment以及Adapter中绑定ButterKnife.bind(this,mView);
- 3.Module中引用ID需要使用R2，如图

![图片22](https://uploader.shimo.im/f/5RMH5aMjGeMICCXF.png)

## 三.组件化的实现
这里我基于此架构写了一个仿微信UI的Demo内容，让大家更加清晰的认识组件化，那么我们先来看下预览：

![图片23](https://uploader.shimo.im/f/q4YQrir6JJMDZW8i.png)

首先我们App的空壳就是引用的四个组件，每个组件中都存在一个Fragment,App Module 只是做整合，每个组件Module单独负责一个业务，并且他们都是可以单独作为Apk存在的

![图片24](https://uploader.shimo.im/f/lejQkFXKiFsVp4jH.png)

我们可以全部都单独的实现运行

![图片25](https://uploader.shimo.im/f/sFEJfi3ZWHcDlo4Z.png)

而在模拟器上的表现如下：
![图片26](https://uploader.shimo.im/f/DiIwUpdNIvIki7YG.png)

## 四.组件化的问题
### 1.资源名冲突
如果资源名冲突，要么他改，要么你改，如果他改不了，那就你改，如果你也改不了，那么我们就通过Gradle去转换了，在Project的build.gradle中添加

![图片27](https://uploader.shimo.im/f/FmodFTFjaSACTt4f.png)

### 2.包名问题
部分第三方SDK需要填写包名，那么这个时候如果你填写主Module的包名的话，申请的Key实际上组件Module是用不了的，这里可以选择组件Module使用同一个包名，或者通过BaseModule的包名去申请，这样在BaseModule中再封装一层，提供给外部访问即可。
### 3.组件间的通讯
组件间通讯，可以选择EventBus，广播等方式，复杂交互的话，ARouter提供了一个Provider供我们数据交互。
### 4.组件化与MVP
看到不少开源使用了组件化还使用了MVP，我自己也尝试写了一个，只能感叹代码量增加很多，敲得手抖疼了，随即开始思考这个架构，组件化应对的是业务解耦，而MVP，更倾向于代码解耦，结合起来肯定代码更加清晰，更加完善，但是我无法提供一个这么庞大的项目练手，所以如果你的项目不是很庞大，可以择优选择，架构再好，也要看适不适合。

![图片28](https://uploader.shimo.im/f/98oZan7quqwWHmBB.png)

## 五.ARouter拦截

我们在一些特殊的场景的时候，需要拦截跳转，一般的例子比如跳转登录页的时候就可以拦截了，那么ARouter的拦截怎么处理的呢？我们来看下代码

![图片](https://uploader.shimo.im/f/Ha870VhqzwgJuddI.png)

我们只需要配置Interceptor的注解即可，其中优先级和name可以自己定义，而init是初始化的，并且只会走一次，主要还是在process中我们可以根据判断条件来控制是否拦截，这里我写了一些伪代码，如果想获取当前Activity对象的话，可以在Application中监听Activity生命周期获得

![图片](https://uploader.shimo.im/f/XKVSJnQHL5Yi5OVk.png)


## 六.结尾
组件化好处还是很多的，比如提升编译速度，毕竟都是单Module开发，高度统筹的情况下，还能基于BaseModule来减少重复代码，要是发现哪个Module还单独写工具类，拉出去枪毙。

看那文章毕竟是片面的，我还是由衷的希望读者在看完文章之后下载代码来运行一遍，看看代码的结构，那么理解这个demo也就八九不离十了，再结合自己的理解，就会看到更加广阔的天地了。

源代码地址：
[AndroidComponent](https://github.com/LiuGuiLinAndroid/AndroidComponent)

我在慕课网的Android新课核心知识点如下：

**Android X/音视频开发/社交匹配算法/即时通信/语音识别/App优化/安全加固**

[手把手完成商业级社交App开发进阶Android高级工程师](https://coding.imooc.com/class/390.html)

博客地址：

[Android 组件化架构概要](https://liuguilin.blog.csdn.net/article/details/102921040)

我的知识星球，欢迎你的加入

![图片29](https://uploader.shimo.im/f/x7rLEcLp5bQyimlE.jpg)

QQ交流群：417046685




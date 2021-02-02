# Arouter-Module


一个用于帮助 Android App 进行组件化改造的框架 —— 支持模块间的路由、通信、解耦


组件化开发就是将一个app分成多个模块，每个模块都是一个组件（Module），开发的过程中我们可以让这些组件相互依赖或者单独调试部分组件等，但是最终发布的时候是将这些组件合并统一成一个apk，这就是组件化开发。
插件化开发和组件化开发略有不用，插件化开发时将整个app拆分成很多模块，这些模块包括一个宿主和多个插件，每个模块都是一个apk（组件化的每个模块是个lib），最终打包的时候将宿主apk和插件apk分开或者联合打包。



Java项目中的配置方式
android {
    defaultConfig {
        ...
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName()]
            }
        }
    }
}

dependencies {
    // 替换成最新版本, 需要注意的是api
    // 要与compiler匹配使用，均使用最新版可以保证兼容
    compile 'com.alibaba:arouter-api:x.x.x'
    annotationProcessor 'com.alibaba:arouter-compiler:x.x.x'
}





Kotlin项目中的配置方式

// 可以参考 module-kotlin 模块中的写法
apply plugin: 'kotlin-kapt'

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}

dependencies {
    compile 'com.alibaba:arouter-api:x.x.x'
    kapt 'com.alibaba:arouter-compiler:x.x.x'
    ...
}



https://github.com/alibaba/ARouter
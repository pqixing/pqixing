pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
//include ':app'
include(":bydauto:app",":bydauto:hardware",":bydauto:media",)
//include(":lcode")
include(":utils:gnet",":utils:adb",":utils:floatwindow")
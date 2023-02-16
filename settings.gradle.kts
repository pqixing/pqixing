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
    }
}
//include ':app'
include(":byd:D+",":byd:music",":byd:compile")
//private val launchReg = Regex(".*ActivityTaskManager.*(START|activityResumedForAcBar).*")
//val str =
//    "2022-11-16 20:23:54.917  1219-2695  ActivityTaskManager     system_server                        I  START u0 {flg=0x10000000 cmp=com.byd.avc/.AutoVideoActivity (has extras)} from uid 1000"
//
//println("test match ${str.matches(launchReg)}")
include(":code",":service")

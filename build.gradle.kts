import org.jetbrains.intellij.tasks.RunPluginVerifierTask

val ideaVersion: String by project
val downloadIdeaSources: String by project
val publishUsername: String by project
val publishPassword: String by project
val publishChannels: String by project

repositories {
    mavenCentral()
}

plugins {
    id("org.jetbrains.intellij") version "0.7.2"
    id("org.sonarqube") version "3.1.1"
    jacoco
    java
}

apply {
    plugin("org.jetbrains.intellij")
}

dependencies {
    implementation("org.jsoup", "jsoup", "1.13.1")
}

intellij {
    version = ideaVersion
    downloadSources = downloadIdeaSources.toBoolean()
    updateSinceUntilBuild = false

    tasks.withType<RunPluginVerifierTask> {
        setIdeVersions(listOf("IU-2019.2.3", "IU-2020.3.2"))
    }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.isEnabled = false
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

sourceSets.main {
    java.srcDirs("src", "gen")
    resources.srcDir("resources")
}

sourceSets.test {
    java.srcDir("test")
    resources.srcDir("testdata")
}

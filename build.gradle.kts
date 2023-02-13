plugins {
    id("java")
    id("application")
    id("com.ryandens.javaagent-application") version "0.3.2"
}

group = "spp.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://pkg.sourceplus.plus/sourceplusplus/probe-jvm")
}

dependencies {
    //attaches Source++ probe to the application
    javaagent("plus.sourceplus.probe:probe-jvm:0.7.7.1")

    //used for the tail logs command
    implementation("org.apache.skywalking:apm-toolkit-logback-1.x:8.14.0")
    implementation("org.slf4j:slf4j-api:2.0.2")
    implementation("ch.qos.logback:logback-classic:1.4.1")

    //used for view traces command
    implementation("io.micronaut:micronaut-http-client:3.6.4")

    //used for endpoint indicators
    implementation("io.micronaut:micronaut-http-server-netty:3.6.4")
    annotationProcessor("io.micronaut:micronaut-inject-java:3.6.4")
}

application {
    mainClass.set("spp.demo.Main")
    applicationName = "demo-java"
}

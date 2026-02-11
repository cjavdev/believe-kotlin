plugins {
    id("believe.kotlin")
    application
}

dependencies {
    implementation(project(":believe-kotlin-core"))
    implementation(project(":believe-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :believe-kotlin-example:run` to run `Main`
    // Use `./gradlew :believe-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.believe.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}

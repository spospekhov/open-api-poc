plugins {
    id("apron-api.kotlin")
    application
}

dependencies {
    implementation(project(":apron-api-kotlin"))
}

application {
    mainClass = "com.apron_api.api.example.MainKt"
}

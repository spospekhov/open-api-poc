plugins {
    id("apron-api.kotlin")
    id("apron-api.publish")
}

dependencies {
    api(project(":apron-api-kotlin-client-okhttp"))
}

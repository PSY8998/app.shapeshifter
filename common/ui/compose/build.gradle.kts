plugins {
    `android-library`
    `kotlin-multiplatform`
    `compose-multiplatform`
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "app.shapeshifter.common.ui.compose"

    // tells android source set to include commonMain/resources
    sourceSets["main"].apply {
        res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material3)
                implementation(libs.circuit.foundation)
                implementation(compose.components.resources)

                api(libs.coil.compose)
                implementation(libs.circuit.overlay)
            }
        }
    }
}

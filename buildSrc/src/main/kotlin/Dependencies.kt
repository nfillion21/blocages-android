/**
 * To define dependencies
 */
object Dependencies {
    val coreAndroidX by lazy {"androidx.core:core-ktx:${Versions.coreAndroidX}"}
    val lifecycleRuntime by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleAndroidX}"}
    val activityCompose by lazy {"androidx.activity:activity-compose:${Versions.activityCompose}"}
    val composeUi by lazy {"androidx.compose.ui:ui:${Versions.compose}"}

    val material by lazy {"com.google.android.material:material:${Versions.material}"}

    val iconsExtended by lazy {"androidx.compose.material:material-icons-extended:${Versions.compose}"}
    val composeUiToolingPreview by lazy {"androidx.compose.ui:ui-tooling-preview:${Versions.compose}"}
    val composeMaterial3 by lazy {"androidx.compose.material3:material3:${Versions.composeMaterial3}"}

    val composeMaterial by lazy {"androidx.compose.material:material:${Versions.composeMaterial}"}
    val composeAnimation by lazy {"androidx.compose.animation:animation:${Versions.composeAnimation}"}

    val constraintLayout by lazy {"androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"}

    val lifecycleViewModelCompose by lazy {"androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleAndroidX}"}
    val lifecycleRuntimeCompose by lazy {"androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleAndroidX}"}

    val junit by lazy {"junit:junit:${Versions.junit}"}
    val composeUiTestJUnit4 by lazy {"androidx.compose.ui:ui-test-junit4:${Versions.compose}"}
    val composeUiTestTooling by lazy {"androidx.compose.ui:ui-tooling:${Versions.compose}"}
    val composeUiTestManifest by lazy {"androidx.compose.ui:ui-test-manifest:${Versions.compose}"}

    val androidTestJunit by lazy {"androidx.test.ext:junit:${Versions.androidTestJUnit}"}
    val androidTestEspresso by lazy {"androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"}

    // Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }

    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"}
    val navigationCompose by lazy {"androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"}

    // Paging compose
    val pagingCompose by lazy { "androidx.paging:paging-compose:${Versions.pagingCompose}" }

    val coilCompose by lazy {"io.coil-kt:coil-compose:${Versions.coil}"}

}

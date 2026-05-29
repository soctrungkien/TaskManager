package com.rk.bridge

import android.app.Activity
import android.app.Application
import androidx.annotation.Keep
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Keep
interface ProBridge {

    fun initApp(
        app: Application,
        launchPurchaseUiCallback: () -> Unit,
        onPurchaseCallback: () -> Unit
    )

    fun launchPurchase(activity: Activity)

    suspend fun getProVersionPrice(): String?

    // ✔ FIX nhẹ: MutableState -> State (giữ Compose nhưng tránh mutate từ ngoài)
    fun isPro(): State<Boolean>
    fun isPending(): State<Boolean>

    fun updatePurchaseStatus()

    @Composable
    fun DiskScreen()

    @Composable
    fun NetScreen()

    @Composable
    fun BatteryScreen()
}

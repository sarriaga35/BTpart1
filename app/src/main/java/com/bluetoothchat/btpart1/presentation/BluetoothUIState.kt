package com.bluetoothchat.btpart1.presentation

import com.bluetoothchat.btpart1.domain.chat.BluetoothDevice

data class BluetoothUIState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
    val isConnecting: Boolean = false,
    val isConnected: Boolean = false,
    val isScanning: Boolean = false,
    val errorMessage: String? = null

)

package com.bluetoothchat.btpart1.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.bluetoothchat.btpart1.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )

}
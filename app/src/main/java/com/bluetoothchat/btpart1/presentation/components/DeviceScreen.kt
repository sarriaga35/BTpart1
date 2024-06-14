package com.bluetoothchat.btpart1.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluetoothchat.btpart1.domain.chat.BluetoothDevice
import com.bluetoothchat.btpart1.presentation.BluetoothUIState

@Composable
fun DeviceScreen(
    state: BluetoothUIState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit
//    onStartServer: () -> Unit,
//    onDeviceClick: (BluetoothDevice) -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        BluetoothDeviceList(
            pairedDevices = state.pairedDevices,
            scannedDevices = state.scannedDevices,
            onClick = {},
            modifier = Modifier.fillMaxWidth().weight(1f))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
                ){
            Button(onClick = onStartScan) {
                Text("Start Scan")
            }
            Button(onClick = onStopScan) {
                Text("Stop Scan")
            }
        }
    }
}
@Composable
fun BluetoothDeviceList(
    pairedDevices: List<BluetoothDevice>,
    scannedDevices: List<BluetoothDevice>,
    onClick: (BluetoothDevice) -> Unit,
    modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ){
        item {
            Text(
                text = "Paired Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(pairedDevices) {device ->
            Text(text = device.name?: "Unknown Device",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp)
            )
        }
        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(scannedDevices) {device ->
            Text(text = device.name?:  "Unknown Device",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp)
            )
        }

    }


}
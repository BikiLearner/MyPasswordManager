package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun SettingScreen(){
    val settingOptions= listOf(
        "Profile","Permissions","Sync","Autofill","About","Help","Version"
    )
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            settingOptions.forEach {name->
                Text(text = name, fontSize = 20.sp)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                contentDescription = "Nothing")
            Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                contentDescription = "Nothing")
            Switch(
                modifier = Modifier.scale(0.67f,0.6f),
                checked = false,
                onCheckedChange = {
                    // Your logic when the switch is checked or unchecked
                }
            )
            Switch(
                modifier = Modifier.scale(0.67f,0.6f),
                checked = false,
                onCheckedChange = {
                    // Your logic when the switch is checked or unchecked
                }
            )
            Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                contentDescription = "Nothing")
            Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                contentDescription = "Nothing")
            Text(text ="1.3.2", fontSize = 20.sp)
        }
    }
}
@Preview
@Composable
private fun settingPreview(){
    SettingScreen()
}
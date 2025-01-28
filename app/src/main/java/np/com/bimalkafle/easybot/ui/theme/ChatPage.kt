package np.com.bimalkafle.easybot.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text
import androidx.compose.runtime.setValue


@Composable
fun ChatPage(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
    ){
        AppHeader()
    }
}

@Composable
fun MessageInput(){

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = message,
            onValueChange = {
            message = it
        }
        )

    }
}

@Composable
fun AppHeader(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ){
     Text(
         modifier = Modifier.padding(16.dp),
         text = "Easy Bot",
         color = Color.White,
         fontSize = 22.sp
     )
    }
}
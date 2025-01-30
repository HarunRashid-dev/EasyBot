package np.com.bimalkafle.easybot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import np.com.bimalkafle.easybot.ui.theme.Constants
import np.com.bimalkafle.easybot.ui.theme.MessageModel


class ChatViewModel : ViewModel(){

    val messageList by lazy{
        mutableStateListOf<MessageModel>()
    }

    val generativeModel : GenerativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash-001",
        apiKey = Constants.apiKey
        )

    fun sendMessage(question : String){
        viewModelScope.launch {
            val chat = generativeModel.startChat()

            messageList.add(MessageModel(question,"user"))

            val response = chat.sendMessage(question)
            messageList.add(MessageModel(response.text.toString(),"model"))
        }

    }
}
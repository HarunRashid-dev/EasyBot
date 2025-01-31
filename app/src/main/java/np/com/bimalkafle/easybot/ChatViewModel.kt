package np.com.bimalkafle.easybot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
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

            try{
                val chat = generativeModel.startChat(
                    history = messageList.map{
                        content(it.role){ text(it.message)}
                    }.toList()
                )

                messageList.add(MessageModel(question,"user"))
                messageList.add(MessageModel("Typing...","model"))

                val response = chat.sendMessage(question)
                messageList.removeLastOrNull()
                messageList.add(MessageModel(response.text.toString(),"model"))
            }catch (e : Exception){
                messageList.removeLastOrNull()
                messageList.add(MessageModel("Error : "+e.message.toString(),"model"))
            }

        }

    }
}
package np.com.bimalkafle.easybot

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import np.com.bimalkafle.easybot.ui.theme.Constants

class ChatViewModel : ViewModel(){

    val generativeModel : GenerativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash-001",
        apiKey = Constants.apiKey
        )

    fun sendMessage(question : String){
        viewModelScope.launch {
            val chat = generativeModel.startChat()
            val response = chat.sendMessage(question)
            Log.i("Response from Gemini",response.text.toString())
        }

    }
}
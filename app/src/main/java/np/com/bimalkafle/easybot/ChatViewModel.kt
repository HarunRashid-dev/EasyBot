package np.com.bimalkafle.easybot

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.ai.client.generativeai.GenerativeModel
import np.com.bimalkafle.easybot.ui.theme.Constants

class ChatViewModel : ViewModel(){

    val generativeModel : GenerativeModel = GenerativeModel(
        model = "gemini-1.5-flash-001",
        apiKey = Constants.apiKey
        )

    fun sendMessage(question : String){
        Log.i("In ChatViewModel",question)
    }
}
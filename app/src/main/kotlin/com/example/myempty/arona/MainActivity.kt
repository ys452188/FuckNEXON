// FUCK NEXON
// FUCK NEXON
// FUCK NEXON
package com.example.myempty.arona

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.enums.SidePattern
import com.lzf.easyfloat.permission.PermissionUtils
import kotlin.with
import android.widget.ImageView
import android.widget.Button
import com.example.myempty.arona.Arona
import android.content.Context
import android.widget.LinearLayout
import android.net.Uri
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var arona: Arona
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var clickCount = 0;
        var mainLinearLayout:LinearLayout = findViewById(R.id.main_linear_layout)
        mainLinearLayout.setOnClickListener {
            clickCount++
            if(clickCount == 3) {
                Toast.makeText(this, "混亂。是無法理解的行动。請不要戳我。會故障的", Toast.LENGTH_SHORT).show()
            }
            if(clickCount == 5) {
                Toast.makeText(this, "我明白了。老師現在没有特别要做的事對吧。很閒對吧", Toast.LENGTH_SHORT).show()
                clickCount = 0
            }
        }
        
        arona = Arona(this)
        sayWelcome()
        showFloatWindow()
        gotoBowserToFuckNEXON()
        closeWindow()
    }
    private fun sayWelcome() {
        Toast.makeText(this, "Welcome! Sensei", Toast.LENGTH_SHORT).show()
    }
    private fun showFloatWindow() {
        PermissionUtils.checkPermission(this)
        EasyFloat.with(this)
                .setTag("arona_floating_window")
                .setSidePattern(SidePattern.RESULT_HORIZONTAL)
                .setDragEnable(true)
                .setShowPattern(ShowPattern.ALL_TIME)
                .setLayout(R.layout.arona) { 
                    view ->
                    val aronaView: ImageView = view.findViewById(R.id.arona_view)
                    aronaView.setOnClickListener {
                        arona.outputAudioMessage()
                    }
                }
                .show()
    }
    private fun closeWindow() {
        var closeButton:Button = findViewById(R.id.close_window_button)
        closeButton.setOnClickListener {
            EasyFloat.dismiss("arona_floating_window")
            arona.release()
            finish()
        }
    }
    private fun gotoBowserToFuckNEXON() {
        var fuckNEXONBotton:Button = findViewById(R.id.fuck_nexon)
        fuckNEXONBotton.setOnClickListener {
            fuckNEXON()
        }
    }
    private fun fuckNEXON() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nexon.com/main/en/Blue%20Archive/details"))
        startActivity(intent)
    }
}

package com.liutimo.androidbasic_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /**
     * 通过android:onClick关联。满足以下条件:
     * 1. public
     * 2. 返回值为空 或者Kotlin中的 隐式单元
     * 3. View 是唯一参数
     */
    fun sendMessage(view : View) {
        /**
         * Intent 是相互独立的组件之间提供运行时绑定功能的对象。
         * 表示执行某项操作的意图。
         */

        val editText = findViewById<EditText>(R.id.editText)
        val message  = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}

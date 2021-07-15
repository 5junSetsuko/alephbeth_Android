package com.example.alephbeth_android;

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.alephbeth_android.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.画面遷移用ボタンの取得。
        val btnIntent1 = findViewById<Button>(R.id.button_1)
        //2.画面遷移用ボタンにリスナを登録。
        btnIntent1.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                //3.Intentクラスのオブジェクトを生成。
                val intent = Intent(this@MainActivity, HebrewCharQuize::class.java)
                //生成したオブジェクトを引数に画面を起動！
                startActivity(intent)
            }
        })

        //1.画面遷移用ボタンの取得。
        val btnIntent2 = findViewById<Button>(R.id.button_2)
        //2.画面遷移用ボタンにリスナを登録。
        btnIntent2.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                //3.Intentクラスのオブジェクトを生成。
                val intent = Intent(this@MainActivity, VowelsQuize::class.java)
                //生成したオブジェクトを引数に画面を起動！
                startActivity(intent)
            }
        })

        //1.画面遷移用ボタンの取得。
        val btnIntent3 = findViewById<Button>(R.id.button_3)
        //2.画面遷移用ボタンにリスナを登録。
        btnIntent3.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                //3.Intentクラスのオブジェクトを生成。
                val intent = Intent(this@MainActivity, RememberHebrewChar::class.java)
                //生成したオブジェクトを引数に画面を起動！
                startActivity(intent)
            }
        })

        //1.画面遷移用ボタンの取得。
        val btnIntent4 = findViewById<Button>(R.id.button_4)
        //2.画面遷移用ボタンにリスナを登録。
        btnIntent4.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                //3.Intentクラスのオブジェクトを生成。
                val intent = Intent(this@MainActivity, RememberVowels::class.java)
                //生成したオブジェクトを引数に画面を起動！
                startActivity(intent)
            }
        })
    }
}

package com.heyangpeng.datastoreinfile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

/**
 * 保存文件可以通过Device File Explorer查看，该工具通常在右下角的侧边栏上，如果没有则可以通过
 * Ctrl + Shift + A（Mac 是 Command + Shift + A）搜索Device File Explorer。文件目录为data/data/包名/files/
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText = loadText()
        if (inputText.isNotEmpty()) {
            dataInput.setText(inputText)
            dataInput.setSelection(inputText.length)//将光标移到行末
        }
    }

    /**
     * 从文件中读取数据
     */
    private fun loadText(): String {
        val content = StringBuffer()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                //forEachLine将每行内容都回调到lambda表达式，直接可以在lambda中进行数据拼接
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        val data = dataInput.text.toString()
        saveData(data)
    }

    /**
     *将数据存入文件，文件目录为data/data/包名/files
     */
    private fun saveData(data: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            //use函数是Kotlin中的一个内置拓展函数，它会保证lambda表达式执行完后自动关闭外层的流，无需在写finally
            writer.use {
                it.write(data)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
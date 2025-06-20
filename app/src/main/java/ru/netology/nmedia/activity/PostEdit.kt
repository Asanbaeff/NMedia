package ru.netology.nmedia.activity

import android.R.attr.content
import android.R.attr.text
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.AcPostEditBinding


class PostEdit : AppCompatActivity() {

    private lateinit var binding: AcPostEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AcPostEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получаем исходный контент поста из интента
        val postContent = intent.getStringExtra("postContent")
        val postId = intent.getLongExtra("postId", 0L)

        // Устанавливаем исходный контент в EditText
        binding.textEdit.setText(postContent)

        binding.buttonSave.setOnClickListener {
            val updatedContent = binding.textEdit.text.toString()

            if (updatedContent.isBlank()) {
                setResult(Activity.RESULT_CANCELED)
            } else {
                val resultIntent = Intent().apply {
                    putExtra("updatedContent", updatedContent)
                    putExtra("postId", postId)
                }
                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()
        }

    }
}

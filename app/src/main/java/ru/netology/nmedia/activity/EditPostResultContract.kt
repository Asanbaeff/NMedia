package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract


class EditPostResultContract : ActivityResultContract<Pair<Long, String>, Pair<Long, String>?>() {
    override fun createIntent(context: Context, input: Pair<Long, String>): Intent =
        Intent(context, NewPostActivity::class.java).apply {
            putExtra("postId", input.first)
            putExtra("postContent", input.second)
        }

    override fun parseResult(resultCode: Int, intent: Intent?): Pair<Long, String>? {
        if (resultCode != Activity.RESULT_OK || intent == null) return null
        val postId = intent.getLongExtra("postId", 0L)
        val content = intent.getStringExtra(Intent.EXTRA_TEXT)
        return if (content != null) postId to content else null
    }
}

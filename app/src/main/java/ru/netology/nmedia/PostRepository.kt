package ru.netology.nmedia

import androidx.lifecycle.LiveData
import ru.netology.nmedia.dto.Post

interface PstRepository {
    fun get(): LiveData<Post>
    fun like()
}
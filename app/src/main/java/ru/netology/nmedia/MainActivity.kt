package ru.netology.nmedia

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.CounterFormatter
import ru.netology.nmedia.dto.Post


class MainActivity : AppCompatActivity() {
    val formatter = CounterFormatter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //----------
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            publisher = "21 мая в 18:03",
            likes = 0,
            shares = 99,
        )

        with(binding) {
            author.text = post.author
            published.text = post.publisher
            content.text = post.content
            likeCount.text = post.likes.toString()

            if (post.likeByMe) {
                like.setImageResource(R.drawable.ic_liked_24)
            }

            like.setOnClickListener {
                post.likeByMe = !post.likeByMe
                like.setImageResource(
                    if (post.likeByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likeByMe) {
                    post.views += 1
                } else {
                    post.views -= 1
                }
                binding.likeCount.text = formatter.format(post.views)
            }

            //share
            fun updateShares() {
                binding.shareCount.text = formatter.format(post.shares)
            }
            updateShares()
            binding.share.setOnClickListener {
                post.shares += 1
                updateShares()
            }
        }
        //---------
        //binding.root.setOnClickListener {}
        //binding.like.setOnClickListener {}
    }
}
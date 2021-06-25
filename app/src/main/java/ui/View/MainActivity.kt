package ui.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.alvaro.examplemvvm.databinding.ActivityMainBinding
import ui.viewModel.QuoteViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, {
            binding.textViewQuote.text = it.quote
            binding.textViewAuthor.text = it.author
        })

        quoteViewModel.isLoading.observe(this,{
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuotes() }
    }
}
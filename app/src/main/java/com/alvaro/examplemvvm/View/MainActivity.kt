package com.alvaro.examplemvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alvaro.examplemvvm.databinding.ActivityMainBinding
import com.alvaro.examplemvvm.viewModel.QuoteViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, {
            binding.textViewQuote.text = it.quote
            binding.textViewAuthor.text = it.author
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuotes() }


    }
}
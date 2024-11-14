package com.example.novelappfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.novelappfirebase.ui.theme.NovelAppFirebaseTheme
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        setContent {
            NovelAppFirebaseTheme {
                App()
            }
        }
    }
    class MainActivity : AppCompatActivity() {
        private lateinit var favoritesManager: FavoritesManager

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            favoritesManager = FavoritesManager(this)

            // Ejemplo de cómo guardar un favorito
            favoritesManager.saveFavorite("item1")

            // Ejemplo de cómo obtener los favoritos
            val favorites = favoritesManager.getFavorites()
            println("Favoritos: $favorites")
        }
    }
}

package jungabriel56.com.github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import jungabriel56.com.github.adapter.PraiasAdapter
import jungabriel56.com.github.model.PraiaModel
import jungabriel56.com.github.ui.theme.GS3SITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val praiasAdapter = PraiasAdapter()
        recyclerView.adapter = praiasAdapter

        val button = findViewById<Button>(R.id.button)
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.azul_esverdeado))
        val editText = findViewById<EditText>(R.id.textPraia)



        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha com um valor"
                return@setOnClickListener
            }


            val item = PraiaModel(
                name = editText.text.toString(),
                onRemove = {
                    praiasAdapter.removePraia(it)
                }
            )

            praiasAdapter.addPraia(item)

            editText.text.clear()
        }

    }
}
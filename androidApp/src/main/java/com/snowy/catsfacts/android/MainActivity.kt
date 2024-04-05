package com.snowy.catsfacts.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.snowy.catsfacts.presentation.uistate.CatState
import com.snowy.catsfacts.android.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                CatsFactsUi()
            }
        }
    }
}

@Composable
fun CatsFactsUi(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val factsList by viewModel.factsList.collectAsStateWithLifecycle()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            factsList.forEach {
                CatsFactsItem(it)
            }
        }
    }

}

@Composable
fun CatsFactsItem(item: CatState) {
    Column {
        Text(text = "Fact: ${item.catFact}")
        Divider(Modifier.height(2.dp))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CatsFactsItem(
            CatState("text")
        )
    }
}

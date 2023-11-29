package com.screens.raspilitel

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.navigation.Screen
import kotlinx.coroutines.tasks.await

data class Product3(
    val proizvoditel: String,
    val article: String,
    val kolvo: String,
    val price: Double
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RLiweiScreen(navController: NavController) {
    var productList by remember { mutableStateOf(emptyList<Product>()) }

    LaunchedEffect(Unit) {
        val list = getProductList3()
        productList = list
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Смотреть товар") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.start.route) }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                }
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (productList.isNotEmpty()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(productList) { product ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = product.proizvoditel,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Артикул: ${product.article}",
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Количество: ${product.kolvo}",
                                    style = MaterialTheme.typography.body1
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Цена: ${product.price} руб.",
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.primary
                                )
                            }
                        }
                    }
                }
            } else {
                Text(
                    text = "Нет доступных товаров",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.error
                )
            }
        }
    }
}

suspend fun getProductList3(): List<Product> {
    val firestore = FirebaseFirestore.getInstance()
    val productList = mutableListOf<Product>()

    val collection = firestore.collection("Rliwei")

    try {
        val querySnapshot = collection.get().await()

        for (document in querySnapshot.documents) {
            val proizvoditel = document.getString("proizvoditel") ?: ""
            val article = document.getString("article") ?: ""
            val kolvo = document.getString("kolvo") ?: ""
            val priceStr = document.getString("price") ?: "0.0"
            val price = priceStr.toDouble()

            val product = Product(proizvoditel, article, kolvo, price)
            productList.add(product)
        }
    } catch (e: Exception) {
        // Обработка ошибки при запросе к Firestore
        e.printStackTrace()
    }

    return productList
}

package com.screens.raspilitel


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.navigation.Screen
import kotlinx.coroutines.tasks.await

data class Product(
    val proizvoditel: String,
    val article: String,
    val kolvo: String,
    val price: Double
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RBoschScreen(navController: NavController) {
    var productList by remember { mutableStateOf(emptyList<Product>()) }

    LaunchedEffect(Unit) {
        val list = getProductList()
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

suspend fun getProductList(): List<Product> {
    val firestore = FirebaseFirestore.getInstance()
    val productList = mutableListOf<Product>()

    val collection = firestore.collection("Rbosch")

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
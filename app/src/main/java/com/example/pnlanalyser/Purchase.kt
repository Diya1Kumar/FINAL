package com.example.pnlanalyser

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PurchaseEntryScreen(

    navigateToFirstScreen: () -> Unit
) {
    val itemName = remember { mutableStateOf("") }
    val itemPrice = remember { mutableStateOf("") }
    val quantity = remember { mutableStateOf("") }
    val companyName = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create New Purchase Entry",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = companyName.value,
            onValueChange = { companyName.value = it },
            label = { Text("Company Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = quantity.value,
            onValueChange = { quantity.value = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = itemPrice.value,
            onValueChange = { itemPrice.value = it },
            label = { Text("Total Amount") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Convert string inputs to appropriate types

                navigateToFirstScreen()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save Purchase Entry")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigateToFirstScreen() },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back to Dashboard")
        }
    }
}
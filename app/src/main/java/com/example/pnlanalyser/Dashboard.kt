package com.example.pnlanalyser

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardPage(navigateToPurchase: () -> Unit, navigateToSale: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(top = 30.dp),
        verticalArrangement = Arrangement.Top,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()

        Spacer(modifier = Modifier.height(60.dp))

        ActionButtons(navigateToPurchase, navigateToSale)

        Spacer(modifier = Modifier.height(30.dp))

        ProfitLossDisplay()

        Spacer(modifier = Modifier.height(20.dp))

        DataTable()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo image resource name
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp) // Set the size of the logo
                .padding(8.dp) // Add some padding if necessary
        )
        Text(text = "Dashboard", fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f).padding(start = 8.dp))
        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon",
                modifier = Modifier
                .padding(end = 8.dp))
    }
}

@Composable
fun ActionButtons(navigateToPurchase: () -> Unit, navigateToSale: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {navigateToPurchase()},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Purchase",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = "Create New Purchase Entry", fontSize = 13.3.sp)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {navigateToSale()},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Sale",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = "Create New Sale Entry")
        }
    }
}

@Composable
fun ProfitLossDisplay() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfitColumn()
        LossColumn()
    }
}

@Composable
fun ProfitColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "$10,000", // Dummy number for profit
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Profit",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun LossColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "$5,000", // Dummy number for loss
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Loss",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun DataTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header row for the table
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(text = "Company", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(text = "Invested", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(text = "Profit/Loss", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Data rows for the table
        for (i in 1..5) { // Example: creating 5 rows of data
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "John Doe", modifier = Modifier.weight(1f))
                Text(text = "TechCorp", modifier = Modifier.weight(1f))
                Text(text = "$50,000", modifier = Modifier.weight(1f))
                Text(text = "+$5,000", color = Color.Green, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    DashboardPage(
        navigateToPurchase = { /* TODO: Implement navigation */ },
        navigateToSale = { /* TODO: Implement navigation */ }
    )
}

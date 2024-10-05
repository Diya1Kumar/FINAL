package com.example.pnlanalyser

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun dashboardPage(navigateToDashboard: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Logo")
            Text(text = "Dashboard")
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
        }


        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Space buttons evenly
        ) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Purchase",
                    modifier = Modifier.padding(end = 8.dp)
                ) // Plus icon
                Text(text = "Create New Purchase Entry")
            }

            Spacer(modifier = Modifier.width(16.dp)) // Space between buttons

            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Purchase",
                    modifier = Modifier.padding(end = 8.dp)
                ) // Plus icon
                Text(
                    text = "Create New Sale Entry",
                    fontSize = 15.sp
                )
            }
        }


        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Column for Profit
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
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
                    fontSize = 18.sp, // Larger font size
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Column for Loss
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f) // Makes the column occupy equal space
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
                    fontSize = 18.sp, // Larger font size
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Column for the entire table
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

            Spacer(modifier = Modifier.height(8.dp)) // Space between header and data rows

            // Data rows for the table
            for (i in 1..5) { // Example: creating 5 rows of data
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "John Doe", modifier = Modifier.weight(1f))  // Name column
                    Text(text = "TechCorp", modifier = Modifier.weight(1f))  // Company column
                    Text(text = "$50,000", modifier = Modifier.weight(1f))  // Invested column
                    Text(text = "+$5,000", color = Color.Green, modifier = Modifier.weight(1f))  // Profit/Loss column
                }

                Spacer(modifier = Modifier.height(8.dp)) // Space between rows
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    dashboardPage({})
}

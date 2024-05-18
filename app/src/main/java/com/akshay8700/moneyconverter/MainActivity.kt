package com.akshay8700.moneyconverter

import android.icu.util.Currency
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshay8700.moneyconverter.ui.theme.MoneyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneyConverterTheme {
                Surface {
                    MoneyConverterScreen()
                }
            }
        }
    }
}

@Composable
fun MoneyConverterScreen() {
    // States of data
    var inputText by remember{ mutableStateOf("")}
    var outputDispaly by remember{ mutableStateOf("") }
    var firstBottonTxt by remember{ mutableStateOf("From")}
    var secondBottonTxt by remember{ mutableStateOf("To")}
    var inExpanded by remember{ mutableStateOf(false) }
    var outExpanded by remember{ mutableStateOf(false) }

    // States of Currency
    var fromCurrency by remember{ mutableStateOf("Rupees") }
    var toCurrency by remember{ mutableStateOf("Dollars") }

    // Layout Part
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        // Enter Text
        TextField(value = inputText, onValueChange = {inputText = it})
        Spacer(modifier = Modifier.padding(8.dp))

        // Display text output
        Text(text = "$fromCurrency to $toCurrency: $outputDispaly",
            fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(8.dp))

        // Both buttons inside Row/Box
        Row {
            // First button and Dropdown menu
            Box(){
                Button(onClick = { inExpanded = true }) {
                    Text(text = firstBottonTxt)
                }
                DropdownMenu(expanded = inExpanded, onDismissRequest = { inExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Rupees") }, onClick = { fromCurrency = "Rupees" })
                    DropdownMenuItem(text = { Text(text = "Dollar") }, onClick = { fromCurrency = "Dollars" })
                }
            }
            Spacer(modifier = Modifier.padding(42.dp))

            // Second button and Dropdown menu
            Box(){
                Button(onClick = { outExpanded = true }) {
                    Text(text = secondBottonTxt)
                }
                DropdownMenu(expanded = outExpanded, onDismissRequest = { outExpanded = false }) {
                    DropdownMenuItem(text = {Text(text = "Rupees") }, onClick = { toCurrency = "Rupees" })
                    DropdownMenuItem(text = {Text(text = "Dollar") }, onClick = { toCurrency = "Dollars" })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoneyConverterTheme {
        Surface {
            MoneyConverterScreen()
        }
    }
}
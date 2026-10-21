package com.serxanallahverdiyev.composescreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serxanallahverdiyev.composescreens.ui.theme.ComposeScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeScreensTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Weather(modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }
}

@Composable
fun ProductDetails(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(0) }
    var selectedSize by remember { mutableStateOf(CupSize.MEDIUM) }
    val price = when (selectedSize) {
        CupSize.SMALL -> 350.0
        CupSize.MEDIUM -> 420.0
        CupSize.LARGE -> 490.0
    }

    val total = remember(number, price){
        number * price
    }

    val sizeList = remember {
        listOf(
            SizeItem(size = CupSize.SMALL, amount = 250.0, weight = "ml", title = ""),
            SizeItem(size = CupSize.MEDIUM, amount = 350.0, weight = "ml", title = ""),
            SizeItem(size = CupSize.LARGE, amount = 450.0, weight = "ml", title = "")
        )
    }

    fun Plus() {
        number++
    }

    fun Minus() {
        if (number > 0) number--
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clip(RoundedCornerShape(bottomStart = 45.dp, bottomEnd = 45.dp))
                .background(color = Color(0xFFEFE0C9))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                WeatherIcons(icon = Icons.AutoMirrored.Filled.ArrowBack)
                WeatherIcons(icon = Icons.Default.FavoriteBorder)
            }

            Icon(
                imageVector = Icons.Default.Coffee,
                contentDescription = null,
                tint = Color(0xFF5D4037),
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 1.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFB300),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Best seller",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Caramel Latte",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        modifier = Modifier.size(20.dp),
                        contentDescription = null,
                        tint = Color(0xFFFFB300)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.8",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = " (230)",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Text(
                text = "Espresso · steamed milk · caramel",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "A smooth espresso with steamed milk and a spoon of caramel, served hot with a light layer of foam.",
                color = Color.Gray,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
        }
        Text(
            "Size",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 24.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            sizeList.forEach { item ->
                WeatherSize(
                    sizeItem = item,
                    isSelected = selectedSize == item.size,
                    onClick = { selectedSize = item.size }
                )
            }
        }
        Spacer(
            Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .dropShadow(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    shadow = Shadow(
                        radius = 12.dp,
                        spread = 12.dp,
                        offset = DpOffset(0.dp, 20.dp)
                    )
                )
                .background(Color(0xFFEBEFF1))
                .padding(all = 12.dp)

        ) {
            Box(
                modifier = Modifier
                    .clickable(onClick = { if (number > 0) Minus() })
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEBEFF1))
                    .border(shape = CircleShape, width = 1.dp, color = Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "-",
                    color = Color.Gray,
                    fontSize = 40.sp
                )

            }
            Text(
                "$number",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically)
            )
            Box(
                modifier = Modifier
                    .clickable(onClick = { Plus() })
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFBFE4F6))
                    .border(shape = CircleShape, width = 1.dp, color = Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "+",
                    color = Color.Gray,
                    fontSize = 40.sp
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .height(48.dp)
                    .background(Color(0xFF35546C), shape = RoundedCornerShape(12.dp))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBasket,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Add to cart $$total",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

enum class CupSize(val symbol: String) {
    SMALL("S"), MEDIUM("M"), LARGE("L")
}

data class SizeItem(
    val size: CupSize,
    val title: String,
    val amount: Double,
    val weight: String,
)

@Composable
fun WeatherSize(
    sizeItem: SizeItem,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .size(width = 80.dp, height = 50.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF35546C) else Color(0xFFFCFAFA)
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                sizeItem.size.symbol,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (isSelected) Color.White else Color.Black
            )
            Text(
                "${sizeItem.amount} ${sizeItem.weight}",
                fontSize = 8.sp,
                color = if (isSelected) Color.LightGray else Color.Gray
            )
        }
    }
}

@Composable
fun WeatherIcons(icon: ImageVector, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(40.dp)
            .background(color = Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    ComposeScreensTheme {
        ProductDetails()
    }
}

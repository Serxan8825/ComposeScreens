package com.serxanallahverdiyev.composescreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.WindPower
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serxanallahverdiyev.composescreens.ui.theme.ComposeScreensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Weather(modifier: Modifier = Modifier){
    Column(modifier=Modifier.fillMaxSize()
        .background(Color(0xFFF0F5F4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)){
        TopAppBar( title = {
            Column{
                Row{
                    Icon(Icons.Default.LocationOn, contentDescription = null)
                    Text("Baku",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                }
                Text("Tuesday,13 Octaber",
                    fontSize = 12.sp)
            }
        },
            actions = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Update, contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp))
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
        modifier=Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp))

        WeatherCard()
        ComponentsRow()
        TodayCard()

    }


}


@Composable
fun WeatherCard(){
    Card(modifier=Modifier.fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        colors = CardDefaults.cardColors(Color(0xFF32796B)),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = CardDefaults.shape){
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround){
            Column(modifier = Modifier.padding(16.dp)){
                Text("Now",
                    fontSize = 16.sp,
                    color = Color(0xFFB1DED9),

                )
                Text("18℃",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    color=Color.White)
                Text("Partly cloudy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color=Color.White)
                Text("H: 21℃ L: 12℃",
                    fontSize = 16.sp,
                    color = Color(0xFFB1DED9)
                    )

            }
            Box(modifier = Modifier.align(Alignment.CenterVertically),contentAlignment = Alignment.Center){
                Icon(Icons.Default.Cloud, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(100.dp))
                Icon(Icons.Default.WbSunny, contentDescription = null,
                    tint = Color(0xFFD2B227),
                        modifier=Modifier.offset(30.dp,-10.dp)
                            .size(80.dp)
                )
            }
        }

    }


}
data class Components(val icon: ImageVector, val value: String, val title: String)
val components = listOf(Components(Icons.Default.WaterDrop,"62%","Humidity"),
    Components(Icons.Default.WindPower,"14 km/h","Wind"),
    Components(Icons.Default.WbSunny,"20%","UV index"))
@Composable
fun ComponentItem(component:Components){
    Card(modifier = Modifier.padding(5.dp),colors = CardDefaults.cardColors(Color.White)){
        Column(modifier=Modifier.padding(16.dp)){
            Box(modifier = Modifier.size(40.dp)
                .background(Color(0xFF83D3C3), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center){
                Icon(component.icon, contentDescription = null,
                    tint=Color(0xFF177067)
                )
            }
            Text("${component.value}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Text("${component.title}")
        }
    }
}


@Composable
fun ComponentsRow(){
        LazyRow (modifier=Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            items(components){
                ComponentItem(it)
            }
        }
    }

data class Today(val title: String,val icon: ImageVector, val value: String)
val items = listOf(Today("Now",Icons.Default.Cloud,"18℃"),
    Today("13:00",Icons.Default.Cloud,"18℃"),
    Today("14:00",Icons.Default.WbSunny,"20℃"),
    Today("15:00",Icons.Default.WbSunny,"21℃"),
    Today("16:00",Icons.Default.WbSunny,"20℃"),
    Today("17:00",Icons.Default.Cloud,"19℃"),
    Today("18:00",Icons.Default.WbCloudy,"17℃"),
    Today("19:00",Icons.Default.WbCloudy,"16℃"))
@Composable
fun TodayItem(today: Today){
   Box(modifier = Modifier.
   background(Color.White,RoundedCornerShape(10.dp))
       ,contentAlignment = Alignment.Center){
       Column(modifier = Modifier.padding(10.dp)){
           Text(today.title,
               fontSize = 16.sp)
           Icon(today.icon, contentDescription = null,
               tint = Color(0xFF177067),
               modifier = Modifier.size(30.dp)
           )
           Text(today.value,
               fontWeight = FontWeight.Bold,
               fontSize = 16.sp)
       }


}
}

@Composable
fun TodayCard(){
    Card(modifier=Modifier.fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        colors = CardDefaults.cardColors(Color.White)){
        Column(modifier=Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)){
            Row(modifier=Modifier.fillMaxWidth()){
                Text("Today",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier=Modifier.weight(1f))
                Text("Next 7 days",
                    color = Color(0xFF428D85)
                )
            }
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(items){
                    TodayItem(it)
                }
            }


        }

    }

}




@Preview(showBackground = true)
@Composable
fun WeatherPreview(){
    ComposeScreensTheme() {
        Weather()

    }
}
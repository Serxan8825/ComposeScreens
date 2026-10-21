package com.serxanallahverdiyev.composescreens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ContactSupport
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.filled.MenuOpen
import androidx.compose.material.icons.automirrored.filled.NoteAdd
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serxanallahverdiyev.composescreens.ui.theme.ComposeScreensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(modifier: Modifier = Modifier){

    Column(modifier = Modifier.fillMaxSize()
        .background(Color.White)
        , verticalArrangement = Arrangement.spacedBy(16.dp)
    , horizontalAlignment = Alignment.CenterHorizontally){

        TopAppBar(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(40.dp)),
            title = {Text("Profile",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null,
                        tint= Color.Black)
                } },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.AutoMirrored.Filled.MenuOpen, contentDescription = null,
                        tint= Color.Black)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)

        )

            ProfileBody()
            ProfileAbout()
    }

}
@Composable
fun ProfileBody(){
    var isSelected by remember { mutableStateOf(false) }
    var followers by remember { mutableStateOf(2431) }
    Card(modifier = Modifier.fillMaxWidth()
        .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF1B7E75))
            ) {
                Box(
                    modifier = Modifier.size(100.dp)
                        .offset(20.dp, 50.dp)
                        .border(3.dp, Color.White, CircleShape)
                        .background(Color(0xFFB8E7E2), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "SA",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B7E75)
                    )
                    Box(
                        modifier = Modifier.size(20.dp)
                            .offset(20.dp, 35.dp)
                            .border(1.dp, Color.White, CircleShape)
                            .background(Color.Green, CircleShape)
                    )


                }

            }
            Spacer(modifier = Modifier.height(25.dp))


            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Serxan Allahverdiyev",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Text(
                    "Android Developer at Kapital Bank",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painterResource(id = R.drawable.ic_menu_my_calendar),
                        contentDescription = null,
                        Modifier.size(20.dp)
                    )
                    Text(
                        "Joined 2026",
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                HorizontalDivider()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "128",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text("Posts",
                            color = Color.Black)
                    }
                    VerticalDivider(modifier = Modifier.height(70.dp)
                        .padding(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "$followers",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text("Followers",
                            color=Color.Black)

                    }
                    VerticalDivider(modifier = Modifier.height(70.dp)
                        .padding(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "312",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text("Following",
                            color=Color.Black)

                    }
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedButton(onClick = {
                        isSelected = !isSelected
                        if(isSelected) followers++ else followers--

                    },
                        colors =if(isSelected) ButtonDefaults.outlinedButtonColors(Color.Transparent) else ButtonDefaults.outlinedButtonColors(Color(0xFF1B7E75))) {
                        Icon(
                          if(isSelected)  Icons.Default.Check else Icons.Default.Person,
                            contentDescription = null,
                            tint = if(isSelected) Color(0xFF1B7E75) else Color.White
                        )
                        Text(text= if(isSelected)"Following" else "Follow",
                        color = if(isSelected) Color(0xFF1B7E75) else Color.White )
                    }
                    OutlinedButton(onClick = {}) {
                        Icon(
                            Icons.Default.Message,
                            contentDescription = null,
                            tint = Color(0xFF1B7E75)
                        )
                        Text("Follow",
                            color = Color(0xFF1B7E75))
                    }


                }



            }

        }
    }
    }


@Composable
fun ProfileAbout(){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
       shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Column(modifier=Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
            Text("About",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.Black,
                modifier=Modifier.padding(start = 20.dp, top = 20.dp))
            Text("I build Android apps with Kotlin and Jetpack Compose.Right now I`m learning Material 3 and animations",
                color=Color.Black,
                modifier=Modifier.padding(start = 20.dp, end = 20.dp))
            FlowRow(modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)){
                OutlinedButton(onClick = {}){
                    Text("Kotlin",
                        color=Color.Black)
                }
                OutlinedButton(onClick = {}){
                    Text("Compose",
                        color=Color.Black)
                }
                OutlinedButton(onClick = {}){
                    Text("Material 3",
                        color=Color.Black)
                }
                OutlinedButton(onClick = {}){
                    Text("Git",
                        color=Color.Black)
                }
            }


        }

    }



}








@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    ComposeScreensTheme() {
        Profile()
    }
}
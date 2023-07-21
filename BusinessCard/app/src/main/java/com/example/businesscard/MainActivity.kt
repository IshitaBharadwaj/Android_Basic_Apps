package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column (
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color(0xFF68f28c))

            ){
        CardInfo(modifier = Modifier.padding(bottom = 80.dp))
        AllCardContact()
    }
}

@Composable
fun CardInfo( modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val image = painterResource(R.drawable.android_logo)
        Box(
            Modifier.background(Color(0xFF008000))
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)

            )
        }

        Text(
            text = stringResource(R.string.name),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp,
            color = Color(0xFF386b45)
        )
    }

}

@Composable
fun CardContact(icon1: ImageVector, TextValue: String, modifier: Modifier=Modifier){

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement =  Arrangement.Center,
            verticalAlignment =  Alignment.CenterVertically,
            modifier = modifier.padding(top = 16.dp,
            start = 16.dp,
            end = 16.dp)
        ){

            Icon(
                icon1,
                "Phone Icon",
                tint = Color(0xFF386b45)
            )

            Text(
                text = TextValue,
                fontSize = 15.sp,
                lineHeight = 15.sp,
                color = Color(0xFF386b45),
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun AllCardContact(modifier:Modifier = Modifier){
    val Phone = Icons.Filled.Phone
    val Share = Icons.Filled.Share
    val Mail = Icons.Filled.Email
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            ){
        CardContact(Phone, stringResource(R.string.phno))
        CardContact(Share, stringResource(R.string.user_id))
        CardContact(Mail, stringResource(R.string.emailid))
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {

    BusinessCardTheme {
        AllCardContact()

    }
}
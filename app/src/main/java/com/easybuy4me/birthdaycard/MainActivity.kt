package com.easybuy4me.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easybuy4me.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage( name = stringResource(R.string.great_grant), from = stringResource(R.string.ben))
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    // Create a column so that texts don't overlap
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center)
    {
        Text(
            text = "Happy Birthday $name",
            modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )

        Text(
            color = Color.Black,
            text = "from $from",
            fontSize = 36.sp,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(name: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            name = name,
            from = from,
            modifier = modifier
        )
    }

}

@Preview(
    name = "mypreview",
    showSystemUi = true,
    showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardTheme {
//        GreetingText("Grant", "Ben")
        GreetingImage( name = stringResource(R.string.great_grant), from = stringResource(R.string.ben))
    }
}
package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.taskapp.ui.theme.Poppins
import com.example.taskapp.ui.theme.PrimaryColor
import com.example.taskapp.ui.theme.PrimaryTextColor
import com.example.taskapp.ui.theme.SubTextColor
import com.example.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    window.statusBarColor = ContextCompat.getColor(this, R.color.black)
                    MainFun()
                }
            }
        }
    }
}

@Composable
fun MainFun(){
    Column(
//        Modifier.fillMaxHeight()
        Modifier.fillMaxSize()
    ){
        HeaderUI()
        TaskCardUI()
    }
}

@Composable
fun TaskCardUI() {

    val annotatedString1 = AnnotatedString.Builder("4/6 Task")
        .apply {
            addStyle(
                SpanStyle(
                    color = PrimaryColor,
                ), 0, 3
            )
        }

   Card(
       colors = CardDefaults.cardColors(
           containerColor = Color.White
       ),
       elevation = CardDefaults.cardElevation(0.dp),
       shape = RoundedCornerShape(8.dp),
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 22.dp)
           .padding(top = 40.dp)
   ){
        Row(
            modifier = Modifier
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(){
                Text(
                    text = "Daily Task",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = SubTextColor,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_tick_circle),
                        contentDescription = "",
                        tint = PrimaryColor)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = annotatedString1.toAnnotatedString(),
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        color = PrimaryTextColor,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Almost finished,\nkeep it up",
                    fontFamily = Poppins,
                    fontSize = 13.sp,
                    color = Color(0xFF292D32),
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 16.dp)

                ) {
                    Text(
                        text = "Daily Task",
                        fontSize = 10.sp,
                        modifier = Modifier.align(alignment = CenterVertically),
                        fontFamily = Poppins
                    )
                }
            }
        }
   }
}

@Composable
fun HeaderUI() {

      Row(
          Modifier
              .fillMaxWidth()
//              .height(intrinsicSize = IntrinsicSize.Min)
              .padding(
                  horizontal = 30.dp,
              )
              .padding(top = 20.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween


      ){
          Column(
              modifier = Modifier
//                  .weight(1f)
          ) {
              Text(
                  text = "Hello, Eugene",
                  fontFamily = Poppins,
                  fontSize = 18.sp,
                  color = PrimaryTextColor,
                  fontWeight = FontWeight.Bold)
              Text(
                  text = "Let's do your todays task",
                  color = Color.Gray )
          }
          Image(
              painter = painterResource(id = R.drawable.logo),
              contentDescription = "",
                modifier = Modifier
                    .size(44.dp)
                    .clip(shape = CircleShape)
              )
      }
  }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskAppTheme {
       MainFun()
    }
}
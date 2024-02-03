package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.taskapp.ui.theme.Poppins
import com.example.taskapp.ui.theme.PrimaryColor
import com.example.taskapp.ui.theme.PrimaryTextColor
import com.example.taskapp.ui.theme.SecondaryColor
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
        StatisticUI()
    }
}

@Composable
fun StatisticUI() {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Column(modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(SecondaryColor)
                    .size(10.dp)
            ){
//                Text(
//                    text = "On Going",
//                    fontSize = 10.sp,
//                    fontFamily = Poppins,
//                    color = Color(0xFF7885B9)
//                )
            }
            Text(
                text = "Your ongoing tasks",
                fontFamily = Poppins,
                fontSize = 16.sp,
                color = PrimaryTextColor,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(){
               Icon(
                   painter = painterResource(id = R.drawable.ic_clock),
                   contentDescription = "",
                   tint = Color(0xFF818181),
                   modifier = Modifier.size(16.dp)
               )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "09.00 AM - 11.00 AM",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = Color(0xFF818181),
                    fontWeight = FontWeight.Medium
                )
            }
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(0xFFE1E3FA))
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .border(
                        width = 0.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
            ){
                Text(
                    text = "On Going",
                    fontSize = 10.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF7885B9)
                )
            }


        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Statistic",
            fontFamily = Poppins,
            fontSize = 16.sp,
            color = SubTextColor,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            StatisticProgressUI()
            Spacer(modifier = Modifier.width(12.dp))
            StatisticIndicatorUI()
        }
    }
}

@Composable
fun StatisticIndicatorUI() {
   Column(
       modifier = Modifier
           .height(120.dp),
       verticalArrangement = Arrangement.SpaceBetween
   ) {
       IndicatorItemUI(text = "Finish on time")
       IndicatorItemUI(color = SecondaryColor, text = "Past the deadline")
       IndicatorItemUI(color = Color(0xFFE3E5E7), text = "Still ongoing")
   }
}

@Composable
fun IndicatorItemUI(text: String, color: Color = PrimaryColor) {
 Row(){
     Icon(
         painter = painterResource(id = R.drawable.ic_circle),
         contentDescription = "",
         tint = color,
         modifier = Modifier.size(20.dp)
     )
     Spacer(modifier = Modifier.width(12.dp))
     Text(
         text = text,
         fontFamily = Poppins,
         fontSize = 12.sp,
         color = Color(0xFF818181),
         fontWeight = FontWeight.Normal
     )

 }
}

@Composable
fun StatisticProgressUI(primaryPercentage: Float = 60f,secondaryPercentage:Float=15f) {
    Box(
        modifier = Modifier
            .size(120.dp) ,
        contentAlignment = Center
    ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
        ) {

            drawCircle(
                brush = SolidColor(Color(0xFFE3E5E7)),
                radius = size.width /2,
//                style = Fill
                style = Stroke(34f)
            )

                val convertedPrimaryValue = (primaryPercentage / 100) * 360
            val convertedSecondaryValue = ((secondaryPercentage / 100) * 360)+convertedPrimaryValue
            drawArc(
                brush = SolidColor(SecondaryColor),
                startAngle = -90f,
                sweepAngle = convertedSecondaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
            drawArc(
                brush = SolidColor(PrimaryColor),
                startAngle = -90f,
                sweepAngle = convertedPrimaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
        }

        val annotatedString2 = AnnotatedString.Builder("${(primaryPercentage+secondaryPercentage).toInt()}%\nDone")
            .apply {
                addStyle(
                    SpanStyle(
                        color = SubTextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    ), 4, 8
                )
            }

        Text(
            text = annotatedString2.toAnnotatedString(),
            fontFamily = Poppins,
            fontSize = 20.sp,
            color = PrimaryTextColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 10.sp
        )
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
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
//                modifier = Modifier.weight(1f)

            ){
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
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp
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
//            Spacer(modifier = Modifier.weight(1f))
            ProgressBarUI(percentage = 67f)
        }
   }
}

@Composable
fun ProgressBarUI(percentage: Float) {
Box(
    modifier = Modifier.size(120.dp),
    contentAlignment = Center
){
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(6.dp)
    ){
            drawCircle(
                brush = SolidColor(Color(0xFFE3E5E7)),
                radius = size.width / 2,
                style = Stroke(26f)
            )
            //        drawCircle(
            //            brush = Brush.sweepGradient(listOf(Color.Magenta, Color.Red)),
            //            radius = size.width / 2,
            //            style = Stroke(26f)
            //        )

        val convertedValue = (percentage / 100) * 360

        drawArc(
            brush = Brush.linearGradient(
                colors = listOf(SecondaryColor, PrimaryColor)
            ),
            startAngle = -90f,
            sweepAngle = convertedValue,
            useCenter = false,
            style = Stroke(width = 26f, cap = StrokeCap.Round)
        )
    }

    val annotatedString2 = AnnotatedString.Builder(
        "${percentage.toInt()}%\nDone"
    ).apply {
        addStyle(
            SpanStyle(
                color = SecondaryColor,
                fontSize = 8.sp,
                fontWeight = FontWeight.Normal
            ), 4,8
        )
    }

    Text(
        text = annotatedString2.toAnnotatedString(),
        fontFamily = Poppins,
        fontSize = 14.sp,
        color = PrimaryTextColor,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = LocalTextStyle.current.copy(lineHeight = 10.sp)
    )

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
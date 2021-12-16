package com.cursodekotlin.introjetpack

import android.graphics.fonts.FontStyle
import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cursodekotlin.introjetpack.ui.theme.IntrojetpackTheme
import com.google.android.material.internal.FlowLayout
import com.makeramen.roundedimageview.RoundedImageView
import java.util.concurrent.Flow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           SimpleComposable()
        }
    }
}


@Composable
fun SimpleComposable(){
    val constraits = ConstraintSet {
        val backbutton = createRefFor("backbutton")
        val searchbutton = createRefFor( "searchbutton")
        val txttitle = createRefFor("txttitle")
        val profile = createRefFor("profile")
        val name = createRefFor("name")
        val floatinbutton = createRefFor("floatinbutton")
        val dashboardbutton = createRefFor("dashboardbutton")
        val databutton = createRefFor("databutton")
        val flow1 = createRefFor("flow1")
        val cardone = createRefFor("cardone")
        val cardtwo = createRefFor("cardtwo")

        constrain(backbutton){
            top.linkTo(parent.top, margin = 10.dp)
            start.linkTo(parent.start)
            width = Dimension.value(30.dp)
            height = Dimension.value(30.dp)

        }

        constrain(txttitle){
            top.linkTo(backbutton.top)
            start.linkTo(backbutton.end, margin = 20.dp)
            end.linkTo(searchbutton.start, margin = 20.dp)
            height = Dimension.wrapContent

        }

        constrain(searchbutton){
            top.linkTo(parent.top, margin = 10.dp)
            end.linkTo(parent.end)
            width = Dimension.value(30.dp)
            height = Dimension.value(30.dp)

        }

        constrain(profile){
            top.linkTo(txttitle.bottom, margin = 40.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }

        constrain(name){
            top.linkTo(profile.bottom, margin = 12.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            height = Dimension.wrapContent
            width = Dimension.wrapContent
        }

        constrain(floatinbutton){
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            height = Dimension.wrapContent
            width = Dimension.wrapContent
        }

        constrain(dashboardbutton){
            top.linkTo(floatinbutton.top)
            bottom.linkTo(floatinbutton.bottom)
            start.linkTo(parent.start, margin = 20.dp)
            width = Dimension.value(20.dp)
            height = Dimension.value(20.dp)
        }

        constrain(databutton){
            top.linkTo(floatinbutton.top)
            bottom.linkTo(floatinbutton.bottom)
            end.linkTo(parent.end, margin = 20.dp)
            width = Dimension.value(20.dp)
            height = Dimension.value(20.dp)
        }

        constrain(flow1){
            height = Dimension.wrapContent
            top.linkTo(name.bottom)
           // bottom.linkTo(floatinbutton.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

       }

        constrain(flow1){
            height = Dimension.wrapContent
            top.linkTo(name.bottom, margin = 15.dp)
            bottom.linkTo(floatinbutton.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }

        constrain(cardone){
            height = Dimension.wrapContent
        }



        constrain(cardtwo){
            height = Dimension.wrapContent
        }



    }
    ConstraintLayout(constraits, modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xff2c2e43)
        )
        .padding(12.dp)
       ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "",
            modifier = Modifier
            .layoutId("backbutton")
        )
        
        Text(modifier = Modifier
            .layoutId("txttitle"),
            textAlign = TextAlign.Center,
            text = "Mi cartera",
            style = TextStyle(fontSize = 20.sp,
                color = Color.White)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "",
            modifier = Modifier
                .layoutId("searchbutton")
        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("profile")
                .size(130.dp)
                .clip(CircleShape)
        )

        Text(modifier = Modifier
            .layoutId("name"),
            textAlign = TextAlign.Center,
            text = "Sasuke Uchiha",
            style = TextStyle(fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
                )
        )

        FloatingActionButton(
            onClick = {},
            modifier = Modifier.layoutId("floatinbutton"),
            backgroundColor = Color(0xff01CD98),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    tint = Color.White
                    )
            }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_dashboard),
            contentDescription = "",
            modifier = Modifier
                .layoutId("dashboardbutton")
        )

        Image(
            painter = painterResource(id = R.drawable.ic_data),
            contentDescription = "",
            modifier = Modifier
                .layoutId("databutton")
        )

        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .layoutId("flow1")) {
            Row() {
                Card(
                    backgroundColor = Color(0xff01CD98),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .layoutId("cardone")
                        .padding(16.dp)
                        .width(150.dp),
                    content = {
                        textoscard()
                    }
                )

                Card(
                    backgroundColor = Color(0xff5351FC),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .layoutId("cardtwo")
                        .padding(16.dp)
                        .width(150.dp),
                    content = {
                        textoscard()
                    }
                )
            }
            Row() {
                Card(
                    backgroundColor = Color(0xffE64000),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .layoutId("cardone")
                        .padding(16.dp)
                        .width(150.dp),
                    content = {
                        textoscard()
                    }
                )

                Card(
                    backgroundColor = Color(0xffF6B900),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .layoutId("cardtwo")
                        .padding(16.dp)
                        .width(150.dp),
                    content = {
                        textoscard()
                    }
                )
            }
        }



    }

}

@Composable
fun card(id: String){
    Card(
        backgroundColor = Color(0xff5351FC),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .layoutId("cardtwo")
            .padding(16.dp),
        content = {
            textoscard()
        }
    )
}

@Composable
fun textoscard(){
    Column (modifier = Modifier.padding(16.dp)){
        Text(text = "EUR", 
            modifier = Modifier
                .wrapContentHeight(),
            style = TextStyle(
                color = Color.White,
                fontSize = 13.sp
            )
            )
        Text(text = "192,42", 
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 4.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White))
        Text(text = "Savings",
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 16.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 13.sp
            ))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SimpleComposable()
}


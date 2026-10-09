package com.example.scroll

import androidx.compose.foundation.lazy.items
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scroll.ui.theme.ScrollTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import kotlinx.serialization.descriptors.SerialDescriptor

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai

        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "NIKUUUUU!!!",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai
        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "Orewa kaizoukioni ",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai

        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "NIKUUUUU!!!",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai
        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "Orewa kaizoukioni ",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai

        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "NIKUUUUU!!!",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai
        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "Orewa kaizoukioni ",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai

        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "NIKUUUUU!!!",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
        Message(
            "Ibai",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim(),
            R.drawable.profile_ibai
        ),
        Message(
            "Reven",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim(),
            R.drawable.profile_lexi
        ),
        Message(
            "Luffy",
            "Orewa kaizoukioni ",
            R.drawable.profile_luffy
        ),
        Message(
            "Lexi",
            "Test...Test...Test...",
            R.drawable.profile_lexi
        ),
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { pintaTopBar() },
                    bottomBar = { pintaBottomBar() }
                ) {
                    innerPadding ->
                    Box (modifier = Modifier.padding(innerPadding))
                    {Conversation(
                        messages = SampleData.conversationSample
                    )
                    }

                }
            }
        }
    }
}


@Composable
fun pintaTopBar() {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(vertical = 30.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF189808))
            .padding(
                start = 37.dp,
                end = 37.dp,
                top = 18.dp,
                bottom = 18.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                tint = Color.White,
                imageVector = Icons.Default.Whatsapp,
                contentDescription = "Usuario"
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                color = Color.White,
                text = "Whatsapp",
                fontSize = 20.sp,
            )
        }
    }

}



@Composable
fun pintaBottomBar() {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(vertical = 30.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF2D382D))
            .padding(
                start = 37.dp,
                end = 37.dp,
                top = 18.dp,
                bottom = 18.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                tint = Color.White,
                imageVector = Icons.Default.Settings,
                contentDescription = "Usuario"
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                color = Color.White,
                text = "Configuración",
                fontSize = 20.sp,
            )
        }
    }
}

data class Message(val author: String, val body: String, @DrawableRes val profileImageRes: Int)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            // Usas el recurso correspondiente a este mensaje
            painter = painterResource(msg.profileImageRes),
            contentDescription = "Foto de perfil de ${msg.author}",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(true) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!", R.drawable.profile_lexi)
            )
        }
    }
}

@Composable
fun ComposeTutorialTheme(content: @Composable () -> Unit) {
    ScrollTheme(content = content)
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}


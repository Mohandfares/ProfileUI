package com.example.profileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileui.ui.theme.ProfileUITheme


@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "faresmohand_official     ",modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(5.dp))
        ButtonSection(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp))
        Spacer(modifier = Modifier.height(5.dp))
        HighlightSection(
            highlights = listOf(
                StoryHighlight(painterResource(id = R.drawable.livre),"Kitabe"),
                StoryHighlight(painterResource(id = R.drawable.powerbuildingv1),"building v1"),
                StoryHighlight(painterResource(id = R.drawable.powerbuildingv2),"building v2"),
                StoryHighlight(painterResource(id = R.drawable.powerbuildingv3),"building v3"),
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color.Black,
            modifier = Modifier.size(24.dp),
            contentDescription = "Back"
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.TwoTone.Notifications,
            tint = Color.Black,
            modifier = Modifier.size(24.dp),
            contentDescription = ""
        )
        Icon(
            imageVector = Icons.Filled.MoreVert,
            tint = Color.Black,
            modifier = Modifier.size(24.dp),
            contentDescription = ""
        )
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.fares),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(10f))
        }
        ProfileDescription(
            displayName = "فارس محند",
            description = "#T ❤\n" +
                    "\uD83D\uDCBB☕\n" +
                    "software engineer\n" +
                    "Programmer, Mobile Developer (Java Kotlin Android)\n" +
                    "M'y life -> programming, books, sport, music (RAP)",
            url = "https://www.facebook.com/fares.mohand.9/",
            followedBy = listOf("tourisme_const","Sofiane Merad"),
            otherCount = 213
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "50", text = "Publicat...")
        ProfileStat(numberText = "215", text = "Abonnés")
        ProfileStat(numberText = "548", text = "Abonnem...")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = buildAnnotatedString {
                val hashTagStyle = SpanStyle(
                    color = Color(0xFF3B5998),
                    fontWeight = FontWeight.Bold
                )
                val descriptionArray = description.split(" ")
                descriptionArray.forEach { s ->
                    if (s.startsWith("#")) {
                        pushStyle(hashTagStyle)
                        append(s)
                        pop()
                    } else {
                        append(" $s")
                    }
                }
            },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 13.sp
        )
        Text(
            text = url,
            color = Color(0xFF3B5998),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("suivi par ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" et ")
                        pushStyle(boldStyle)
                        append("$otherCount autres")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        ActionButton(
            imageVector = Icons.Default.KeyboardArrowDown,
            text = "Modifier profil",
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    imageVector: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[index].image,
                    modifier = Modifier.size(70.dp).clip(CircleShape)
                )
                Text(
                    text = highlights[index].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
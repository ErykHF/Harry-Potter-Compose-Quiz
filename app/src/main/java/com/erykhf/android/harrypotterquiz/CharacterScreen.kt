package com.erykhf.android.harrypotterquiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun CharacterScreen(viewModel: MainViewModel = hiltViewModel(), navController: NavController) {

    val character by remember { viewModel.character }
    val currentImgUrl by remember { viewModel.image }



    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            shape = RoundedCornerShape(32.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = character,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(8.dp),
                    fontFamily = FontFamily.Default,
                    fontSize = 19.sp
                )

                Image(
                    painter = rememberImagePainter(data = currentImgUrl),
                    contentDescription = "stringResource(R.string.description)",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
    }

}
package com.example.firebasechat.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.firebasechat.model.MainViewModel


@Composable
fun ChatListScreen(viewModel: MainViewModel) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(viewModel.users.value){ user->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3D7F3))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text(text = user.name)
            }
        }
    }

    if (viewModel.isLoad.value) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
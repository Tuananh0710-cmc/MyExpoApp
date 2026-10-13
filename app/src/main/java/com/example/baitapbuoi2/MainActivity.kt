package com.example.baitapbuoi2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitapbuoi2.ui.theme.Baitapbuoi2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Baitapbuoi2Theme {
                MainApp()
            }
        }
    }
}

enum class AppScreen {
    SCREEN_1,
    SCREEN_2
}

@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf(AppScreen.SCREEN_1) }
    var userName by remember { mutableStateOf("") }
    var mssv by remember { mutableStateOf("") }

    when (currentScreen) {
        AppScreen.SCREEN_1 -> {
            Screen1(
                initialUserName = userName,
                initialMssv = mssv,
                onNavigateToScreen2 = { inputUserName, inputMssv ->
                    userName = inputUserName
                    mssv = inputMssv
                    currentScreen = AppScreen.SCREEN_2
                }
            )
        }
        AppScreen.SCREEN_2 -> {
            Screen2(
                userName = userName,
                mssv = mssv,
                onBackToScreen1 = {
                    currentScreen = AppScreen.SCREEN_1
                }
            )
        }
    }
}

@Composable
fun Screen1(
    initialUserName: String,
    initialMssv: String,
    onNavigateToScreen2: (String, String) -> Unit
) {
    var userName by remember { mutableStateOf(initialUserName) }
    var mssv by remember { mutableStateOf(initialMssv) }
    var userNameError by remember { mutableStateOf<String?>(null) }
    var mssvError by remember { mutableStateOf<String?>(null) }

    fun validateAndSubmit() {
        var isValid = true
        if (userName.trim().isEmpty()) {
            userNameError = "UserName không được để trống"
            isValid = false
        } else {
            userNameError = null
        }

        if (mssv.trim().isEmpty()) {
            mssvError = "MSSV không được để trống"
            isValid = false
        } else {
            mssvError = null
        }

        if (isValid) {
            onNavigateToScreen2(userName.trim(), mssv.trim())
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Numbered Colored Blocks UI from Screenshot
                // Block 1 (Blue)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFF2B78E4)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Block 2 (Red)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFEC3832)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "2",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Middle Row: Block 3 (Yellow), Block 4 (Green), Block 5 (Purple)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Block 3 (Yellow)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFF1C40F)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "3",
                            color = Color.Black,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Block 4 (Green)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF27AE60)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "4",
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Block 5 (Purple)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF8E44AD)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "5",
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Block 6 (Orange)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFE67E22)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "6",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Input Fields with Validation (Placed below colored boxes)
                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                        if (it.isNotBlank()) userNameError = null
                    },
                    label = { Text("UserName") },
                    isError = userNameError != null,
                    supportingText = {
                        userNameError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = mssv,
                    onValueChange = {
                        mssv = it
                        if (it.isNotBlank()) mssvError = null
                    },
                    label = { Text("MSSV") },
                    isError = mssvError != null,
                    supportingText = {
                        mssvError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bottom Section: Click me button & Student Info
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = { validateAndSubmit() },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(text = "Click me", fontSize = 16.sp)
                }

                Text(
                    text = if (userName.isNotBlank() && mssv.isNotBlank()) "$userName - $mssv" else "Họ và tên - MSSV",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun BlackArrowIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(24.dp)) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(width * 0.75f, height * 0.5f)
            lineTo(width * 0.25f, height * 0.5f)
            moveTo(width * 0.45f, height * 0.25f)
            lineTo(width * 0.25f, height * 0.5f)
            lineTo(width * 0.45f, height * 0.75f)
        }
        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(
    userName: String,
    mssv: String,
    onBackToScreen1: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Screen 2") },
                navigationIcon = {
                    IconButton(onClick = onBackToScreen1) {
                        BlackArrowIcon()
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Thông Tin Nhận Được",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "UserName: $userName",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "MSSV: $mssv",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Họ và tên - MSSV: $userName - $mssv",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF27AE60)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen1Preview() {
    Baitapbuoi2Theme {
        Screen1(initialUserName = "Pham Tuan Anh", initialMssv = "12345678", onNavigateToScreen2 = { _, _ -> })
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    Baitapbuoi2Theme {
        Screen2(userName = "Pham Tuan Anh", mssv = "12345678", onBackToScreen1 = {})
    }
}

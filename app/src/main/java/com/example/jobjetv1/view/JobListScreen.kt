package com.example.jobjetv1.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class JobListing(
    val companyName: String,
    val location: String,
    val description: String,
    val salary: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobListScreen(navController: NavController) {
    val jobListings = listOf(
        JobListing(
            "Out Layer",
            "Địa chỉ: Global City Quận 9",
            "Mô tả: Setup, điều chỉnh sản khẩu.",
            "50,000 VND/Giờ"
        ),
        JobListing(
            "Kho Shoppe",
            "Địa chỉ: 22/14 Phan Huy Ích, P14, Gò Vấp",
            "Mô tả: Phân loại bưu kiện, sắp xếp hàng hóa.",
            "31,250 VND/Giờ"
        ),
        JobListing(
            "Kho Shoppe",
            "Địa chỉ: 618/1B Âu cơ, P10, Tân Bình",
            "Mô tả: Phân loại bưu kiện, sắp xếp hàng hóa.",
            "31,250 VND/Giờ"
        ),
        JobListing(
            "Nhà hàng",
            "Địa chỉ: 202 Hoàng Văn Thụ, Phú Nhuận",
            "Mô tả: Phân loại bưu kiện, sắp xếp hàng hóa.",
            "25,000 VND/Giờ"
        ),
        JobListing(
            "Kho Shoppe",
            "Địa chỉ: 123 Nguyễn Hữu Tiến, Tân Phú",
            "Mô tả: Phân loại bưu kiện, sắp xếp hàng hóa.",
            "31,250 VND/Giờ"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "JobJet",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0047AB)
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Trang chủ") },
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Message, contentDescription = "Messages") },
                    label = { Text("Tin nhắn") },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Notifications, contentDescription = "Notifications") },
                    label = { Text("Thông báo") },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Menu") },
                    label = { Text("Menu") },
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(jobListings) { job ->
                JobCard(job)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobCard(job: JobListing) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = job.companyName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = job.location,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = job.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = job.salary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0047AB)
                )
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF4500)
                    )
                ) {
                    Text("Đăng Kí")
                }
            }
        }
    }
}

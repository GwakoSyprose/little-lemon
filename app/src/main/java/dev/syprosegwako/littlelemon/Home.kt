package dev.syprosegwako.littlelemon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Text(text = "Home screen")

}

@Preview(backgroundColor = 1, showBackground = true)
@Composable
fun HomePreview(){
    //Home(navController)
}
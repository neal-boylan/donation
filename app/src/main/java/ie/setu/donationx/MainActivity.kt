package ie.setu.donationx

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ie.setu.donationx.data.DonationModel
import ie.setu.donationx.navigation.NavHostProvider
import ie.setu.donationx.navigation.Report
import ie.setu.donationx.navigation.allDestinations
import ie.setu.donationx.ui.components.general.BottomAppBarProvider
import ie.setu.donationx.ui.components.general.MenuItem
import ie.setu.donationx.ui.components.general.TopAppBarProvider
import ie.setu.donationx.ui.screens.ScreenDonate
import ie.setu.donationx.ui.screens.ScreenReport
import ie.setu.donationx.ui.theme.DonationXTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DonationXTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DonationXApp(modifier = Modifier)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonationXApp(modifier: Modifier = Modifier,
                 navController: NavHostController = rememberNavController()) {
    val donations = remember { mutableStateListOf<DonationModel>() }
    // var selectedMenuItem by remember { mutableStateOf<MenuItem?>(MenuItem.Donate) }
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentNavBackStackEntry?.destination
    val currentBottomScreen = allDestinations.find { it.route == currentDestination?.route } ?: Report

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarProvider(
                currentScreen = currentBottomScreen,
                canNavigateBack = navController.previousBackStackEntry != null
            ) { navController.navigateUp() } },
        content = { paddingValues ->
            NavHostProvider(
                modifier = modifier,
                navController = navController,
                paddingValues = paddingValues,
                donations = donations)
        },
        bottomBar = {
            BottomAppBarProvider(navController,
                currentScreen = currentBottomScreen,)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    DonationXTheme {
        DonationXApp(modifier = Modifier)
    }
}
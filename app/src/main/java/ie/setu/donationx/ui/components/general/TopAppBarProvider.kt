package ie.setu.donationx.ui.components.general

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.donationx.R
import ie.setu.donationx.navigation.AppDestination
import ie.setu.donationx.navigation.Donate
import ie.setu.donationx.ui.theme.DonationXTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarProvider(currentScreen: AppDestination)
{
    TopAppBar(
        title = {
            Text(
                text = currentScreen.label,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu Button",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        },
        actions = { }
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    DonationXTheme {
        TopAppBarProvider(Donate)
    }
}
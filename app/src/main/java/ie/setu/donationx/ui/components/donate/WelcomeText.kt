package ie.setu.donationx.ui.components.donate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.donationx.R
import ie.setu.donationx.ui.theme.DonationXTheme

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            top = 24.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = stringResource(R.string.donateTitle),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Black
        )
        Text(
            text = stringResource(R.string.donateSubtitle),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    DonationXTheme {
        WelcomeText()
    }
}
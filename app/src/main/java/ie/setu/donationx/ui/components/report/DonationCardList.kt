package ie.setu.donationx.ui.components.report

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ie.setu.donationx.data.DonationModel
import ie.setu.donationx.data.fakeDonations
import ie.setu.donationx.ui.theme.DonationXTheme
import java.text.DateFormat

@Composable
internal fun DonationCardList(
    donations: SnapshotStateList<DonationModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = donations,
            key = { donation -> donation.id }
        ) { donation ->
            DonationCard(
                paymentType = donation.paymentType,
                paymentAmount = donation.paymentAmount,
                message = donation.message,
                dateCreated = DateFormat.getDateTimeInstance().format(donation.dateDonated),
            )
        }
    }
}

@Preview(showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
@Composable
fun DonationCardListPreview() {
    DonationXTheme {
        DonationCardList(fakeDonations.toMutableStateList())
    }
}
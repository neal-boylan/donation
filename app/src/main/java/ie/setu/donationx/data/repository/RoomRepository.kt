package ie.setu.donationx.data.repository

import ie.setu.donationx.data.DonationModel
import ie.setu.donationx.data.room.DonationDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepository @Inject
constructor(private val donationDAO: DonationDAO) {
    fun getAll(): Flow<List<DonationModel>>
            = donationDAO.getAll()

    suspend fun insert(donation: DonationModel)
    { donationDAO.insert(donation) }

    suspend fun update(donation: DonationModel)
    { donationDAO.update(donation) }

    suspend fun delete(donation: DonationModel)
    { donationDAO.delete(donation) }
}
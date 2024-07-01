package app.shapeshifter.common.ui.compose.screens

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateWorkoutPlanScreen(
    val planName: String,
    val routineId: Long,
) : Screen
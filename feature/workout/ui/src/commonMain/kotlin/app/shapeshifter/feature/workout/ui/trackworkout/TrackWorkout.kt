package app.shapeshifter.feature.workout.ui.trackworkout

import android.graphics.Paint.Align
import android.graphics.Paint.Style
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.shapeshifter.common.ui.compose.screens.TrackWorkoutScreen
import app.shapeshifter.feature.workout.ui.components.WorkoutExercise
import app.shapeshifter.feature.workout.ui.components.sampleWorkoutExercise
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import me.tatarka.inject.annotations.Inject
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import shapeshifter.feature.workout.ui.generated.resources.Res
import shapeshifter.feature.workout.ui.generated.resources.ic_dumbbell_workout
import java.util.Timer

@Inject
class TrackWorkoutUiFactory : Ui.Factory {
    override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
        return when (screen) {
            is TrackWorkoutScreen -> ui<TrackWorkoutUiState> { state, modifier ->
                TrackWorkout(state)
            }

            else -> null
        }
    }
}

@Composable
private fun TrackWorkout(
    state: TrackWorkoutUiState,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {
            TrackWorkoutTopBar(
                modifier = Modifier
                    .fillMaxWidth(),
                onBack = {
                    state.eventSink(TrackWorkoutUiEvent.GoBack)
                },
            )

            Divider(thickness = 2.dp)

            Spacer(
                modifier = Modifier
                    .padding(vertical = 8.dp),
            )

            ExerciseLog(
                modifier = Modifier
                    .fillMaxWidth(),
                onAddExercise = {
                    state.eventSink(TrackWorkoutUiEvent.OnAddExercise)
                },
            )
            WorkoutExercise(
                workoutExercise = sampleWorkoutExercise,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
private fun TrackWorkoutTopBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
) {
    Row(
        modifier = modifier
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {
                onBack()
            },
            modifier = Modifier,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                modifier = Modifier
                    .size(32.dp),
                contentDescription = "",
            )
        }

        Text(
            "Track Workout",
            modifier = Modifier
                .weight(1F),
        )

        Button(
            onClick = {
                onBack()
            },
            shape = CutCornerShape(
                topStart = 16.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp,
            ),
        ) {
            Text("Finish")
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ExerciseLog(
    modifier: Modifier = Modifier,
    onAddExercise: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_dumbbell_workout),
            "",
            modifier = Modifier,
        )

        Text(
            style = TextStyle(fontWeight = FontWeight.Bold),
            text = "Get Started",
        )

        Spacer(
            modifier = Modifier
                .padding(8.dp),
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onAddExercise()
            },
        ) {
            Text("+ Add Exercise")
        }
    }
}
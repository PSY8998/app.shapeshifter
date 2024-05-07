package app.shapeshifter.feature.workout.domain

import app.shapeshifter.core.base.inject.AppCoroutineDispatchers
import app.shapeshifter.data.db.daos.WorkoutEntityDao
import app.shapeshifter.data.models.workout.Workout
import app.shapeshifter.domain.UseCase
import me.tatarka.inject.annotations.Inject
import kotlinx.coroutines.withContext

@Inject
class CreateWorkoutUseCase(
    private val workoutEntityDao: WorkoutEntityDao,
    private val dispatchers: AppCoroutineDispatchers,
) : UseCase<Unit, Long>() {
    override suspend fun doWork(params: Unit): Long {
        return withContext(dispatchers.databaseRead) {
            val workout = workoutEntityDao.unfinishedWorkout()

            // TODO: the check should throw error as the use case should only create workout
            if (workout != null) {
                return@withContext workout.id
            }

            withContext(dispatchers.databaseWrite) {
                workoutEntityDao.insert(Workout.emptyQuickWorkout())
            }
        }
    }
}
package dev.mexware.stresswatch.data

import dev.mexware.stresswatch.feature.auth.model.Gender
import dev.mexware.stresswatch.feature.home.model.events.HomeUiState
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailUiState
import dev.mexware.stresswatch.feature.sensors.model.timeseries.Summary
import dev.mexware.stresswatch.feature.sensors.model.timeseries.TimePoint

object SampleProfilesRepository : ProfilesRepository {

    data class Profile(
        val email: String,
        val password: String,
        val home: HomeUiState,
        val sensors: Map<SensorType, SensorDetailUiState>
    )

    private val profiles = listOf(
        Profile(
            email = "ana@example.com",
            password = "ana123",
            home = HomeUiState(
                name = "Ana",
                gender = Gender.FEMALE,
                birthDate = "12/05/1995",
                country = "México",
                avatarId = 1
            ),
            sensors = mapOf(
                SensorType.STRESS to SensorDetailUiState(
                    type = SensorType.STRESS,
                    points = listOf(
                        TimePoint("L", 30f),
                        TimePoint("M", 40f),
                        TimePoint("X", 35f),
                        TimePoint("J", 50f),
                        TimePoint("V", 45f),
                        TimePoint("S", 60f),
                        TimePoint("D", 55f)
                    ),
                    summary = Summary(
                        totalLabel = "Estrés actual",
                        totalValue = "55%",
                        note = "Estrés moderado"
                    )
                ),
                SensorType.SLEEP to SensorDetailUiState(
                    type = SensorType.SLEEP,
                    points = listOf(
                        TimePoint("L", 80f),
                        TimePoint("M", 82f),
                        TimePoint("X", 78f),
                        TimePoint("J", 75f),
                        TimePoint("V", 90f),
                        TimePoint("S", 85f),
                        TimePoint("D", 88f)
                    ),
                    summary = Summary(
                        totalLabel = "Sueño total",
                        totalValue = "88%",
                        note = "Buen descanso esta semana"
                    )
                ),
                SensorType.MOOD to SensorDetailUiState(
                    type = SensorType.MOOD,
                    points = listOf(
                        TimePoint("L", 70f),
                        TimePoint("M", 68f),
                        TimePoint("X", 72f),
                        TimePoint("J", 75f),
                        TimePoint("V", 65f),
                        TimePoint("S", 60f),
                        TimePoint("D", 70f)
                    ),
                    summary = Summary(
                        totalLabel = "Ánimo actual",
                        totalValue = "70%",
                        note = "Mejor que la semana pasada"
                    )
                )
            )
        ),
        Profile(
            email = "luis@example.com",
            password = "luis123",
            home = HomeUiState(
                name = "Luis",
                gender = Gender.MALE,
                birthDate = "03/11/1990",
                country = "España",
                avatarId = 2
            ),
            sensors = mapOf(
                SensorType.STRESS to SensorDetailUiState(
                    type = SensorType.STRESS,
                    points = listOf(
                        TimePoint("L", 60f),
                        TimePoint("M", 62f),
                        TimePoint("X", 58f),
                        TimePoint("J", 65f),
                        TimePoint("V", 70f),
                        TimePoint("S", 75f),
                        TimePoint("D", 72f)
                    ),
                    summary = Summary(
                        totalLabel = "Estrés actual",
                        totalValue = "72%",
                        note = "Estrés alto"
                    )
                ),
                SensorType.SLEEP to SensorDetailUiState(
                    type = SensorType.SLEEP,
                    points = listOf(
                        TimePoint("L", 55f),
                        TimePoint("M", 60f),
                        TimePoint("X", 50f),
                        TimePoint("J", 45f),
                        TimePoint("V", 65f),
                        TimePoint("S", 70f),
                        TimePoint("D", 60f)
                    ),
                    summary = Summary(
                        totalLabel = "Sueño total",
                        totalValue = "60%",
                        note = "Intenta mejorar tu rutina nocturna"
                    )
                ),
                SensorType.MOOD to SensorDetailUiState(
                    type = SensorType.MOOD,
                    points = listOf(
                        TimePoint("L", 40f),
                        TimePoint("M", 45f),
                        TimePoint("X", 50f),
                        TimePoint("J", 48f),
                        TimePoint("V", 52f),
                        TimePoint("S", 55f),
                        TimePoint("D", 50f)
                    ),
                    summary = Summary(
                        totalLabel = "Ánimo actual",
                        totalValue = "50%",
                        note = "Podrías intentar una sesión de respiración"
                    )
                )
            )
        ),
        Profile(
            email = "carla@example.com",
            password = "carla123",
            home = HomeUiState(
                name = "Carla",
                gender = Gender.FEMALE,
                birthDate = "22/08/1988",
                country = "Argentina",
                avatarId = 3
            ),
            sensors = mapOf(
                SensorType.STRESS to SensorDetailUiState(
                    type = SensorType.STRESS,
                    points = listOf(
                        TimePoint("L", 20f),
                        TimePoint("M", 25f),
                        TimePoint("X", 30f),
                        TimePoint("J", 28f),
                        TimePoint("V", 22f),
                        TimePoint("S", 18f),
                        TimePoint("D", 20f)
                    ),
                    summary = Summary(
                        totalLabel = "Estrés actual",
                        totalValue = "20%",
                        note = "Estrés bajo"
                    )
                ),
                SensorType.SLEEP to SensorDetailUiState(
                    type = SensorType.SLEEP,
                    points = listOf(
                        TimePoint("L", 90f),
                        TimePoint("M", 92f),
                        TimePoint("X", 88f),
                        TimePoint("J", 95f),
                        TimePoint("V", 94f),
                        TimePoint("S", 96f),
                        TimePoint("D", 93f)
                    ),
                    summary = Summary(
                        totalLabel = "Sueño total",
                        totalValue = "93%",
                        note = "Buen descanso esta semana"
                    )
                ),
                SensorType.MOOD to SensorDetailUiState(
                    type = SensorType.MOOD,
                    points = listOf(
                        TimePoint("L", 85f),
                        TimePoint("M", 82f),
                        TimePoint("X", 80f),
                        TimePoint("J", 88f),
                        TimePoint("V", 86f),
                        TimePoint("S", 84f),
                        TimePoint("D", 87f)
                    ),
                    summary = Summary(
                        totalLabel = "Ánimo actual",
                        totalValue = "87%",
                        note = "Mejor que la semana pasada"
                    )
                )
            )
        )
    )

    private var currentIndex = 0

    override fun selectProfile(index: Int) {
        currentIndex = index.coerceIn(profiles.indices)
    }

    override fun login(email: String, password: String): Boolean {
        val idx = profiles.indexOfFirst { it.email == email && it.password == password }
        return if (idx >= 0) {
            currentIndex = idx
            true
        } else {
            false
        }
    }

    override fun currentHomeUiState(): HomeUiState = profiles[currentIndex].home

    override fun sensorData(type: SensorType): SensorDetailUiState =
        profiles[currentIndex].sensors[type] ?: SensorDetailUiState(type)
}


package dev.mexware.stresswatch.feature.sensors.model

sealed class SensorsRoute(val route: String) {
    data object Dashboard : SensorsRoute("sensors_dashboard")
    data object Detail : SensorsRoute("sensors_detail/{type}")
    companion object { fun detailOf(type: SensorType) = "sensors_detail/${type.name}" }
}
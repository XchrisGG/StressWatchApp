package dev.mexware.stresswatch.feature.auth.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.mexware.stresswatch.R
import dev.mexware.stresswatch.feature.auth.model.RegisterStep
import dev.mexware.stresswatch.feature.auth.model.events.RegisterEvent
import dev.mexware.stresswatch.feature.auth.viewmodel.RegisterViewModel
import dev.mexware.stresswatch.feature.auth.view.components.RegisterNavBar
import dev.mexware.stresswatch.feature.auth.view.components.RegisterLogoHeader

@Composable
fun RegisterScreen(
    navController: NavHostController,
    vm: RegisterViewModel = viewModel()
) {
    val state = vm.uiState
    val isLastStep = state.step == RegisterStep.PROFILE

    Scaffold(
        topBar = {
            RegisterLogoHeader(logoRes = R.drawable.logo_stress)
        },
        bottomBar = {
            RegisterNavBar(
                onBack = { vm.onEvent(RegisterEvent.Back) },
                onNext = {
                    if (isLastStep) vm.onEvent(RegisterEvent.Submit)
                    else vm.onEvent(RegisterEvent.Next)
                },
                canGoBack = state.step != RegisterStep.DISCLAIMER,
                canGoNext = state.isStepValid, // esto ya respeta el checkbox del disclaimer
                isBusy = state.isSubmitting,
                nextText = if (isLastStep) "Finalizar" else "Siguiente"
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (state.step) {
                RegisterStep.DISCLAIMER ->
                    StepDisclaimer(
                        accepted = state.disclaimerAccepted,
                        onAcceptedChange = { vm.onEvent(RegisterEvent.DisclaimerAcceptedChanged(it)) }
                    )

                RegisterStep.NAME ->
                    StepName(
                        value = state.data.name,
                        error = state.fieldErrors["name"],
                        onChange = { vm.onEvent(RegisterEvent.NameChanged(it)) }
                    )

                RegisterStep.GENDER ->
                    StepGender(
                        selected = state.data.gender,
                        name = state.data.name,                 // <- saludo dinámico
                        error = state.fieldErrors["gender"],
                        onSelect = { vm.onEvent(RegisterEvent.GenderSelected(it)) }
                    )

                RegisterStep.PROFILE ->
                    StepProfile(
                        birthDate = state.data.birthDate,
                        country = state.data.country,
                        avatarId = state.data.avatarId,
                        errors = mapOf(
                            "birthDate" to (state.fieldErrors["birthDate"] ?: ""),
                            "country" to (state.fieldErrors["country"] ?: "")
                        ),
                        onBirthDate = { vm.onEvent(RegisterEvent.BirthDateChanged(it)) },
                        onCountry = { vm.onEvent(RegisterEvent.CountryChanged(it)) },
                        onAvatar = { vm.onEvent(RegisterEvent.AvatarSelected(it)) }
                    )
            }
        }
    }
}
package dev.mexware.stresswatch.feature.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.mexware.stresswatch.components.ui.AppTextField
import dev.mexware.stresswatch.components.ui.PrimaryButton
import dev.mexware.stresswatch.feature.auth.model.events.LoginEvent
import dev.mexware.stresswatch.feature.auth.view.components.AuthPasswordField
import dev.mexware.stresswatch.feature.auth.viewmodel.LoginViewModel
import dev.mexware.stresswatch.ui.theme.StressDarkBlue
import dev.mexware.stresswatch.ui.theme.StressWhite



import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit = {},
    navigateToRegister: () -> Unit = {},
    navigateToForgot: () -> Unit = {},
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.uiState
    val snackHost = remember { SnackbarHostState() }

    // Navega cuando el login sea exitoso
    LaunchedEffect(state.isLoggedIn) {
        if (state.isLoggedIn) navigateToHome()
    }

    // Muestra error global como snackbar
    LaunchedEffect(state.loginError) {
        state.loginError?.let { snackHost.showSnackbar(it) }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackHost) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(StressDarkBlue)
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // ===== LOGO (coloca tu recurso cuando lo tengas) =====
                // Reemplaza R.drawable.logo_stresswatch por el nombre real del asset
                Spacer(Modifier.height(16.dp))
               /* Image(
                    painter = painterResource(id = R.drawable.logo_stresswatch),
                    contentDescription = "StressWatch",
                    modifier = Modifier
                        .size(140.dp)
                        .padding(bottom = 12.dp),
                    contentScale = ContentScale.Fit
                )*/

                // Título opcional (según Figma usas textos claros)
                Text(
                    text = "Iniciar sesión",
                    color = StressWhite,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )

                // ===== EMAIL =====
                AppTextField(
                    value = state.email,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnEmailChanged(it)) },
                    label = "Correo electrónico",
                    errorText = state.emailError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                // ===== PASSWORD (componente local del feature con toggle) =====
                AuthPasswordField(
                    value = state.password,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnPasswordChanged(it)) },
                    isVisible = state.isPasswordVisible,
                    onToggleVisibility = { viewModel.onEvent(LoginEvent.TogglePasswordVisibility) },
                    errorText = state.passwordError,
                    imeAction = ImeAction.Done,
                    onImeAction = { viewModel.onEvent(LoginEvent.Submit) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(20.dp))

                // ===== BOTÓN ENTRAR (mint, pill) =====
                PrimaryButton(
                    text = "Iniciar sesión",
                    onClick = { viewModel.onEvent(LoginEvent.Submit) },
                    enabled = !state.isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                )

                Spacer(Modifier.height(12.dp))

                // ===== Enlaces secundarios =====
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Crear una cuenta",
                        color = StressWhite,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .noRippleClickable { navigateToRegister() }
                    )
                    Text(
                        text = "¿Olvidaste tu contraseña?",
                        color = StressWhite,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .noRippleClickable { navigateToForgot() }
                    )
                }
            }

            // Overlay de carga (aparece sobre todo)
        }
    }
}

/**
 * Helper para clickable sin ripple (coincide con look de enlaces en tu Figma).
 */



@Composable
private fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier =
    this.then(
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    )

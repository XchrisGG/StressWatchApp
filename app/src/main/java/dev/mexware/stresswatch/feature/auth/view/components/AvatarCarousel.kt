package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Carrusel de avatares con estilo fijo.
 * Por ahora usa un ícono de persona como placeholder.
 * Cuando tengas drawables reales, puedes cambiar el contenido interno.
 */
@Composable
fun AvatarCarousel(
    selectedId: Int?,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    // Lista emulada de IDs (1..6). Si luego recibes desde BD, pásalos aquí.
    items: List<Int> = (1..6).toList(),
    itemSizeDp: Int = 56
) {
    val bubble = Color(0xFF8ED1C2)           // círculo base
    val bubbleSelected = Color(0xFF5FBCA7)   // seleccionado
    val iconColor = Color(0xFF0D0D0D)

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 0.dp)
    ) {
        items(items) { id ->
            val isSelected = id == selectedId
            Surface(
                shape = CircleShape,
                color = if (isSelected) bubbleSelected else bubble,
                modifier = Modifier
                    .size(itemSizeDp.dp)
                    .shadow(if (isSelected) 6.dp else 0.dp, CircleShape)
                    .clickable { onSelect(id) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Avatar $id",
                    tint = iconColor
                )
            }
        }
    }
}
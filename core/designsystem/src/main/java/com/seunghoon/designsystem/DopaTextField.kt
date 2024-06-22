package com.seunghoon.designsystem

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.designsystem.ui.theme.Typography

@Composable
internal fun DopaTextField(
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    val hintAlpha by animateFloatAsState(
        targetValue = if (value.isEmpty()) 1f
        else 0f,
        label = "",
    )

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = Color(0x22000000),
                shape = RoundedCornerShape(10.dp),
            )
            .padding(
                vertical = 20.dp,
                horizontal = 22.dp,
            ),
        value = value,
        onValueChange = onValueChange,
    ) { innerTextField ->
        innerTextField()
        if (value.isEmpty()) {
            Text(
                modifier = Modifier.alpha(hintAlpha),
                text = hint,
                color = Color(0x40000000),
                style = Typography.Medium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DopaTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    DopaTextField(
        value = value,
        onValueChange = { string -> value = string },
        hint = "아이디 또는 이메일"
    )
}

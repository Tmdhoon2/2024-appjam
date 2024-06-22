package com.seunghoon.designsystem.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.seunghoon.core.designsystem.R

// 디자인에 맞는 폰트 추가해서 사용
private val fontFamily = FontFamily(listOf(Font(R.font.nanum_square_r)))

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

// 이름 변경해서 사용
object Typography {
    /*val HeadLine = TextStyle(
        fontFamily = FontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )*/
    val Medium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 4.sp,
        platformStyle = platFormTextStyle,
    )
}

package com.yasserakbbach.borutoapp.presentation.components.rating

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yasserakbbach.borutoapp.R
import com.yasserakbbach.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.yasserakbbach.borutoapp.ui.theme.LightGray
import com.yasserakbbach.borutoapp.ui.theme.StarColor

@Composable
fun RatingWidget(
    modifier: Modifier = Modifier,
    rating: Double,
    scaleFactor: Float = 3F,
    spaceBetweenStars: Dp = EXTRA_SMALL_PADDING,
) {
    val ratingStarResults = calculateStars(rating = rating)
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenStars),
    ) {
        ratingStarResults.forEach { ratingStar ->
            when (ratingStar) {
                is RatingStar.Filled -> repeat(ratingStar.number) {
                    FilledStar(
                        starPath = starPath,
                        starPathBounds = starPathBounds,
                        scaleFactor = scaleFactor,
                    )
                }
                is RatingStar.HalfFilled -> repeat(ratingStar.number) {
                    HalfFilledStar(
                        starPath = starPath,
                        starPathBounds = starPathBounds,
                        scaleFactor = scaleFactor,
                    )
                }
                is RatingStar.Empty -> repeat(ratingStar.number) {
                    EmptyStar(
                        starPath = starPath,
                        starPathBounds = starPathBounds,
                        scaleFactor = scaleFactor,
                    )
                }
            }
        }
    }
}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float,
) {
    Canvas(
        modifier = Modifier.size(24.dp),
    ) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = canvasSize.width.div(2F) - pathWidth.div(1.7F)
            val top = canvasSize.height.div(2F) - pathHeight.div(1.7F)

            translate(
                top = top,
                left = left,
            ) {
                drawPath(
                    path = starPath,
                    color = StarColor,
                )
            }
        }
    }
}

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float,
) {
    Canvas(
        modifier = Modifier.size(24.dp),
    ) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = canvasSize.width.div(2F) - pathWidth.div(1.7F)
            val top = canvasSize.height.div(2F) - pathHeight.div(1.7F)

            translate(
                top = top,
                left = left,
            ) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = .5F),
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StarColor,
                        size = Size(
                            width = starPathBounds.maxDimension.div(1.7F),
                            height = starPathBounds.maxDimension.times(scaleFactor),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float,
) {
    Canvas(
        modifier = Modifier.size(24.dp),
    ) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = canvasSize.width.div(2F) - pathWidth.div(1.7F)
            val top = canvasSize.height.div(2F) - pathHeight.div(1.7F)

            translate(
                top = top,
                left = left,
            ) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = .5F),
                )
            }
        }
    }
}

@Composable
fun calculateStars(
    rating: Double,
): List<RatingStar> {
    val maxStars by remember { mutableStateOf(5) }
    var filledStars by remember { mutableStateOf(0) }
    var halfFilledStars by remember { mutableStateOf(0) }
    var emptyStars by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString().split(".").map { it.toInt() }
        if (firstNumber in 0..maxStars && lastNumber in 0..9) {
            filledStars = firstNumber
            if (lastNumber in 1..maxStars) halfFilledStars++
            if (lastNumber in 6..9) filledStars++
            if (firstNumber == maxStars && lastNumber > 0) {
                emptyStars = maxStars
                filledStars = 0
                halfFilledStars = 0
            }
        } else {
            Log.d("RatingWidget", "Invalid passed rating number $rating")
        }
    }
    emptyStars = maxStars - filledStars.plus(halfFilledStars)

    return listOf(
        RatingStar.Filled(filledStars),
        RatingStar.HalfFilled(halfFilledStars),
        RatingStar.Empty(emptyStars),
    )
}

@Preview(showBackground = true)
@Composable
fun FilledStarPreview() {
    RatingWidget(rating = 5.0)
}
/**
 * smoothScrollToItem.kt
 *
 * Author      : Amit Kundu
 * Created On  : 31/07/2026
 *
 * Description :
 * Part of the project codebase. This file contributes to the overall
 * functionality and follows standard coding practices and architecture.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.utilitis.ex_funcation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.LazyListState

/**
 * Smoothly scrolls to [index] over [durationMillis], compensating for a
 * sticky header of [headerOffsetPx] px. Distance is computed from
 * [itemHeights] (measured via onGloballyPositioned on every item), so it
 * works reliably even when the target isn't currently laid out.
 */
suspend fun LazyListState.smoothScrollToItem(
    index: Int,
    itemHeights: Map<Int, Int>,
    headerOffsetPx: Int,
    durationMillis: Int = 1200,
    easing: Easing = FastOutSlowInEasing
) {
    // absolute offset (px) of the top of item [target], from the top of content
    fun absoluteOffsetOf(target: Int): Int {
        var sum = 0
        for (i in 0 until target) sum += itemHeights[i] ?: 0
        return sum
    }

    val targetAbsolute = absoluteOffsetOf(index) - headerOffsetPx
    val currentAbsolute = absoluteOffsetOf(firstVisibleItemIndex) + firstVisibleItemScrollOffset
    val distance = (targetAbsolute - currentAbsolute).toFloat()

    if (distance == 0f) return

    var previousValue = 0f
    scroll {
        Animatable(0f).animateTo(
            targetValue = distance,
            animationSpec = tween(durationMillis = durationMillis, easing = easing)
        ) {
            val delta = value - previousValue
            scrollBy(delta)
            previousValue = value
        }
    }
}


suspend fun LazyListState.smoothScrollToItem(
    index: Int,
    headerOffsetPx: Int,
    durationMillis: Int = 1200
) {
    // First jump to the target so LazyColumn can compose it.
    scrollToItem(
        index = index,
        scrollOffset = -headerOffsetPx
    )

    // Now the target exists and LazyColumn knows its position.
    // Unfortunately, animateScrollToItem() does not expose
    // a custom duration in the public API.

    // Therefore, for Wasm, use the built-in animation.
    animateScrollToItem(
        index = index,
        scrollOffset = -headerOffsetPx
    )
}
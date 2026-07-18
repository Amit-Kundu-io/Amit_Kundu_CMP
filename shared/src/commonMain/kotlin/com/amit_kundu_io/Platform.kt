package com.amit_kundu_io

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
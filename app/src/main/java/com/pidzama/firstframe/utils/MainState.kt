package com.pidzama.firstframe.utils

import com.pidzama.firstframe.network.model.Docs

data class MainState(
    val isLoading: Boolean = false,
    val data: List<Docs> = emptyList(),
    val error: String = ""
)
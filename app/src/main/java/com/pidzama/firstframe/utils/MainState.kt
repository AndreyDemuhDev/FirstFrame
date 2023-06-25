package com.pidzama.firstframe.utils

import com.pidzama.firstframe.network.model.Doc

data class MainState(
    val isLoading: Boolean = false,
    val data: List<Doc> = emptyList(),
    val error: String = ""
)
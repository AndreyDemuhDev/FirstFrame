package com.pidzama.firstframe.utils

import com.pidzama.firstframe.network.model.search.Doc
import com.pidzama.firstframe.network.model.titles.Docs

data class MainState(
    val isLoading: Boolean = false,
    val data: List<Doc> = emptyList(),
    val error: String = ""
)
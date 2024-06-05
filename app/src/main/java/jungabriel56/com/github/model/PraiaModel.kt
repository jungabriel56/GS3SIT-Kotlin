package jungabriel56.com.github.model

data class PraiaModel(
    val name: String,
    val onRemove: (PraiaModel) -> Unit
)
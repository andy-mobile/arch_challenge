package com.example.coding.data.sources.api.dto

import androidx.annotation.Size

data class FilterPhotoDTO(
    val query: String,
    val lang: Lang? = null,
    val id: String? = null,
    val imageType: String? = null,
    val orientation: String? = null,
    val category: Category? = null,
    val minWidth: Int? = null,
    val minHeight: Int? = null,
    val colors: Colors? = null,
    val editorsChoice: Boolean = false,
    val safeSearch: Boolean = false,
    val order: Order? = null,
    val page: Int = 1,
    @Size(20, min = 3, max = 200)
    val perPage: Int? = null,
    val pretty: Boolean = false
) {
    enum class Colors {
        grayscale,
        transparent,
        red,
        orange,
        yellow,
        green,
        turquoise,
        blue,
        lilac,
        pink,
        white,
        gray,
        black,
        brown,
    }

    enum class Lang {
        cs, da, de, en, es, fr, id, it, hu, nl, no, pl, pt, ro, sk, fi, sv, tr, vi, th, bg, ru, el, ja, ko, zh
    }

    enum class Category {
        backgrounds, fashion, nature, science, education, feelings, health, people, religion, places, animals, industry, computer, food, sports, transportation, travel, buildings, business, music
    }

    enum class Order {
        popular, latest
    }
}

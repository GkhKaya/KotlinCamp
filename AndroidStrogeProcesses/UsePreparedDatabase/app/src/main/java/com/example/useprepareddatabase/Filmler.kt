package com.example.useprepareddatabase

data class Filmler(
    var film_id: Int,
    var film_Ad:String,
    val film_yil:Int,
    val film_resim:String,
    var kategori:Kategoriler,
    var yonetmenler: Yonetmenler) {
}
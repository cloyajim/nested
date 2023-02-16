package com.example.nestedrecyclerview

object FakeDatabase {
    fun getAllMusic(): List<MusicGroup>{
        val songList = listOf(
            Song("Sueño de primavera", R.color.green_800),
            Song("Esperanza de media noche", R.color.teal_800),
            Song("Siempre Desamor", R.color.blue_grey_800),
            Song("La Fiesta", R.color.cyan_800),
            Song("Bailando Juntos", R.color.light_blue_800),
            Song("Como lo fuimos", R.color.blue_800),
            Song("Si tu supieras", R.color.indigo_800),
            Song("Preguntate", R.color.deep_purple_800),
            Song("Sabemos quien fue", R.color.purple_800),
            Song("Se me va el alma", R.color.pink_800),
            Song("Amor, amor", R.color.red_800)
        )

        val musicGroupList = listOf(
            MusicGroup("Sigue escuchando...", songList),
            MusicGroup("Tu ultima play list:", songList),
            MusicGroup("Te recomendamos:", songList),
            MusicGroup("Mejores exitos de hoy:", songList),
            MusicGroup("Basados en tus gustos:", songList),
        )

        return musicGroupList.shuffled()
    }
}
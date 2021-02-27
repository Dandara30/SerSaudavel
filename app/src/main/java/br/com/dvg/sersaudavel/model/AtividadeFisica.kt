package br.com.dvg.sersaudavel.model

import android.os.Parcelable
import br.com.dvg.sersaudavel.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AtividadeFisica(
    val tipoExercicio: TipoExercicio,
    val nomeAtividade: String,
    val horarioInicial: String,
    val horarioFinal: String,
    val diaSemana : String
) : Parcelable

enum class TipoExercicio(val nome: String, val icone: Int) {
    CROSSFIT("Crossfit", R.drawable.ic_crossfit),
    CORRIDA("Corrida", R.drawable.ic_corrida),
    MUAYTHAI("Muay Thai", R.drawable.ic_muaythai)
}
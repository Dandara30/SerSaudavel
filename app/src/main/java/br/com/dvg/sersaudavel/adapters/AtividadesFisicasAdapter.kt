package br.com.dvg.sersaudavel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.dvg.sersaudavel.R
import br.com.dvg.sersaudavel.model.AtividadeFisica

class AtividadesFisicasAdapter(private val listaAtividadesFisicas: MutableList<AtividadeFisica>) : RecyclerView.Adapter<AtividadesFisicasAdapter.AtividadeFisicaHolder>() {

    class AtividadeFisicaHolder(view: View): RecyclerView.ViewHolder(view) {
        val icone : ImageView = view.findViewById(R.id.ivIcone)
        val nomeAtividade: TextView = view.findViewById(R.id.tvNomeAtividade)
        val horario: TextView = view.findViewById(R.id.tvHorario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadeFisicaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercicio_fisico, parent, false)
        return AtividadeFisicaHolder(view)
    }

    override fun onBindViewHolder(holder: AtividadeFisicaHolder, position: Int) {
        holder.icone.setImageResource(listaAtividadesFisicas[position].tipoExercicio.icone)
        holder.nomeAtividade.text = listaAtividadesFisicas[position].nomeAtividade
        holder.horario.text = listaAtividadesFisicas[position].horarioInicial + " às " + listaAtividadesFisicas[position].horarioFinal
    }

    override fun getItemCount(): Int {
        return listaAtividadesFisicas.size
    }

}
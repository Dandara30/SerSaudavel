package br.com.dvg.sersaudavel.screen

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.dvg.sersaudavel.R
import br.com.dvg.sersaudavel.adapters.AtividadesFisicasAdapter
import br.com.dvg.sersaudavel.model.AtividadeFisica
import br.com.dvg.sersaudavel.model.TipoExercicio
import br.com.dvg.sersaudavel.model.Usuario
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val diaUsuario = findViewById<TextView>(R.id.tvDiaMes)

        val aguaUm = findViewById<ImageView>(R.id.ivAgua1)
        val aguaDois = findViewById<ImageView>(R.id.ivAgua2)
        val aguaTres = findViewById<ImageView>(R.id.ivAgua3)
        val aguaQuatro = findViewById<ImageView>(R.id.ivAgua4)
        val aguaCinco = findViewById<ImageView>(R.id.ivAgua5)
        val aguaSeis = findViewById<ImageView>(R.id.ivAgua6)

        aguaUm.setOnClickListener{ hidratar(aguaUm,"500 ml") }
        aguaDois.setOnClickListener{ hidratar(aguaDois,"1 Litro") }
        aguaTres.setOnClickListener{ hidratar(aguaTres, "1,5 Litros") }
        aguaQuatro.setOnClickListener{ hidratar(aguaQuatro, "2 Litros") }
        aguaCinco.setOnClickListener{ hidratar(aguaCinco,"2,5 Litros") }
        aguaSeis.setOnClickListener{ hidratar(aguaSeis,"3 Litros") }

        //Obter nome usuario
        val usuario = intent.extras?.get("USUARIO") as Usuario
        val bemVindo = findViewById<TextView>(R.id.tvBemvindo)
        bemVindo.text = "Olá ${usuario.nome}!!!"

        //Dados da lista
        //TODO tratar lista de atividade referente ao di
//        val listaAtividadeFisica = mutableListOf<AtividadeFisica>(
//            AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Segunda-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.MUAYTHAI, nomeAtividade = TipoExercicio.MUAYTHAI.nome, horarioInicial = "09:30", horarioFinal = "10:30", diaSemana = "Segunda-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CORRIDA, nomeAtividade = TipoExercicio.CORRIDA.nome, horarioInicial = "17:00", horarioFinal = "18:00", diaSemana = "Segunda-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Terça-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Quarta-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CORRIDA, nomeAtividade = TipoExercicio.CORRIDA.nome, horarioInicial = "17:00", horarioFinal = "18:00", diaSemana = "Quarta-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.MUAYTHAI, nomeAtividade = TipoExercicio.MUAYTHAI.nome, horarioInicial = "09:30", horarioFinal = "10:30", diaSemana = "Quarta-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Quinta-Feira"),
//            AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Sexta-Feira")
//        )

        val listaAtividadeFisica = mutableListOf<AtividadeFisica>(
                AtividadeFisica(tipoExercicio = TipoExercicio.CROSSFIT, nomeAtividade = TipoExercicio.CROSSFIT.nome, horarioInicial = "07:15", horarioFinal = "08:15", diaSemana = "Sábado"),
                AtividadeFisica(tipoExercicio = TipoExercicio.MUAYTHAI, nomeAtividade = TipoExercicio.MUAYTHAI.nome, horarioInicial = "09:30", horarioFinal = "10:30", diaSemana = "Sábado"),
                AtividadeFisica(tipoExercicio = TipoExercicio.CORRIDA, nomeAtividade = TipoExercicio.CORRIDA.nome, horarioInicial = "17:00", horarioFinal = "18:00", diaSemana = "Sábado")
        )

        val rvAtividadeFisica = findViewById<RecyclerView>(R.id.rvAtividadesFisicas)
        rvAtividadeFisica.adapter = AtividadesFisicasAdapter(listaAtividadeFisica)
        rvAtividadeFisica.layoutManager = LinearLayoutManager(this)

        //Carregando data do dia
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
        var diaSemana = ""

        when(dayOfWeek) {
            Calendar.MONDAY -> diaSemana = "Segunda-feira"
            Calendar.TUESDAY -> diaSemana = "Terça-Feira"
            Calendar.WEDNESDAY -> diaSemana = "Quarta-feira"
            Calendar.THURSDAY -> diaSemana = "Quinta-feira"
            Calendar.FRIDAY -> diaSemana = "Sexta-feira"
            Calendar.SATURDAY -> diaSemana = "Sábado"
            Calendar.SUNDAY -> diaSemana = "Domingo"
        }

        diaUsuario.text = "${calendar.get(Calendar.DAY_OF_MONTH)}\n${diaSemana}"
    }

    private fun hidratar(imageView: ImageView, quantidade: String) {
        imageView.setImageResource(R.drawable.garrafa_cheia)
        Toast.makeText(this, "Parabéns, você bebeu ${quantidade}", Toast.LENGTH_SHORT).show()
    }
}
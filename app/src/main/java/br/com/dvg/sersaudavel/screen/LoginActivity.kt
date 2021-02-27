package br.com.dvg.sersaudavel.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import br.com.dvg.sersaudavel.R
import br.com.dvg.sersaudavel.model.Usuario

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val nome = findViewById<EditText>(R.id.etNome)
        val email = findViewById<EditText>(R.id.etEmail)
        val btCadastrar = findViewById<Button>(R.id.btCadastrar)

        email.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    btCadastrar.isEnabled = true
                    btCadastrar.requestFocus()
                    true
                }
                else -> false
            }
        }

        btCadastrar.setOnClickListener {

            val chaveUsuario = "USUARIO"
            val usuario = Usuario(nome.text.toString(), email.text.toString())

            val destinoHomeActivity = Intent(this@LoginActivity, HomeActivity::class.java)
            destinoHomeActivity.putExtra(chaveUsuario, usuario)

            startActivity(destinoHomeActivity)
            finish()

        }

    }
}
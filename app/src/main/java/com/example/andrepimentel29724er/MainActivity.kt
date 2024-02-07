package com.example.andrepimentel29724er
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrepimentel29724er.R
import com.example.andrepimentel29724er.adapter.SpaceXAdapter
import com.example.andrepimentel29724er.api.retrofitClient
import com.example.andrepimentel29724er.model.Crew

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var spaceXAdapter: SpaceXAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoAluno : Button = findViewById(R.id.buttonAluno)
        botaoAluno.setOnClickListener{
            startActivity(Intent(this, Aluno::class.java))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa o adaptador com uma lista vazia (pode ser atualizada mais tarde)
        spaceXAdapter = SpaceXAdapter(emptyList())
        recyclerView.adapter = spaceXAdapter

        // Chama a função para ir buscar dados da API
        fetchData()
    }

    private fun fetchData() {
        val apiService = retrofitClient.spaceXAdapter
        val call = apiService.getCrew()

        call.enqueue(object : Callback<List<Crew>> {
            override fun onResponse(call: Call<List<Crew>>, response: Response<List<Crew>>) {
                if (response.isSuccessful) {
                    val crew: List<Crew>? = response.body()

                    // Atualiza o adaptador com os países recebidos
                        crew?.let {
                        spaceXAdapter.updateCrew(it)
                        showToast("Dados carregados com sucesso!")
                    }
                } else {
                    // Tratar erro
                    showToast("Erro ao carregar dados da API.")
                }
            }

            override fun onFailure(call: Call<List<Crew>>, t: Throwable) {
                // Tratar falha na chamada
                showToast("Falha na chamada à API.")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
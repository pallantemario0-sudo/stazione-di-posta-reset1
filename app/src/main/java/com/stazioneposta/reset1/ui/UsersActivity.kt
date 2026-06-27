package com.stazioneposta.reset1.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.stazioneposta.reset1.R
import com.stazioneposta.reset1.data.AppDatabase
import com.stazioneposta.reset1.ui.adapter.UserAdapter
import kotlinx.coroutines.launch

class UsersActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var userListView: ListView
    private lateinit var searchView: SearchView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        database = AppDatabase.getDatabase(this)
        userListView = findViewById(R.id.userListView)
        searchView = findViewById(R.id.searchView)
        val backButton: Button = findViewById(R.id.backButton)

        userAdapter = UserAdapter(this, mutableListOf(), database)
        userListView.adapter = userAdapter

        loadUsers()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    loadUsers()
                } else {
                    lifecycleScope.launch {
                        val searchResults = database.userDao().search("%$newText%")
                        userAdapter.clear()
                        userAdapter.addAll(searchResults)
                        userAdapter.notifyDataSetChanged()
                    }
                }
                return true
            }
        })

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun loadUsers() {
        lifecycleScope.launch {
            val users = database.userDao().getAll()
            userAdapter.clear()
            userAdapter.addAll(users)
            userAdapter.notifyDataSetChanged()
        }
    }
}

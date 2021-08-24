package com.example.preferencesdatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputKey = findViewById<EditText>(R.id.input_key)
        val inputValue = findViewById<EditText>(R.id.input_value)
        val readKey = findViewById<EditText>(R.id.read_key)

        val saveBtn = findViewById<Button>(R.id.save_btn)
        val readBtn = findViewById<Button>(R.id.read_btn)

        val detailsTextview = findViewById<TextView>(R.id.details_tv)

        dataStore = createDataStore(name = "settings")

        saveBtn.setOnClickListener {
            lifecycleScope.launch {
                save(inputKey.text.toString(), inputValue.text.toString())
            }
        }

        readBtn.setOnClickListener {
            lifecycleScope.launch {
                val value = read(readKey.text.toString())
                detailsTextview.text = value ?: "No value found"
            }
        }
    }

    private suspend fun save(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value

        }
    }

    private suspend fun read(key: String) : String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }
}
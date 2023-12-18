package com.habib.projectakhirv4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.habib.projectakhirv4.api.ApiConfig
import com.habib.projectakhirv4.model.ResponModel
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val masuk = findViewById<Button>(R.id.button3)

        masuk.setOnClickListener {
            login()
        }

        var register = findViewById(R.id.buttonRegister) as TextView

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun login(){
        val usernameEdit  = findViewById<EditText>(R.id.editTextText2)
        val passwordEdit  = findViewById<EditText>(R.id.editTextTextPassword2)

        if (usernameEdit.text.isEmpty()) {
            usernameEdit.error = "Username Wajib Di isi!"
            usernameEdit.requestFocus()
            return
        }   else if (passwordEdit.text.isEmpty()) {
            passwordEdit.error = "Password Wajib Di isi!"
            passwordEdit.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(usernameEdit.text.toString(),passwordEdit.text.toString()).enqueue(object :
            retrofit2.Callback<ResponModel> {
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: retrofit2.Response<ResponModel>) {
                Log.d("LoginActivity", "Response code: ${response.code()}")
                Log.d("LoginActivity", "Response body: ${response.body()}")
                val respon = response.body()
                if (respon != null && respon.status == 200) {
                    Toast.makeText(this@LoginActivity, "Login Berhasil, Gass Ke Beranda", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()  // Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman pendaftaran
                    }, 2000)
                } else {
                    Toast.makeText(this@LoginActivity, respon?.message ?: "Unknown error", Toast.LENGTH_SHORT).show()
                    Log.d("LoginActivity", "Response body: $respon")
                }
            }

        })
    }
}
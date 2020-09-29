package com.francisco.chatappandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.francisco.chatappandroid.Fragment.AccionesFragmentos
import com.francisco.chatappandroid.Fragment.BlueFragment
import com.francisco.chatappandroid.Fragment.RedFragment
import com.francisco.chatappandroid.Scenes.Login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AccionesFragmentos {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLogin()
        btnRed.setOnClickListener { replaceFragment(RedFragment()) }
        btnBlue.setOnClickListener { replaceFragment(BlueFragment()) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {

        }
    }

    private fun showLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivityForResult(intent, 1)
    }

    override fun onClickFragment() {
        Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show()
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

package com.example.guest.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.guest.R
import com.example.guest.constants.DataBaseConstants
import com.example.guest.databinding.ActivityGuestFormBinding
import com.example.guest.model.GuestModel
import com.example.guest.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewmodel: GuestFormViewModel

    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        observe()
        loadData()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel().apply {
                this.id = guestId
                this.name = name
                this.presence = presence
            }

            viewmodel.save(model)
        }
    }

    private fun loadData() {
        val bundle = intent.extras

        if (bundle != null) {
            guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewmodel.get(guestId)
        }
    }

    private fun observe() {
        viewmodel.guestModel.observe(this) {
            binding.editName.setText(it.name)

            if (it.presence) {
                binding.radioPresent.isChecked = true
            } else {
                binding.radioAbsent.isChecked = true
            }
        }

        viewmodel.saveGuest.observe(this) {
            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
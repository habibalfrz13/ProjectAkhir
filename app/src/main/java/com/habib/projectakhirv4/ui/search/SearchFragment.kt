package com.habib.projectakhirv4.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.habib.projectakhirv4.KategoriActivity
import com.habib.projectakhirv4.R
import com.habib.projectakhirv4.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Mendapatkan referensi ke ImageButton
        val imageButton: ImageButton = root.findViewById(R.id.imageButton)
        val imageButton2: ImageButton = root.findViewById(R.id.imageButton2)
        val imageButton3: ImageButton = root.findViewById(R.id.imageButton3)
        val imageButton4: ImageButton = root.findViewById(R.id.imageButton4)

        // Menambahkan listener klik untuk setiap ImageButton
        imageButton.setOnClickListener {
            // Membuat Intent untuk memulai KategoriActivity
            val intent = Intent(activity, KategoriActivity::class.java)
            // Memulai aktivitas menggunakan intent
            startActivity(intent)
        }

        imageButton2.setOnClickListener {
            val intent = Intent(activity, KategoriActivity::class.java)
            startActivity(intent)
        }

        imageButton3.setOnClickListener {
            val intent = Intent(activity, KategoriActivity::class.java)
            startActivity(intent)
        }

        imageButton4.setOnClickListener {
            val intent = Intent(activity, KategoriActivity::class.java)
            startActivity(intent)
        }

        // Mengamati LiveData dari ViewModel
        searchViewModel.text.observe(viewLifecycleOwner) {
            // Lakukan sesuatu dengan data LiveData jika diperlukan
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.habib.projectakhirv4.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.habib.projectakhirv4.CraftActivity
import com.habib.projectakhirv4.KategoriActivity
import com.habib.projectakhirv4.R
import com.habib.projectakhirv4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }
        val imageView3: ImageView = root.findViewById(R.id.imageView3)
        val imageView2: ImageView = root.findViewById(R.id.imageView2)
        val imageView4: ImageView = root.findViewById(R.id.imageView4)
        val imageView5: ImageView = root.findViewById(R.id.imageView5)

        val imageView7: ImageView = root.findViewById(R.id.imageView7)

        val imageView8: ImageView = root.findViewById(R.id.imageView8)
        val imageView9: ImageView = root.findViewById(R.id.imageView9)
        val imageView10: ImageView = root.findViewById(R.id.imageView10)
        //Category
        imageView3.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }
        imageView2.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }
        imageView4.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }
        imageView5.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }

        //Easy to craft
        imageView7.setOnClickListener {
            val intent = Intent(context, CraftActivity::class.java)
            startActivity(intent)
        }

        //Recommendation
        imageView8.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }
        imageView9.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }
        imageView10.setOnClickListener {
            val intent = Intent(context, KategoriActivity::class.java)
            startActivity(intent)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
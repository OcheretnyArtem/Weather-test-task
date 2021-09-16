package by.ocheretny.weathertesttask.ui.myLocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.weathertesttask.databinding.FragmentMyLocationBinding

class MyLocationFragment : Fragment() {

    private lateinit var myLocationViewModel: MyLocationViewModel
    private var _binding: FragmentMyLocationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myLocationViewModel =
            ViewModelProvider(this).get(MyLocationViewModel::class.java)

        _binding = FragmentMyLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        myLocationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
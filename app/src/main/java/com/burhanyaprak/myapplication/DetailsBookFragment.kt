package com.burhanyaprak.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.burhanyaprak.myapplication.databinding.FragmentDetailsBookBinding
import com.burhanyaprak.myapplication.databinding.FragmentListBookBinding

class DetailsBookFragment : Fragment() {
    //safe-args is type safety because of that better than arguments.
    private val args by navArgs<DetailsBookFragmentArgs>()
    private var _binding: FragmentDetailsBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBookBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewBookWriterName.text = args.book.bookWriterName
        binding.textViewBookName.text = args.book.bookName
        binding.textViewBookDetails.text = args.book.bookDetails
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.burhanyaprak.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.burhanyaprak.myapplication.databinding.FragmentListBookBinding

class ListBookFragment : Fragment() {
    private var _binding: FragmentListBookBinding? = null
    private val binding get() = _binding!!

    //lazy keyword allows the property to take up memory when it is used - it helps to load screen faster
    private val bookAdapter by lazy {
        BookAdapter().apply {
            itemClickListener = {
                navigateDetailsBookFragment(it)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBookBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //mock-data
        val book1 = BookModel("Seranad", "Zülfü Livaneli", resources.getString(R.string.loremipsum))
        val book2 = BookModel("Çalıkuşu", "Reşat Nuri Güntekin", resources.getString(R.string.loremipsum))
        val book3 = BookModel("Romeo ve Juliet", "William Shakespeare", resources.getString(R.string.loremipsum))
        val book4 = BookModel("Bir Delinin Hatıra Defteri", "Gogol", resources.getString(R.string.loremipsum))
        val book5 = BookModel("Yeraltından Notlar", "Dostoyevski", resources.getString(R.string.loremipsum))

        val bookList = listOf(book1, book2, book3, book4, book5)

        bookAdapter.setEventData(bookList)
    }

    private fun setupRecyclerView(){
        val recyclerView = binding.recyclerviewListBooks
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun navigateDetailsBookFragment(book: BookModel) {
        //navigate to DetailsBookFragment with book datas
        val action =
            ListBookFragmentDirections.actionListBookFragmentToDetailsBookFragment(book)
        findNavController().navigate(action)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
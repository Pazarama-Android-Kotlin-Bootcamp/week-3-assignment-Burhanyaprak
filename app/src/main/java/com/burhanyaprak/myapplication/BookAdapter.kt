package com.burhanyaprak.myapplication
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.burhanyaprak.myapplication.databinding.CustomBookListBinding

class BookAdapter(var itemClickListener: ((BookModel) -> Unit)? = null): RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    private var bookList = emptyList<BookModel>()
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(bookList[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            CustomBookListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MyViewHolder(itemBinding, itemClickListener)
    }

    class MyViewHolder(
        itemBinding: CustomBookListBinding,
        private val clickedItem: ((BookModel) -> Unit)?,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        private val bookName: TextView = itemBinding.textViewBookName
        private val bookWriterName: TextView = itemBinding.textViewBookWriterName
        fun bind(book: BookModel) {
            bookName.text = book.bookName
            bookWriterName.text = book.bookWriterName
            itemView.setOnClickListener {
                clickedItem?.invoke(book)
            }
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun setEventData(event: List<BookModel>) {
        this.bookList = event
    }
}
package com.sample.blueline.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.blueline.BR
import com.sample.blueline.R
import com.sample.blueline.handlers.MessageHandler
import com.sample.blueline.models.Message

class MessageAdapter(private val handler: MessageHandler) :
    ListAdapter<Message, MessageAdapter.MessageViewHolder>(MessageDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding: ViewDataBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_message, parent, false)

        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MessageViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            binding.setVariable(BR.message, message)
            binding.setVariable(BR.handler, handler)

            binding.executePendingBindings()
        }
    }
}

object MessageDiff : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem == newItem
}

object MessageTouchCallback: ItemTouchHelper.Callback(){
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
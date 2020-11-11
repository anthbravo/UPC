package pe.edu.upc.agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val context: Context, val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bindTo(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }


}
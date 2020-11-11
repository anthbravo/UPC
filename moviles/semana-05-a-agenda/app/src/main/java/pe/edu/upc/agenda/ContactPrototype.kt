package pe.edu.upc.agenda

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindTo(contact: Contact) {
        itemView.tvName.text = contact.name
        itemView.tvTelephone.text = contact.telephone
    }
}
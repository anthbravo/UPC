package pe.edu.upc.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var contacts: ArrayList<Contact>
    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadContacts()
        initViews()
    }

    private fun loadContacts() {
        contacts = ArrayList()

        var contact = Contact("Jorge", "938856368")
        contacts.add(contact)
        contact = Contact("Marco", "989374440")
        contacts.add(contact)
    }

    private fun initViews() {
        contactAdapter = ContactAdapter(this, contacts)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }
}
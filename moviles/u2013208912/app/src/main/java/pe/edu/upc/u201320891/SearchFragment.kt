package pe.edu.upc.u201320891

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jokes.*


/**
 * A simple [Fragment] subclass.
 * Use the [HeroesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeroesFragment : Fragment() {

    lateinit var heroes: List<Heroe>
    lateinit var heroeAdapter: HeroeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        loadItems()
        heroeAdapter = JokeAdapter(heroes)

        rvJoke.adapter = heroeAdapter
        rvJoke.layoutManager = LinearLayoutManager(context)

    }

    private fun loadItems() {
        heroes = AppDatabase.getInstance(context!!).getDao().getAll()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HeroesFragment()
    }
}
package pe.edu.upc.u201320891

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cat_card.*
import kotlinx.android.synthetic.main.favorite_fragment.*
import kotlinx.android.synthetic.main.favorite_fragment.tvHeight
import kotlinx.android.synthetic.main.favorite_fragment.tvName
import kotlinx.android.synthetic.main.favorite_fragment.tvURL
import kotlinx.android.synthetic.main.favorite_fragment.tvWidth
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    lateinit var cats: List<Cat>
    lateinit var catAdapter: CatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        search()

        catAdapter = CatAdapter(cats)

        rvCats.adapter = catAdapter
        rvCats.layoutManager = LinearLayoutManager(context)

    }

    companion object {
        const val TAG = "ListFragment"

        @JvmStatic
        fun newInstance() =
            ListFragment()
    }

    private fun search() {
        cats = CatDatabase.getInstance(context!!).getDao().getAll()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }


}
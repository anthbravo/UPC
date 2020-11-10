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
import kotlinx.android.synthetic.main.heroe_card.*
import kotlinx.android.synthetic.main.search_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    lateinit var heroes: List<Heroe>
    lateinit var heroeAdapter: HeroeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        loadItems()
        /*heroeAdapter = HeroeAdapter(heroes)

        rvHeroes.adapter = heroeAdapter
        rvHeroes.layoutManager = LinearLayoutManager(context)*/

    }

    private fun loadItems() {

        btnSearch.setOnClickListener {
            search()

        }


    }

    companion object {
        const val TAG = "SearchFragment"

        @JvmStatic
        fun newInstance() =
            SearchFragment()
    }

    private fun search() {
        Log.d("TAG", "search")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/750378565808159/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val heroeService = retrofit.create(HeroeService::class.java);

        val request = heroeService.getHeroes(ptName.text.toString());

        request.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                if (response.isSuccessful) {

                    val searchResponse = response.body()
                    heroes = searchResponse!!.heroes

                    heroeAdapter = HeroeAdapter(heroes)

                    rvHeroesSearch.adapter = heroeAdapter
                    rvHeroesSearch.layoutManager = LinearLayoutManager(context)

                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.d(TAG, t.toString())
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search_fragment, container, false)
    }


}
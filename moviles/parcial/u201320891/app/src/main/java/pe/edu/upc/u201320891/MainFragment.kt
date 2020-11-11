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
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    lateinit var cats: List<Cat>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        search()

    }

    companion object {
        const val TAG = "MainFragment"

        @JvmStatic
        fun newInstance() =
            MainFragment()
    }

    private fun search() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val catService = retrofit.create(CatService::class.java);

        val request = catService.getCats();

        request.enqueue(object : Callback<List<Cat>> {
            override fun onResponse(
                call: Call<List<Cat>>,
                response: Response<List<Cat>>
            ) {
                if (response.isSuccessful) {

                    val searchResponse = response.body()
                    cats = searchResponse!!

                    tvTitleCat.text = cats.get(0).name
                    Picasso.get().load(cats.get(0).url).into(ivCat)
                }
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Log.d(TAG, t.toString())
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


}
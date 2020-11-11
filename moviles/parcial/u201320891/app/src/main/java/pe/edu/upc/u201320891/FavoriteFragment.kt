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
import kotlinx.android.synthetic.main.favorite_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {

    lateinit var cats: List<Cat>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        search()

        btnSave.setOnClickListener {
            save()
        }

    }

    companion object {
        const val TAG = "FavoriteFragment"

        @JvmStatic
        fun newInstance() =
            FavoriteFragment()
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
                    if(cats.size > 0){
                        tvName.text = cats.get(0).name
                        tvHeight.text = cats.get(0).height.toString()
                        tvWidth.text = cats.get(0).width.toString()
                        tvURL.text = cats.get(0).url.toString()
                    }
                }
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Log.d(TAG, t.toString())
            }

        })
    }

    private fun save(){
        CatDatabase.getInstance(context!!).getDao().insert(cats.get(0))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }


}
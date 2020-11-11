package pe.edu.upc.u201320891

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cat_card.view.*
import kotlinx.android.synthetic.main.main_fragment.*

class CatAdapter(val cats: List<Cat>): RecyclerView.Adapter<CatCard>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatCard {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_card,parent, false)
        return CatCard(view)
    }

    override fun onBindViewHolder(holder: CatCard, position: Int) {
        holder.bindTo(cats[position])
    }

    override fun getItemCount(): Int {
       return cats.size
    }

}

class CatCard(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindTo(cat: Cat){
        itemView.tvName.text = cat.name
        itemView.tvWidth.text = cat.width.toString()
        itemView.tvHeight.text = cat.height.toString()
        itemView.tvURL.text = cat.url
        Picasso.get().load(cat.url).into(itemView.ivCat)
        itemView.btnDelete.setOnClickListener{
            delete(cat)
        }
    }

    fun delete(cat:Cat){
        CatDatabase.getInstance(itemView.context).getDao().delete(cat)
    }
}

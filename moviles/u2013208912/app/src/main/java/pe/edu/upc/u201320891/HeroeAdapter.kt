package pe.edu.upc.jokes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_joke.view.*

class JokeAdapter(val jokes: List<Joke>): RecyclerView.Adapter<JokePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokePrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_joke,parent, false)
        return JokePrototype(view)
    }

    override fun onBindViewHolder(holder: JokePrototype, position: Int) {
        holder.bindTo(jokes[position])
    }

    override fun getItemCount(): Int {
       return jokes.size
    }

}

class JokePrototype(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindTo(joke: Joke){
        itemView.tvJoke.text = joke.sentence
    }
}

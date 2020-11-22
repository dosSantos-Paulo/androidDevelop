package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.R
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.*
import org.w3c.dom.Text

class RecyclerAdapter(private val dataSet: List<Personagem>): RecyclerView.Adapter<RecyclerAdapter.meuViewHolder>() {

    class meuViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val image: ImageView = view.findViewById(R.id.img_itemImage)
        private val name: TextView = view.findViewById(R.id.txt_itemName)
        private val status: TextView = view.findViewById(R.id.txt_itemStatus)
        private val type: TextView = view.findViewById(R.id.txt_itemType)
        private val localization: TextView = view.findViewById(R.id.txt_itemLocation)

        fun bind (person: Personagem) {

            Picasso.get().load(person.imagemUrl).into(image)
            name.text = person.nome
            status.text = person.status
            type.text = person.especie
            localization.text = person.localizacao.nome
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return meuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}


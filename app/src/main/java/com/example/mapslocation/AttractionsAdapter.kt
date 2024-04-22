import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapslocation.R

class AttractionsAdapter(private val buildings: List<String>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<AttractionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_attraction, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val building = buildings[position]
        holder.bind(building)
        holder.itemView.setOnClickListener { onItemClick(building) }
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView as TextView

        fun bind(buildingName: String) {
            textView.text = buildingName
        }
    }
}
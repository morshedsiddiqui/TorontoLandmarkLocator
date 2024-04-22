import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapslocation.AttractionsActivity
import com.example.mapslocation.MuseumsActivity
import com.example.mapslocation.OldBuildingsActivity
import com.example.mapslocation.R
import com.example.mapslocation.StadiumsActivity

class CategoryAdapter(private val context: Context, private val items: List<String>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            when (position) {
                0 -> context.startActivity(OldBuildingsActivity.newIntent(context))
                1 -> context.startActivity(MuseumsActivity.newIntent(context))
                2 -> context.startActivity(StadiumsActivity.newIntent(context))
                3 -> context.startActivity(AttractionsActivity.newIntent(context))
                // Add more cases for additional activities
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_text)

        fun bind(item: String) {
            textView.text = item
        }
    }
}

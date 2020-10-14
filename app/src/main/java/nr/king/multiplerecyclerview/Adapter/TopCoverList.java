package nr.king.multiplerecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.ContentHandler;
import java.util.List;

import nr.king.multiplerecyclerview.Data.Movies;
import nr.king.multiplerecyclerview.R;

public class TopCoverList  extends RecyclerView.Adapter<TopCoverList.ViewHolder>{
public Context context;
public List<Movies> moviesList;

    public TopCoverList(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.covertoplayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Movies movies=moviesList.get(position);
        Glide.with(context).load(movies.getImage())
                .into(holder.imageView);
        holder.textView.setText(movies.getName());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView imageView;
            public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageviewtop);
            textView=itemView.findViewById(R.id.movietitle);
        }
    }

}

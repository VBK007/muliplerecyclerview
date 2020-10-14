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

import java.util.List;

import nr.king.multiplerecyclerview.Data.Movies;
import nr.king.multiplerecyclerview.R;

public class bottomViewHolder extends RecyclerView.Adapter<bottomViewHolder.ViewHolder> {
    public Context context;
    public List<Movies> moviesList;

    public bottomViewHolder(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }


    @NonNull
    @Override
    public bottomViewHolder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bootomlayout,parent,false);
        return new bottomViewHolder.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movies movies=moviesList.get(position);
        Glide.with(context).load(movies.getImage())
                .into(holder.imageView);
holder.moviename.setText(movies.getName());
holder.moviesubtitle.setText(movies.getMenuId());

    }

    @Override
    public int getItemCount() {
        return moviesList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
public TextView moviename,moviesubtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.bootmimage);
moviename=itemView.findViewById(R.id.moviettile);
moviesubtitle=itemView.findViewById(R.id.moviesubtitle);
        }
    }
}

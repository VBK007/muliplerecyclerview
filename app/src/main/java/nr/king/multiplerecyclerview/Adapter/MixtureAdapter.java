package nr.king.multiplerecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nr.king.multiplerecyclerview.Data.Groups;
import nr.king.multiplerecyclerview.Data.Movies;
import nr.king.multiplerecyclerview.R;

public class MixtureAdapter extends RecyclerView.Adapter<MixtureAdapter.ViewHolder> {
public Context context;
public List<Groups> groupsList;
    public List<Movies> Cover;
    public List<Movies> Middle;
    public List<Movies> boottom;

    public MixtureAdapter(Context context, List<Groups> groupsList, List<Movies> cover, List<Movies> middle, List<Movies> boottom) {
        this.context = context;
        this.groupsList = groupsList;
        Cover = cover;
        Middle = middle;
        this.boottom = boottom;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.groupdata,parent,false);
        return new MixtureAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Groups groups=groupsList.get(position);
holder.textView.setText(groups.getData1());
holder.textView2.setText(groups.getData2());

setMultipleRecyclerView(holder.recyclerView,position);

    }

    private void setMultipleRecyclerView(RecyclerView recyclerView, int position) {
        switch (position){
            case 0:
                setCoverLayouttop(recyclerView);
                break;

            case 1:
                setMidddleLayout(recyclerView);
                break;
            case 2:
                setbootomLayout(recyclerView);
                break;

        }
    }

    private void setbootomLayout(RecyclerView recyclerView) {

        bottomViewHolder topCoverList=new bottomViewHolder(context,Cover);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(topCoverList);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setMidddleLayout(RecyclerView recyclerView) {

        MiddelViewHolder topCoverList=new MiddelViewHolder(context,Middle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(topCoverList);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setCoverLayouttop(RecyclerView recyclerView) {
     TopCoverList topCoverList=new TopCoverList(context,Cover);
     recyclerView.setHasFixedSize(true);
     recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
     recyclerView.setAdapter(topCoverList);
     recyclerView.setNestedScrollingEnabled(true);


    }


    @Override
    public int getItemCount() {
        return groupsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView,textView2;
        public RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.explore);
            textView2=itemView.findViewById(R.id.viewall);
            recyclerView=itemView.findViewById(R.id.recyclerview);
        }
    }

}

package nr.king.multiplerecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nr.king.multiplerecyclerview.Adapter.MixtureAdapter;
import nr.king.multiplerecyclerview.Data.Groups;
import nr.king.multiplerecyclerview.Data.Movies;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MixtureAdapter mixtureAdapter;
    List<Movies> cover;
    List<Groups> groupsList;
    List<Movies> middle;
    List<Movies> bootom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groupsList=new ArrayList<>();
        cover=new ArrayList<>();
        middle=new ArrayList<>();
        bootom=new ArrayList<>();
        setAdapter();
        setArrayData();
    }

    private void setArrayData() {
        groupsList.add(new Groups("New Movies","ViewAll"));
        groupsList.add(new Groups("Tamil Movies","ViewAll"));
        groupsList.add(new Groups("Other Movies","Explore it"));

//        cover.add(new Movies("Avengers End Game", "Avengers End Game", "https://ichef.bbci.co.uk/news/1024/cpsprodpb/D1E0/production/_106082735_mediaitem106082731.jpg"));
//        cover.add(new Movies("BatMan", "BatMan", "https://images-na.ssl-images-amazon.com/images/I/51yPRRGdSHL.jpg"));
//        cover.add(new Movies("Viswasam", "Viswasam", "https://upload.wikimedia.org/wikipedia/en/0/0e/Viswasam_poster.jpg"));
//        cover.add(new Movies("Asuran", "Asuran", "https://static.toiimg.com/photo/msid-72155291/72155291.jpg?1147869"));
//        cover.add(new Movies("Bigil", "Bigil", "https://img.republicworld.com/republic-prod/stories/promolarge/xxhdpi/5bejt6uhneiavzxp_1590659521.jpeg?tr=w-812,h-464"));
//        cover.add(new Movies("Kannum kannum Kolai Adithal", "Kannum kannum Kolai Adithal", "https://i1.wp.com/www.socialnews.xyz/wp-content/uploads/2020/02/18/maxresdefault-95.jpg?fit=1280%2C720&quality=90&zoom=1&ssl=1"));
//
//
//        middle.add(new Movies("Tamil Movies", "Movie Subtitle3", "https://qqcdnpictest.mxplay.com/pic/5c32d8da73c436c2b20cd6930d1bade2/en/2x3/320x480/test_pic1587127724047.webp"));
//        middle.add(new Movies("Movie Title5", "Movie Subtitle5", "https://qqcdnpictest.mxplay.com/pic/b7d8edf76434e2a3a2b8e860c77b87c1/ta/2x3/320x480/test_pic1568361964158.webp"));
//        middle.add(new Movies("Movie Title4", "Movie Subtitle4", "https://wirally.com/wp-content/uploads/2020/05/1-Best-Tamil-Movies-On-Amazon-Prime.jpg"));
//        middle.add(new Movies("Movie Title6", "Movie Subtitle6", "https://www.filmibeat.com/img/2014/01/03-best-tamil-movie-01.jpg"));
//        middle.add(new Movies("Movie Title7", "Movie Subtitle7", "https://qqcdnpictest.mxplay.com/pic/ad2fe6042b74d3c1620e02996e7b7f6e/ta/2x3/320x480/test_pic1572512467550.webp"));
//
//        bootom.add(new Movies("Hindi Movies", "Movie Subtitle8", "https://i.pinimg.com/originals/97/12/34/9712340ee47b6b06286f534e050f9d29.jpg"));
//        bootom.add(new Movies("Hindi Movies", "Movie Subtitle10", "https://tamashafullmoviefree.files.wordpress.com/2015/11/tamasha-movie-poster-2015.jpg?w=377&h=285"));
//        bootom.add(new Movies("Hindi Movies", "Movie Subtitle9", "https://a10.gaanacdn.com/images/albums/2/2390102/crop_175x175_1549358354_2390102.jpg"));
//        bootom.add(new Movies("Hindi Movies", "Movie Subtitle11", "https://upload.wikimedia.org/wikipedia/en/thumb/d/dd/Joseph_film_poster.jpg/220px-Joseph_film_poster.jpg"));


        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Category");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               for (DataSnapshot snapshot1:snapshot.getChildren()){

                   Movies movies=snapshot1.getValue(Movies.class);
                   cover.add(movies);
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference reference1= FirebaseDatabase.getInstance().getReference("Category");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1:snapshot.getChildren()){

                    Movies movies=snapshot1.getValue(Movies.class);
                    middle.add(movies);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference reference2= FirebaseDatabase.getInstance().getReference("Category");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1:snapshot.getChildren()){

                    Movies movies=snapshot1.getValue(Movies.class);
                    bootom.add(movies);
                }

                Collections.reverse(bootom);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void setAdapter() {
     recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        mixtureAdapter=new MixtureAdapter(this,groupsList,cover,middle,bootom);
        recyclerView.setAdapter(mixtureAdapter);


    }
}
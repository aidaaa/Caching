package eu.example.aida.caching.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.caching.R;
import eu.example.aida.caching.domain.model.Movie;

/**
 * Created by Aida on 1/20/2019.
 */

public class Apdater1 extends RecyclerView.Adapter<Apdater1.MyViewHolder>
{

    List<Movie> movies=new ArrayList<>();
    Context context;

    public Apdater1(Context context) {
        this.context = context;
    }

    public void setMovies(List<Movie> movie)
    {
        this.movies = movie;
        notifyItemChanged(movies.size(),movie.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.id.setText(Integer.toString(movies.get(position).getId()));
        holder.title.setText(movies.get(position).getTitle());
        holder.year.setText(movies.get(position).getTitle());
        holder.imdb_rating.setText(movies.get(position).getImdb_rating());

        final String img_url=movies.get(position).getPoster();
        Picasso picasso=new Picasso.Builder(context).build();
        picasso.load(img_url).into(holder.img);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount()
    {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.id)
        TextView id;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.year)
        TextView year;

        @BindView(R.id.imdb_rating)
        TextView imdb_rating;

        @BindView(R.id.img)
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

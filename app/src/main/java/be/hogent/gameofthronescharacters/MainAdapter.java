package be.hogent.gameofthronescharacters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jens Buysse on 2/11/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    public static final String TAG = "MainAdapter";


    private ArrayList<CharacterDescription> characters;

    public MainAdapter(ArrayList<CharacterDescription> characters) {
        this.characters = characters;
        Log.i(TAG, "Created the MainAdapter with " + characters.size() + " characters");

    }

    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main,parent,false);
        v.setOnClickListener(MainActivityFragment.mainOnClickListener);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainViewHolder holder, int position) {
        ImageView image = holder.characterImage;
        TextView name = holder.characterName;
        Context context = holder.characterImage.getContext();
        Picasso.with(context).load(characters.get(position).getImage()).into(image);
        image.setImageResource(characters.get(position).getImage());
        name.setText(characters.get(position).getCharacterName());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class MainViewHolder extends
            RecyclerView.ViewHolder {

        @Bind(R.id.card_image)
        public ImageView characterImage;

        @Bind(R.id.card_name)
        public TextView characterName;

        public MainViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }

    }

}

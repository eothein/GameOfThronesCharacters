package be.hogent.gameofthronescharacters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    public static final String TAG = "MainActivityFragment";

    public static MainOnclickListener mainOnClickListener;

    /**
     * The RecyclerView for our fragment
     */
    @Bind(R.id.recyclerView)
    public RecyclerView mRcyclerView;

    protected RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<CharacterDescription> characterDescriptions;


    /**
     * Last Clicked position in the list
     */
    private int currentIndex;

    public MainActivityFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Created the Fragment");
        initDataSet();
        mainOnClickListener = new MainOnclickListener(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,rootView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRcyclerView.setLayoutManager(mLayoutManager);

        MainAdapter adapter = new MainAdapter(characterDescriptions);
        mRcyclerView.setAdapter(adapter);

        Log.i(TAG, "Created the FragmentView");
        return rootView;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void initDataSet(){
        characterDescriptions = new ArrayList<CharacterDescription>();
        for(int i =0; i<DataClass.characterPictures.length; i++ ){
            CharacterDescription description = new CharacterDescription(
                    DataClass.characterPictures[i],
                    DataClass.characterNames[i],
                    DataClass.characterDetails[i]);
            characterDescriptions.add(description);
        }
    }

    private class MainOnclickListener implements View.OnClickListener{

        private final Context context;

        public MainOnclickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            currentIndex = mRcyclerView.getChildAdapterPosition(v);
            Log.i(TAG,"Clicked on : "+currentIndex);
        }
    }
}

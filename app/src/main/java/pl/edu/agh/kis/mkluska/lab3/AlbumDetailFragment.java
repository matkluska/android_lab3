package pl.edu.agh.kis.mkluska.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.edu.agh.kis.mkluska.lab3.model.Album;
import pl.edu.agh.kis.mkluska.lab3.model.AlbumRepositoryImpl;

public class AlbumDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";

    private Album album;

    public AlbumDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String itemId = getArguments().getString(ARG_ITEM_ID);
            assert itemId != null;
            album = AlbumRepositoryImpl.getInstance().findById(itemId);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(album.getAlbum());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.album_detail, container, false);

        // Show the album content as text in a TextViews.
        if (album != null) {
            ((TextView) rootView.findViewById(R.id.album_name)).setText(album.getAlbum());
            ((TextView) rootView.findViewById(R.id.artist_name)).setText(album.getArtist());
            ((TextView) rootView.findViewById(R.id.genre)).setText(album.getGenre());
            ((TextView) rootView.findViewById(R.id.tracksNumber)).setText(Integer.toString(album.getTracks()));
            ((TextView) rootView.findViewById(R.id.year)).setText(Integer.toString(album.getYear()));
        }

        return rootView;
    }
}

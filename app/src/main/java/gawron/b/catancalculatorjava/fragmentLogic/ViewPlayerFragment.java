package gawron.b.catancalculatorjava.fragmentLogic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import gawron.b.catancalculatorjava.R;

public class ViewPlayerFragment extends Fragment {

    AddPlayerFragment addPlayerFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_player,container, false);

        Button btnConfirm = (Button) view.findViewById(R.id.btnconfirm);
        Button btnExit = (Button) view.findViewById(R.id.btnexit2);
        final ListView listOfPlayers = (ListView) view.findViewById(R.id.viewlistplayer);

        final CustomAdapter customAdapter = new CustomAdapter();
        listOfPlayers.setAdapter(customAdapter);
        
        return view;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return (int)position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_players,null);

            TextView textPlayerName = view.findViewById(R.id.textPlayerName);
            TextView textPlayerLastName = view.findViewById(R.id.textPlayerLastName);

            textPlayerName.setText(addPlayerFragment.playerList.indexOf(position));

            return view;
        }
    }
}

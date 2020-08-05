package gawron.b.catancalculatorjava.fragmentLogic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import gawron.b.catancalculatorjava.MainActivity;
import gawron.b.catancalculatorjava.R;
import gawron.b.catancalculatorjava.model.Player;

public class AddPlayerFragment extends Fragment {

    private Button btnAdd;
    private EditText name, lastName;
    MainActivity mainActivity;
    public int playerNumber= 0;

    public int[] tabOfColors = new int[]{
            R.color.colorWHITE,R.color.colorRED,
            R.color.colorORANGE, R.color.colorBLUE,
            R.color.colorGREEN,R.color.colorBROWN};

    public int colorPlayer=0;
    private String namePlayer=null, lastNamePlayer=null;
    public ArrayList<Player> playerList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_player, container, false);

            name = view.findViewById(R.id.editTextName);
            lastName = view.findViewById(R.id.editTextLastName);
            btnAdd = view.findViewById(R.id.btnadd);
            final ListView listOfColor = view.findViewById(R.id.listofcolor);

            final CustomAdapter customAdapter = new CustomAdapter();
            listOfColor.setAdapter(customAdapter);

            listOfColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    colorPlayer=position;
                    name.setBackgroundResource(tabOfColors[position]);
                    lastName.setBackgroundResource(tabOfColors[position]);
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        do {
                            namePlayer = name.getText().toString();
                            lastNamePlayer = lastName.getText().toString();
                            playerList.add(new Player(namePlayer, lastNamePlayer, colorPlayer, 0));
                            //TODO remove used color from Array
                            name.setText("Name");
                            lastName.setText("LastName");
                            name.setBackgroundResource(tabOfColors[0]);
                            lastName.setBackgroundResource(tabOfColors[0]);
                            playerNumber--;
                        } while(playerNumber>=0);
                        //send message to MainActivity to close fragment
                        //btnAdd.setVisibility(View.INVISIBLE);
                    }
                });

        return view;
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return tabOfColors.length;
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
            View view = getLayoutInflater().inflate(R.layout.row_colors,null);

            ImageView imageColor = view.findViewById(R.id.imageColor);
            TextView textColorName = view.findViewById(R.id.textColorName);

            imageColor.setImageResource(tabOfColors[position]);
            textColorName.setText(tabOfColors[position]);
            return view;
        }
    }
}

package gawron.b.catancalculatorjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gawron.b.catancalculatorjava.fragmentLogic.AddPlayerFragment;
import gawron.b.catancalculatorjava.fragmentLogic.ViewPlayerFragment;

public class MainActivity extends AppCompatActivity implements  DialogLogic.DialogListener{

    private AddPlayerFragment addPlayerFragment;
    private ViewPlayerFragment viewPlayerFragment;
    private int playerNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnSubmit = findViewById(R.id.btnsubmit);
        final Button btnDescribe = findViewById(R.id.btndescribe);
        Button btnExit = findViewById(R.id.btnexit);
        final TextView info = findViewById(R.id.textView2);

        addPlayerFragment = new AddPlayerFragment();
        viewPlayerFragment = new ViewPlayerFragment();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                getSupportFragmentManager().beginTransaction().add(R.id.cointainer_frag,addPlayerFragment).commit();
                btnSubmit.setVisibility(View.INVISIBLE);
                btnDescribe.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().remove(addPlayerFragment).commit();
               btnSubmit.setVisibility(View.VISIBLE);
               btnDescribe.setVisibility(View.VISIBLE);
               info.setVisibility(View.VISIBLE);
            }
        });

        btnDescribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.cointainer_frag,viewPlayerFragment).commit();
                btnSubmit.setVisibility(View.INVISIBLE);
                btnDescribe.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void openDialog(){
        DialogLogic dialogLogic = new DialogLogic();
        dialogLogic.show(getSupportFragmentManager(),"example dialog");
    }

    public void closeAddFragment(int playerNumber){
        if(playerNumber==0) {
            getSupportFragmentManager().beginTransaction().remove(addPlayerFragment).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.cointainer_frag,viewPlayerFragment).commit();
        }
    }

    @Override
    public void applyNumber(int number) {
        playerNumber=number;
    }

}
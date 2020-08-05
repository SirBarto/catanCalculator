package gawron.b.catancalculatorjava;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogLogic extends AppCompatDialogFragment {

    private EditText editNumber;
    private DialogListener dialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog,null);

        builder.setView(view)
                .setTitle("Confirm")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        int number = Integer.parseInt(editNumber.getText().toString());
                        if(!editNumber.equals("")){
                            dialogListener.applyNumber(number);
                        }else {
                            Toast.makeText(getActivity(),"Enter the number 1-6",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        editNumber = view.findViewById(R.id.editTextNumberDecimal);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
        dialogListener = (DialogListener) context;
        }catch (ClassCastException e){
            throw  new ClassCastException(context.toString()+"must implement Diaglog");
        }
    }

    public interface DialogListener{
        void applyNumber(int number);
    }
}

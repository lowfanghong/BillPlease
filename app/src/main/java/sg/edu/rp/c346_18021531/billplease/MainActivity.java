package sg.edu.rp.c346_18021531.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText etAmount;
    EditText etPax;
    ToggleButton SVS;
    ToggleButton GST;
    EditText discount;
    TextView totalBill;
    TextView eachPay;
    Button split;
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = findViewById(R.id.editText2);
        etPax = findViewById(R.id.editText);
        SVS = findViewById(R.id.toggleButton2);
        GST = findViewById(R.id.toggleButton);
        discount = findViewById(R.id.editText3);
        totalBill = findViewById(R.id.textView4);
        eachPay = findViewById(R.id.textView5);
        split = findViewById(R.id.button3);
        reset = findViewById(R.id.button4);


        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = 0.0;
                if (!SVS.isChecked() && !GST.isChecked()){
                    amount = Double.parseDouble(etAmount.getText().toString());

                }else if (SVS.isChecked() && !GST.isChecked()){
                    amount = Double.parseDouble(etAmount.getText().toString()) * 1.1;

                }else if (!SVS.isChecked() && GST.isChecked()){
                    amount = Double.parseDouble(etAmount.getText().toString()) * 1.07;

                }else{
                    amount = Double.parseDouble(etAmount.getText().toString()) * 1.17;

                }
                if (discount.getText().toString().trim().length() !=0){
                    amount *= 1 - Double.parseDouble(discount.getText().toString())/100;
                }
                totalBill.setText("Total Bill: $" + String.format("%.2f",amount));
                int NoPerson = Integer.parseInt(etPax.getText().toString());
                if (NoPerson != 1){
                    eachPay.setText("Each Pays: $"+String.format("%.2f",amount/NoPerson));
                }else{
                    eachPay.setText("Each Pays: $"+amount);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAmount.setText("");
                etPax.setText("");
                discount.setText("");
                totalBill.setText("");
                eachPay.setText("");
            }
        });

    }
}

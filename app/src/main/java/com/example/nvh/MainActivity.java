package com.example.nvh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncancle = (Button) findViewById(R.id.btncancle);
        Button btnbook = (Button) findViewById(R.id.btnbook);
        final EditText editten = (EditText)findViewById(R.id.txtten);
        final EditText editsdt = (EditText)findViewById(R.id.txtsdt);
        final CheckBox chk1 = (CheckBox)findViewById(R.id.checkBox);
        final RadioButton rbvip = (RadioButton)findViewById(R.id.rbtnvip);
        final RadioButton rbthuong = (RadioButton)findViewById(R.id.rbtnthuong);
        final RadioButton rbgiuong = (RadioButton)findViewById(R.id.rbtngiuong);
        final RadioButton rbghe = (RadioButton)findViewById(R.id.rbtnghe);
        final Spinner spintt = (Spinner)findViewById(R.id.spinner);


        List<String> lan_array =  new ArrayList<String>();
        lan_array.add("USD");
        lan_array.add("VND");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lan_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spintt.setAdapter(adapter);

        btnbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String msg = "Tên: " + editten.getText().toString()+
                        System.getProperty("line.separator")+"SĐT: " + editsdt.getText().toString()
                        + System.getProperty("line.separator") + "Thành viên: ";

                editten.setText("");
                editsdt.setText("");

                if(rbvip.isChecked())
                    msg += rbvip.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";
                    msg += "Giam giá 30%: " + System.getProperty("line.separator");

                if(rbthuong.isChecked())
                    msg += rbthuong.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";

                if(rbgiuong.isChecked())
                    msg += rbgiuong.getText().toString() + System.getProperty("line.separator") +"Dịch vụ";
                if(rbghe.isChecked())
                    msg += rbghe.getText().toString() + System.getProperty("line.separator") +"Dịch vụ";

                if(chk1.isChecked())
                    msg += "Có";
                            else
                                msg += "Không";
                            rbvip.setChecked(false);
                            rbthuong.setChecked(false);
                            rbgiuong.setChecked(false);
                            rbghe.setChecked(false);

                            msg += System.getProperty("line.separator") + "Hình thức thanh toán: " + spintt.getSelectedItem().toString() + System.getProperty("line.separator") +
                                    "Cảm ơn quý khách đã sử dụng dịch vụ !";
                            info(v,msg);

            }
        });
    }
    public void info(View v,String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông tin");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    public void cancel(View v){
        System.exit(0);
    }
}

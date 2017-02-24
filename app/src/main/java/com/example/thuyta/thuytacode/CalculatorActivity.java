package com.example.thuyta.thuytacode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    String trai = "", phai = "";
    boolean chuyen = false;
    TextView txtKetQua;
    String action="";
    private Button btnClearn;
    Button btnNghichDao, btnGiaiThua, btnCanBac2, btnCanBacYCuaX, btnMu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

            txtKetQua=(TextView)findViewById(R.id.txtKetQua);
            btnClearn=(Button)findViewById(R.id.btnXoa);
            btnClearn.setOnClickListener(this);

            btnNghichDao=(Button)findViewById(R.id.btnNghichDao);
            btnNghichDao.setOnClickListener(this);

            btnGiaiThua=(Button)findViewById(R.id.btnGiaiThua);
            btnGiaiThua.setOnClickListener(this);

            btnMu2=(Button)findViewById(R.id.btnMu2);
            btnMu2.setOnClickListener(this);

            btnCanBac2=(Button)findViewById(R.id.btnCanBacHai);
            btnCanBac2.setOnClickListener(this);



        }


        //Cach 2:
    public void onNumber_Click(View view) {
        String nb=((Button)view).getText().toString();
        if(!chuyen){
            trai+=nb;
            txtKetQua.setText(trai);
        }

        else {
            phai+=nb;
            txtKetQua.setText(phai);
        }
    }

    public void onAction_Click(View view) {
        switch (view.getTag().toString()){
            case "1":
            case "2":
            case "3":
            case "4":
            case "6":
            case "12":
                chuyen=true;
                action=((Button)view).getTag().toString();
                break;
            case "5":
                thucHienPhepBang(action);

        }
    }

    //    private View.OnClickListener onNghichDao=new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            double kqua=0;
//            double _vtrai=Double.valueOf(trai);
//            kqua=1/_vtrai;
//            txtKetQua.setText(String.valueOf(kqua));
//            trai=String.valueOf(kqua);
//        }
//    };
    private void thucHienPhepBang(String action){
        double kqua=0;
        double _trai=Double.valueOf(trai);
        double _phai=Double.valueOf(phai);
        switch (action){
            case "1":
                kqua=_trai+_phai;
                break;
            case "2":
                kqua=_trai-_phai;
                break;
            case "3":
                kqua=_trai*_phai;
                break;
            case "4":
                kqua=_trai/_phai;
                break;
            case "6":
                kqua=Math.pow(_trai,_phai);
                break;
            case "12":
                kqua=Math.pow(_trai,(1/_phai));
                break;

        }
        txtKetQua.setText(String.valueOf(kqua));
        trai=String.valueOf(kqua);
        phai="";
        chuyen=false;
    }

    @Override
    public void onClick(View view) {
        double kqua=0;
        double _vtrai=Double.valueOf(trai);
        switch (view.getId()){
            case R.id.btnXoa:
                trai="";
                phai="";
                chuyen=false;
                txtKetQua.setText("");
                break;
            case R.id.btnNghichDao:
                if(_vtrai==0){
                    txtKetQua.setText("Loi");
                }
                else {
                    kqua = 1 / _vtrai;
                    txtKetQua.setText(String.valueOf(kqua));
                    trai = String.valueOf(kqua);
                }
                break;
            case R.id.btnGiaiThua:
                kqua=giaThua(_vtrai);
                txtKetQua.setText(String.valueOf(kqua));
                trai=String.valueOf(kqua);
                break;
            case R.id.btnMu2:
                kqua=Math.pow(2,_vtrai);
                txtKetQua.setText(String.valueOf(kqua));
                trai=String.valueOf(kqua);
                break;
            case R.id.btnCanBacHai:
                kqua=Math.sqrt(_vtrai);
                txtKetQua.setText(String.valueOf(kqua));
                trai=String.valueOf(kqua);
                break;
        }

    }


    private double giaThua(double x){
        double gt=1;
        for (int i=1;i<=x;i++){
            gt*=i;
        }
        return gt;
    }
}

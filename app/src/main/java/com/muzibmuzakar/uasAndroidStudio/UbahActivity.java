package com.muzibmuzakar.uasAndroidStudio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Ahmad Abu Hasan on 29/12/2020
 */

public class UbahActivity extends AppCompatActivity {

    // implementasi
    private EditText editText_kode, editText_name, editText_detail;
    // untuk menerima Data dari MainActivity
    private String edit_name, edit_detail;
    private int edit_id, edit_kode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_update);

        // deklarasi
        editText_kode = findViewById(R.id.et_kode);
        editText_name = findViewById(R.id.et_name);
        editText_detail = findViewById(R.id.et_detail);
        Button btn_save = findViewById(R.id.save_add_edit);

        // mengubah text pada buttom
        btn_save.setText(R.string.update);

        // menerima data dari MainActivity menggunakana "Bundle"
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            edit_id = intent.getInt("edit_id");
            edit_kode = intent.getInt("edit_kode");
            edit_name = intent.getString("edit_name");
            edit_detail = intent.getString("edit_detail");
        }

        // lalu "Bundle" ini, akan di set ke edittext
        editText_kode.setText(String.valueOf(edit_kode));
        editText_name.setText(edit_name);
        editText_detail.setText(edit_detail);

        // memberi action pada floating action buttom
        btn_save.setOnClickListener(v -> {
            // mengambil text dalam edittext
            String kode = editText_kode.getText().toString();
            String name = editText_name.getText().toString();
            String detail = editText_detail.getText().toString();

            // validasi nim, name dan class tidak boleh kosong
            if (kode.isEmpty()) { // kode_barang tidak lebih dari 9 digit
                Toast.makeText(UbahActivity.this, "NIM Still Empty!", Toast.LENGTH_SHORT).show();
            } else if (name.isEmpty()) {
                Toast.makeText(UbahActivity.this, "Name Still Empty!", Toast.LENGTH_SHORT).show();
            } else if (detail.isEmpty()) {
                Toast.makeText(UbahActivity.this, "Class Still Empty!", Toast.LENGTH_SHORT).show();
            } else {
                // mengupdate data
                updateData(edit_id, kode, name, detail);
            }
        });
    }

    private void updateData(int id, String kode, String name, String detail) {
        String url = ApiClient.URL_UPDATE;
        // buat StringRequest volley dan jangan lupa requestnya POST "Request.Method.POST"
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            // menerapkan ke model class menggunakan GSON
            // mengkonversi JSON ke java object
            ResponStatus responStatus = new Gson().fromJson(response, ResponStatus.class);
            int status_kode = responStatus.getStatus_kode();
            String status_pesan = responStatus.getStatus_pesan();

            // jika respon status kode yg dihasilkan 1 maka berhasil
            if (status_kode == 1) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
                MainActivity.mInstance.MuatData(); // memanggil MainActivity untuk memproses method MemuatData()
                finish(); // keluar
            } else if (status_kode == 2) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 3) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 4) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 5) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 6) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 7) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 8) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 9) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else if (status_kode == 10) {
                Toast.makeText(UbahActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(UbahActivity.this, "Status Kesalahan Tidak Diketahui!", Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            // jika respon tidak ditemukan maka akan menampilkan berbagai error berikut ini
            if (error instanceof TimeoutError) {
                Toast.makeText(UbahActivity.this, "Network TimeoutError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                Toast.makeText(UbahActivity.this, "Nerwork NoConnectionError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(UbahActivity.this, "Network AuthFailureError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(UbahActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NetworkError) {
                Toast.makeText(UbahActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(UbahActivity.this, "Parse Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(UbahActivity.this, "Status Error Tidak Diketahui!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                // set ke params
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id", String.valueOf(id));
                hashMap.put("kode", kode);
                hashMap.put("name", name);
                hashMap.put("detail", detail);

                return hashMap;
            }
        };

        // memanggil AppController dan menambahkan dalam antrin
        // text "edit_data" anda bisa mengganti inisial yang lain
        AppController.getInstance().addToQueue(request, "edit_data");
    }
}

package com.muzibmuzakar.uasAndroidStudio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Created by Ahmad Abu Hasan on 29/12/2020
 */

public class ModelPelajaran {

    @SerializedName("pel_id") //samakan dengan key/id yang akan kita ambil dari API
    @Expose
    private int pel_id;
    @SerializedName("pel_kode") //samakan dengan key/id yang akan kita ambil dari API
    @Expose
    private int pel_kode;
    @SerializedName("pel_name") //samakan dengan key/id yang akan kita ambil dari API
    @Expose
    private String pel_name;
    @SerializedName("pel_detail") //samakan dengan key/id yang akan kita ambil dari API
    @Expose
    private String pel_detail;

    public ModelPelajaran(int pel_id, int pel_kode, String pel_name, String pel_detail) {
        this.pel_id = pel_id;
        this.pel_kode = pel_kode;
        this.pel_name = pel_name;
        this.pel_detail = pel_detail;
    }

    public int getPel_id() {
        return pel_id;
    }

    public void setPel_id(int pel_kode) {
        this.pel_id = pel_id;
    }

    public int getPel_kode() {
        return pel_kode;
    }

    public void setPel_kode(int pel_kode) {
        this.pel_kode = pel_kode;
    }

    public String getPel_name() {
        return pel_name;
    }

    public void setPel_name(String pel_name) {
        this.pel_name = pel_name;
    }

    public String getPel_detail() {
        return pel_detail;
    }

    public void setPel_detail(String pel_detail) {
        this.pel_detail = pel_detail;
    }
}

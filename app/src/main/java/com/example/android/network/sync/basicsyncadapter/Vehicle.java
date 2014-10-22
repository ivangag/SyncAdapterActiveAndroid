package com.example.android.network.sync.basicsyncadapter;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Ivan on 22/10/2014.
 */
@Table(name = "Vehicle", id = BaseColumns._ID)
public class Vehicle extends Model {

    @Column(name = "VIN")
    private String VIN = "";

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}

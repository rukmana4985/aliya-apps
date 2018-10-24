package com.project.aliya.model.content;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by faizf on 7/11/2017.
 */
@Data
public class ModelEbookPremium {
    @SerializedName("id")
    private Integer idEbookPremium;
    @SerializedName("unique_code")
    private String uniqueCode;
    private String nama;
    private String password;
    @SerializedName("no_telp")
    private String noTelp;
    private String email;
    private String pendidikan;
    private String kota;
    private Integer total_price;
    @SerializedName("salesId")
    private Integer sales_id;
    @SerializedName("afilisasiId")
    private Integer afiliasi_id;
    @SerializedName("flagEarning")
    private Integer flag_earning;
    @SerializedName("amountEarning")
    private Integer amount_earning;
    @SerializedName("amountAuthor")
    private Integer amount_author;
    @SerializedName("amountIt")
    private Integer amount_it;
    @SerializedName("amountTerminalhrd")
    private Integer amount_terminalhrd;
    @SerializedName("amountZakat")
    private Integer amount_zakat;
    @SerializedName("dateEarning")
    private String date_earning;
    private Integer status;
    @SerializedName("dateCreated")
    private String date_created;
    @SerializedName("dateModified")
    private String date_modified;
}

package br.com.josuemleite.model;

import com.google.gson.annotations.SerializedName;

public record CurrencyPairConversion(@SerializedName("base_code") String baseCode,
                                     @SerializedName("target_code") String targetCode,
                                     @SerializedName("conversion_rate") String conversionRate,
                                     @SerializedName("conversion_result") String conversionResult) {
}

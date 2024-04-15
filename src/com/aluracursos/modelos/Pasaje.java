package com.aluracursos.modelos;

import com.google.gson.annotations.SerializedName;

public record Pasaje(@SerializedName("base_code") String baseCode,
                     @SerializedName("target_code") String targetCode,
                     @SerializedName("conversion_rate") double conversionRate,
                     @SerializedName("conversion_result") double conversionResult,
                     @SerializedName("result") String result,
                     @SerializedName("error-type") String errorType) {
}

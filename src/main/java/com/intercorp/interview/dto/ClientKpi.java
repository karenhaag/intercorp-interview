package com.intercorp.interview.dto;

import io.swagger.annotations.ApiModelProperty;

public class ClientKpi {
    @ApiModelProperty(name = "averageAge", dataType = "Double", example = "42.3")
    private Double averageAge;
    @ApiModelProperty(name = "standardDeviation", dataType = "Double", example = "5.5")
    private Double standardDeviation;

    public ClientKpi(){}

    public ClientKpi(Double averageAge, Double standardDeviation){
        this.averageAge = averageAge;
        this.standardDeviation = standardDeviation;
    }


    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}

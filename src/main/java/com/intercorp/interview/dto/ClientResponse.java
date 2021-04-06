package com.intercorp.interview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.intercorp.interview.model.ClientEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Calendar;
import java.util.Date;

public class ClientResponse extends Client{

    @ApiModelProperty(name = "id", dataType = "long", example = "1")
    private long id;
    @ApiModelProperty(name = "deathDate", dataType = "Date", example = "2010-04-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deathDate;

    public ClientResponse(){
        super();
    }

    public ClientResponse(ClientEntity client){
        super(client);
        this.id = client.getId();
        calculateDeathDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    private void calculateDeathDate(){
        int DAYS_OF_LIFE = 28835;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getBirthday());
        calendar.add(Calendar.DAY_OF_YEAR, DAYS_OF_LIFE);
        this.deathDate = calendar.getTime();
    }
}

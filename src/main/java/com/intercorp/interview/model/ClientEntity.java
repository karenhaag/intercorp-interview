package com.intercorp.interview.model;

import com.intercorp.interview.dto.Client;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CLIENT")
public class ClientEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;
        private String name;
        private String surname;
        private int age;
        private Date birthdate;

        public ClientEntity(){

        }

        public ClientEntity(Client client){
            this.name = client.getName();
            this.surname = client.getSurname();
            this.age = client.getAge();
            this.birthdate = client.getBirthday();
        }


        public long getId(){ return id;}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
        }
}

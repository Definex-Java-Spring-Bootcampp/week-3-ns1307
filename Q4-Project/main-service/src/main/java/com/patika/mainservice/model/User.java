package com.patika.mainservice.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class User {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;//bir email ile bir kere kayıt olunabilir.
    private String password;//SHA-512 ile encrypt edilerek kaydedilir.
    private String phoneNumber;
    private Boolean isActive;

    public User() {

    }

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.password = encryptPassword(password);//password is saved with encryption
    }



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    private String encryptPassword(String password){
        try {
            // SHA-512 hash fonksiyonu ile bir MessageDigest örneği oluştur
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            // Metni byte dizisine dönüştür ve hash hesaplamasını yap
            byte[] encodedhash = digest.digest(password.getBytes());

            // Byte dizisini onaltılık (hex) formata dönüştür
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < encodedhash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedhash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-512 algoritması bulunamadı.");
            return "";
        }
    }

    public boolean checkPassword(String checkPassword){
        String encryptedPassword=encryptPassword(checkPassword);

        //check if saved, encrypted password and given, encrypted password are same.
        return encryptedPassword.equals(this.password);
    }

}

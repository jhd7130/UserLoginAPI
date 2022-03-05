package com.example.sessionClustering.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SignUpEntity {

    @Id
    @GeneratedValue(generator = "USER_GENERATOR")
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    private String userId;
    @Column
    private String userNm;

    @Column
    private String phone;

    @Column(length = 1024)
    private String address;

    @Column
    private String email;

    @Column
    private String password;

    public SignUpEntity() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserNm() {
        return this.userNm;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SignUpEntity)) return false;
        final SignUpEntity other = (SignUpEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$userNm = this.getUserNm();
        final Object other$userNm = other.getUserNm();
        if (this$userNm == null ? other$userNm != null : !this$userNm.equals(other$userNm)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SignUpEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $userNm = this.getUserNm();
        result = result * PRIME + ($userNm == null ? 43 : $userNm.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        return "SignUpEntity(userId=" + this.getUserId() + ", userNm=" + this.getUserNm() + ", phone=" + this.getPhone() + ", address=" + this.getAddress() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }
}

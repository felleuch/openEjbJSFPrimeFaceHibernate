package com.faiez.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
                  @NamedQuery(name = "user.list", query = "select u from User u")
              })
@XmlRootElement(name = "user")
public class User implements Cloneable {

    @Id
    @GeneratedValue
    private long id;


    private String fullname;


    private String password;


    private String email;

    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User copy() {
        User user = new User();
        user.setEmail(getEmail());
        user.setFullname(getFullname());
        user.setPassword(getPassword());
        user.setId(getId());
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !User.class.isAssignableFrom(o.getClass())) {
            return false;
        }

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

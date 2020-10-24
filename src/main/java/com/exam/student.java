/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Student
 */
@RequestScoped
@Named("student")
public class student {
    private int id;
    private String name;
    private String mobile;
    private String course;
    private String gender;
    private String[] skill;
    private String address;
    private Connection conn;
    
    public String store(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        conn= DBAccess.getConn();
        String sql="insert into studentinfo(id, name, mobile, course, gender, skill, address)"+"values(?,?,?,?,?,?,?)";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, mobile);
        pst.setString(4, course);
        pst.setString(5, gender);
        pst.setString(6, Arrays.toString(skill));
        pst.setString(7, address);
        int rs = pst.executeUpdate();
            if (rs > 0) {
                context.addMessage(null, new FacesMessage("Save successful"));
            } else {
                context.addMessage(null, new FacesMessage("Save failed!"));
            }
        }catch(SQLException ex){
            
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

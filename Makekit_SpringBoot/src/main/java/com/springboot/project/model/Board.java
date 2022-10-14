package com.springboot.project.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "qtbl_board")
@DynamicInsert
@DynamicUpdate 
@Data
public class Board {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "bno")
   private int bno;
   
   @Column(name = "title")
   private String title;
   
   @Column(name = "content")
   private String content;
   
   @Column(name = "writer")
   private String writer;
   
   @Column(name = "regdate")
   private Date regdate;
   public static LocalDateTime regdate() {
        return LocalDateTime.now().plusHours(9);
    }
   
   @Column(name = "updatedate")
   private Date updatedate;
   public static LocalDateTime updatedate() {
        return LocalDateTime.now().plusHours(9);
    }
   
// ---Getter/Setter ---
   
}
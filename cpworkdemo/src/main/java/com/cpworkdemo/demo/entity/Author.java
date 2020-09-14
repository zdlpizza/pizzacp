package com.cpworkdemo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "t_author")
public class Author {
    @Id
    @Column
    private Long id;
    @Column
    private String realName;
    @Column
    private String nickName;
    
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getRealName() {
//		return realName;
//	}
//	public void setRealName(String realName) {
//		this.realName = realName;
//	}
//	public String getNickName() {
//		return nickName;
//	}
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}

    // SET和GET方法略
    
}
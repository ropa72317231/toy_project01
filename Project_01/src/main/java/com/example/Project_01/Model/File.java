package com.example.Project_01.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "board")
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fileName;
	
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
}
package com.example.Project_01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_01.Model.Board;


public interface BoardRepository extends JpaRepository<Board, Long> {
	
	
}
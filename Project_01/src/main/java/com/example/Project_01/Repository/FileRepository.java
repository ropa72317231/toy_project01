package com.example.Project_01.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_01.Model.File;

public interface FileRepository extends JpaRepository<File, Long> {
	
	public Optional<File> findById(Long id);
}
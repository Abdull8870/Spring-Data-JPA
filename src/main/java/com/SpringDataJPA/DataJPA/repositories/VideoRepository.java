package com.SpringDataJPA.DataJPA.repositories;

import com.SpringDataJPA.DataJPA.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Integer> {
}

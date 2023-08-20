package com.example.realestateproject.Repository;

import com.example.realestateproject.Model.Agent;
import com.example.realestateproject.Model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings,Integer> {
}

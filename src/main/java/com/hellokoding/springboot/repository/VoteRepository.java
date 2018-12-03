package com.hellokoding.springboot.repository;

import com.hellokoding.springboot.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by orlov on 14.12.16.
 */
public interface VoteRepository extends JpaRepository<Vote,Integer> {
}

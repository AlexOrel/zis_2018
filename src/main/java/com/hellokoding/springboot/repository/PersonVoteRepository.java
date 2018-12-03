package com.hellokoding.springboot.repository;

import com.hellokoding.springboot.model.Person;
import com.hellokoding.springboot.model.PersonVote;
import com.hellokoding.springboot.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by orlov on 15.12.16.
 */
public interface PersonVoteRepository extends JpaRepository<PersonVote,Integer> {

    @Query("SELECT pv FROM PersonVote pv WHERE pv.vote = :vote AND pv.person = :person")
    PersonVote findByVoteAndPerson(@Param(value = "vote") Vote vote,
                            @Param(value = "person") Person person);


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query("Delete FROM PersonVote pv WHERE pv.vote = :vote AND pv.person = :person")
    void deleteByVoteAndPerson(@Param(value = "vote") Vote vote,
                                   @Param(value = "person") Person person);

}

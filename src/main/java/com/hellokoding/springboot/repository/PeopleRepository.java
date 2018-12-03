package com.hellokoding.springboot.repository;

import com.hellokoding.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by sanyaorel on 20.05.16.
 */
@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer>{

    @Query("SELECT p FROM Person p WHERE p IN (select pv.person from PersonVote pv where pv.voted=true)")
    List<Person> findAllVoted();

    @Query("SELECT p FROM Person p WHERE p IN (select pv.person from PersonVote pv where pv.voted=false)" +
            " OR p.personVotes.size=0")
    List<Person> findAllUnVoted();


    @Query("SELECT p FROM Person p WHERE p IN (select pv.person from PersonVote pv where pv.vote.id=:voteId)")
    List<Person> findByVote(@Param(value = "voteId") Integer voteId);


    @Query("SELECT p FROM Person p WHERE p IN (select pv.person from PersonVote pv where pv.vote.dateTime =:voteDate)")
    List<Person> findByVoteDate(@Param(value = "voteDate") Date date);


    @Query("SELECT p FROM Person p WHERE p IN (select pv.person from PersonVote pv where pv.vote.dateTime =:voteDate and pv.vote.address = :address)")
    List<Person> findByVoteDateAndAddress(@Param(value = "voteDate") Date date,@Param(value = "address") String address );

}

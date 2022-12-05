package com.keyin.pumpkinsv2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    List<Tournament> findByStartDateOrEndDate(String text, String anotherText);
}

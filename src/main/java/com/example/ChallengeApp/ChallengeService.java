package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private long nextId =  2 ;
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeService(){
        Challenge c1 = new Challenge(1l , "March" , "Read books");
        challenges.add(c1);
    }

    public List<Challenge> getCahllenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge cchallenge) {
        if (cchallenge != null) {
            cchallenge.setId(nextId++);
            challenges.add(cchallenge);
            return true;
        }
        else {
            return false;
        }
    }

    public Challenge getChallenge(String month) {
        for(Challenge ch : challenges){
            if(ch.getMonth().equalsIgnoreCase(month)){
                return ch;
            }
        }
        return null;
    }

    public boolean updatedChallenge(long id, Challenge updatedChallenge) {
        for(Challenge ch : challenges){
            if(ch.getId()==id){
                ch.setMonth(updatedChallenge.getMonth());
                ch.setDescription(updatedChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId() == id);
    }
}

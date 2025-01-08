package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // @Service Indicates that this class contains business logic.
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

    public boolean addChallenge(Challenge cchallenge) { //from @RequestBody
        if (cchallenge != null) {
            cchallenge.setId(nextId++);
            challenges.add(cchallenge);
            return true;
        }
        else {
            return false;
        }
    }

    public Challenge getChallenge(String month) { //@pathVariable - Captures the month variable from the URL.
        for(Challenge ch : challenges){
            if(ch.getMonth().equalsIgnoreCase(month)){
                return ch;
            }
        }
        return null;
    }

    public boolean updatedChallenge(long id, Challenge updatedChallenge) { //@pathVariable - Captures id variable from the URL. @RequestBody Binds the request body to a Challenge object... from user
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

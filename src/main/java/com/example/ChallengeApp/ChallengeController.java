package com.example.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    //private List<Challenge> challenges = new ArrayList<>();
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
//        Challenge c1 = new Challenge(1L , "Jan" , "Go to Gym");
//        challenges.add(c1);
        this.challengeService = challengeService;
        //challengeService = new ChallengeService();
    }

     //

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getChallenges(){
        //return challenges;
        return  new ResponseEntity<>(challengeService.getCahllenges(),HttpStatus.OK);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month){
        //return challenges;
//        return challengeService.getCahllenges();
//        return challengeService.getCahllenge(month);
        Challenge ch = challengeService.getChallenge(month);
        if(ch != null){
            return new ResponseEntity<> (ch , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/challenges") // has request body..
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded =  challengeService.addChallenge(challenge);
        if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not added ", HttpStatus.NOT_FOUND);

    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge (@PathVariable Long id ,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updatedChallenge(id , updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not updated ", HttpStatus.NOT_FOUND);


    }


    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id ) {
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge deleted succesfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not deleted ", HttpStatus.NOT_FOUND);

    }


}

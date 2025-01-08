package com.example.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //handling HTTP requests and returning JSON responses. Marks the class as a REST controller, capable of handling HTTP requests.
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {  //Constructor Injection: Spring injects the ChallengeService instance into the controller when the application starts. This is a common way to inject dependencies in Spring.
        this.challengeService = challengeService;
    }


    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getChallenges(){
        return  new ResponseEntity<>(challengeService.getCahllenges(),HttpStatus.OK);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month){ //@pathVariable - Captures the month variable from the URL.
        Challenge ch = challengeService.getChallenge(month);
        if(ch != null){
            return new ResponseEntity<> (ch , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/challenges") // has request body..
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){ //@RequestBody - Binds the request body to a Challenge object. fromuser input 
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

package com.codeup.springblog.controllers;

import com.codeup.springblog.services.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {


    @GetMapping("/roll-dice")
    @ResponseBody
    public String guess() {
        return "Guess the number the dice will role (from 1 - 6)" +
                "<br>" +
                "<ul>\n" +
                "  <li><a href=\"/roll-dice/1\">1</a></li>\n" +
                "  <li><a href=\"/roll-dice/2\">2</a></li>\n" +
                "  <li><a href=\"/roll-dice/3\">3</a></li>\n" +
                "  <li><a href=\"/roll-dice/4\">4</a></li>\n" +
                "  <li><a href=\"/roll-dice/5\">5</a></li>\n" +
                "  <li><a href=\"/roll-dice/6\">6</a></li>\n" +
                "</ul>";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String rollDice(@PathVariable int n) {
        Dice dice = new Dice(6);
        int numberRolled = dice.roll();

        int userGuess = n;

        if(userGuess == numberRolled) {
            return "<p>The die rolled a " + numberRolled + "</p>\n" +
                    "<br>\n" +
                    "<p>You guessed " + userGuess + "</p>\n" +
                    "<br>\n" +
                    "<p>You guessed correctly!</p>";
        } else {
            return "<p>The die rolled a " + numberRolled + "</p>\n" +
                    "<br>\n" +
                    "<p>You guessed " + userGuess + "</p>\n" +
                    "<br>\n" +
                    "<p>You guessed incorrectly!</p>";
        }


    }










}

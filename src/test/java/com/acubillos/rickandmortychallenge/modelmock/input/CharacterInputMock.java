package com.acubillos.rickandmortychallenge.modelmock.input;

import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.CharacterInput;

import java.util.ArrayList;
import java.util.List;

public class CharacterInputMock {
    public static CharacterInput createACharacterMock() {
        CharacterInput input = new CharacterInput();
        input.setId(1);
        input.setName("Rick Sanchez");
        input.setStatus("Alive");
        input.setSpecies("Human");
        input.setType("");
        input.setGender("Male");
        input.setLocation(LocationInputMock.createsLocation());
        input.setOrigin(LocationInputMock.createsOrigin());
        input.setImage("https://rickandmortyapi.com/api/character/avatar/1.jpeg");
        input.setEpisode(getEpisodes());
        input.setUrl("https://rickandmortyapi.com/api/character/1");
        input.setCreated("2017-11-04T18:48:46.250Z");
        return input;
    }

    private static List<String> getEpisodes() {
        ArrayList<String> episodes = new ArrayList<>();
        episodes.add("https://rickandmortyapi.com/api/episode/1");
        episodes.add("https://rickandmortyapi.com/api/episode/2");
        episodes.add("https://rickandmortyapi.com/api/episode/3");
        episodes.add("https://rickandmortyapi.com/api/episode/4");
        episodes.add("https://rickandmortyapi.com/api/episode/5");
        episodes.add("https://rickandmortyapi.com/api/episode/6");
        episodes.add("https://rickandmortyapi.com/api/episode/7");
        episodes.add("https://rickandmortyapi.com/api/episode/8");
        episodes.add("https://rickandmortyapi.com/api/episode/9");
        episodes.add("https://rickandmortyapi.com/api/episode/10");
        episodes.add("https://rickandmortyapi.com/api/episode/11");
        episodes.add("https://rickandmortyapi.com/api/episode/12");
        episodes.add("https://rickandmortyapi.com/api/episode/13");
        episodes.add("https://rickandmortyapi.com/api/episode/14");
        episodes.add("https://rickandmortyapi.com/api/episode/15");
        episodes.add("https://rickandmortyapi.com/api/episode/16");
        episodes.add("https://rickandmortyapi.com/api/episode/17");
        episodes.add("https://rickandmortyapi.com/api/episode/18");
        episodes.add("https://rickandmortyapi.com/api/episode/19");
        episodes.add("https://rickandmortyapi.com/api/episode/20");
        episodes.add("https://rickandmortyapi.com/api/episode/21");
        episodes.add("https://rickandmortyapi.com/api/episode/22");
        episodes.add("https://rickandmortyapi.com/api/episode/23");
        episodes.add("https://rickandmortyapi.com/api/episode/24");
        episodes.add("https://rickandmortyapi.com/api/episode/25");
        episodes.add("https://rickandmortyapi.com/api/episode/26");
        episodes.add("https://rickandmortyapi.com/api/episode/27");
        episodes.add("https://rickandmortyapi.com/api/episode/28");
        episodes.add("https://rickandmortyapi.com/api/episode/29");
        episodes.add("https://rickandmortyapi.com/api/episode/30");
        episodes.add("https://rickandmortyapi.com/api/episode/31");
        episodes.add("https://rickandmortyapi.com/api/episode/32");
        episodes.add("https://rickandmortyapi.com/api/episode/33");
        episodes.add("https://rickandmortyapi.com/api/episode/34");
        episodes.add("https://rickandmortyapi.com/api/episode/35");
        episodes.add("https://rickandmortyapi.com/api/episode/36");
        episodes.add("https://rickandmortyapi.com/api/episode/37");
        episodes.add("https://rickandmortyapi.com/api/episode/38");
        episodes.add("https://rickandmortyapi.com/api/episode/39");
        episodes.add("https://rickandmortyapi.com/api/episode/40");
        episodes.add("https://rickandmortyapi.com/api/episode/41");
        episodes.add("https://rickandmortyapi.com/api/episode/42");
        episodes.add("https://rickandmortyapi.com/api/episode/43");
        episodes.add("https://rickandmortyapi.com/api/episode/44");
        episodes.add("https://rickandmortyapi.com/api/episode/45");
        episodes.add("https://rickandmortyapi.com/api/episode/46");
        episodes.add("https://rickandmortyapi.com/api/episode/47");
        episodes.add("https://rickandmortyapi.com/api/episode/48");
        episodes.add("https://rickandmortyapi.com/api/episode/49");
        episodes.add("https://rickandmortyapi.com/api/episode/50");
        episodes.add("https://rickandmortyapi.com/api/episode/51");
        return episodes;
    }
}

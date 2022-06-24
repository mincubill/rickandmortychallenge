package com.acubillos.rickandmortychallenge.modelmock.entity;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.entity.Location;

import java.util.ArrayList;

public class CharacterMock {
    public static Character createACharacter() {
        return new Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "",
                "Male",
                getCharacterEpisodes(),
                new Location(
                        1,
                        "Earth (C-137)",
                        "Planet",
                        "Dimension C-137",
                        "https://rickandmortyapi.com/api/location/1",
                        new ArrayList<>()
                ),
                new Location(
                        3,
                        "Citadel of Ricks",
                        "Space station",
                        "unknown",
                        "https://rickandmortyapi.com/api/location/3",
                        new ArrayList<>()
                )
        );
    }

    private static ArrayList<String> getCharacterEpisodes() {
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

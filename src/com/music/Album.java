package com.music;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumName;
    private String artistName;

    private List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        songList = new ArrayList<>();
    }

    public boolean findSong(String title){

        for(Song song: songList) {
            if(song.getSongTitle().equals(title))
                return true;
        }
        return false;
    }

    public String addNewSongToPlayList(String title,double duration){


        //Check if song is already present : return
        if(findSong(title)==false){
            Song newSong = new Song(title,duration);
            songList.add(newSong);
            return "Song has been added to the playList";
        }else {
            return "Song is already present";
        }
        //Crate a new Song with the give parameters
        //Add it to the playList
    }

    public void addSongToPlayList(int songNo,List<Song> playList){

        //Song No is a 1 based indexing
        // list Index is a 0 based indexing

        int index = songNo - 1;
        if(index<=songList.size()-1){
            Song song = songList.get(index);
            playList.add(song);
        }
    }

    public void addSongToPlayList(String title,List<Song>playList){

        //We will iterate the SongList : Album List and check if the title is matching
        for(Song song:songList){
            if(song.getSongTitle().equals(title)){
                playList.add(song);
                return;
            }
        }

    }







}

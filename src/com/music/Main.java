package com.music;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int currentSongIndex = 0;
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        Album diljitAlbum = new Album("Moon Child Era","Diljit Dosanjh");

        diljitAlbum.addNewSongToPlayList("Vibe",2.36);
        diljitAlbum.addNewSongToPlayList("Lover",3.10);
        diljitAlbum.addNewSongToPlayList("Luna",2.45);

        Album arijitAlbum = new Album("Hindi Hit Song","Arijit Songs");

        arijitAlbum.addNewSongToPlayList("Kesariya",2.3);
        arijitAlbum.addNewSongToPlayList("Shayad",4.3);
        arijitAlbum.addNewSongToPlayList("Tum hi ho",2.3);
        arijitAlbum.addNewSongToPlayList("Muskurane ki wajah",2.3);
        arijitAlbum.addNewSongToPlayList("Chaleya",2.3);



        List<Song> playList = new ArrayList<>();
        diljitAlbum.addSongToPlayList(1,playList);
        diljitAlbum.addSongToPlayList("Luna",playList);
        arijitAlbum.addSongToPlayList(3,playList);
        arijitAlbum.addSongToPlayList("Chaleya",playList);

        printMenu(playList);

    }

    public static void printMenu(List<Song>playList) {

        Scanner sc=new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("_________Menu__________");
            System.out.println("1. Play Next Song");
            System.out.println("2. Play Previous Song");
            System.out.println("3. Repeat the Song");
            System.out.println("4. Shuffle the PlayList");
            System.out.println("5. Delete the current Song");
            System.out.println("6. View the PlayList");
            System.out.println("7. Exit the Application");
            System.out.println("Enter the Choice...");

            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    playNextSong(playList);
                    break;
                case 2:
                    playPreviousSong(playList);
                    break;
                case 3:
                    repeatCurrentSong(playList);
                    break;
                case 4:
                    shufflePlaylist(playList);
                    break;
                case 5:
                    deleteCurrentSong(playList);
                    break;
                case 6:
                    viewPlaylist(playList);
                    break;
                case 7:
                    System.out.println("Exiting the application. Thank you for using Listenfy !!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }


        }
        while (choice!=7);

    }
    public static void playNextSong(List<Song>playList)
    {
        if (!playList.isEmpty())
        {
            currentSongIndex = (currentSongIndex + 1) % playList.size();
            Song nextSong = playList.get(currentSongIndex);
            System.out.println("Playing Song: " + nextSong.getSongTitle());
        } else
        {
            System.out.println("Playlist is Empty!");
        }
    }
    public static void playPreviousSong(List<Song>playList)
    {
        if (!playList.isEmpty()) {
            currentSongIndex = (currentSongIndex - 1 + playList.size()) % playList.size();
            Song previousSong = playList.get(currentSongIndex);
            System.out.println("Playing Song: " + previousSong.getSongTitle());
        } else {
            System.out.println("Playlist is Empty !!");
        }
    }
    public static void repeatCurrentSong(List<Song>playList)
    {
        if (!playList.isEmpty()) {
            Song currentSong = playList.get(currentSongIndex);
            System.out.println("Repeating Song: " + currentSong.getSongTitle());
        } else {
            System.out.println("Playlist is Empty !! ");
        }

    }
    public static void shufflePlaylist(List<Song>playList)
    {

        if (!playList.isEmpty()) {
            Collections.shuffle(playList);
            System.out.println("Playlist shuffled successfully !!");
        } else {
            System.out.println("Playlist is empty. Nothing to shuffle !!");
        }

    }
    public static void deleteCurrentSong(List<Song>playList)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the song name ");
        String title=sc.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < playList.size(); i++)
        {
            if (playList.get(i).getSongTitle().equalsIgnoreCase(title))
            {
                playList.remove(i);
                found = true;
                System.out.println(title+" is deleted successfully !!");
                break;
            }
        }
        if (!found)
        {
            System.out.println("Song " + title + " not found in the playlist !!");
        }
    }



    public static void viewPlaylist(List<Song>playList)
    {
        if(playList.isEmpty())
        {
            System.out.println("PlayList is Empty !!");
        }
        else
        {
            System.out.println("________PlayList__________");
            for(int i=0;i<playList.size();i++)
            {
                Song song=playList.get(i);
                System.out.println((i+1)+" Title "+song.getSongTitle()+" Duration "+song.getDuration());
            }
        }
    }

}

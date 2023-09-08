/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Score 
{
    List<ScoreData> records;
    private UserInput userInput;
    private LocalDate date;
    
    private int score;
    
    public Score() throws IOException
    {
        this.records = readFile();
        userInput = new UserInput();
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public void incrementScore()
    {
        this.score++;
    }
    
    public List<ScoreData> getRecords()
    {
        return this.records;
    }
    
    public String getDate()
    {
        return this.date.now().toString();
    }
            
    public void resetScore()
    {
        this.score = 0;
    }
    
    public static String getTimeStamp()
    {
        // Returns the current timestamp
        
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        
        return timeStamp;
    }
    
    
    public void addUserScore(Player player) 
    {
        // Checks to see if the player already exists, and adds the player to the records if not
        // If the player already exists, player is prompted to play as that player or override progress
        
        ScoreData playerData = new ScoreData(player.getName(), player.getScore());

        if (this.containsPlayer(playerData)) 
        {
            if (this.userInput.isExistingPlayer(player)) 
            {
                player.score = getScoreByPlayer(playerData);
                this.updateScores(this.getRecords());
                return;
            }
            System.out.println();
        } 
        
        else 
        {
            this.getRecords().add(playerData);
            this.updateScores(this.getRecords());
        }
    }

    private boolean containsPlayer(ScoreData playerData) 
    {
        for (ScoreData data : this.getRecords()) 
        {
            if (data.getName().equals(playerData.getName())) 
            {
                return true;
            }
        }
        return false;
    }

    private int getScoreByPlayer(ScoreData playerData) 
    {
        for (ScoreData data : this.getRecords()) 
        {
            if (data.getName().equals(playerData.getName())) 
            {
                return data.getScore();
            }
        }
        return 0;
    }
 
    
    public static List<ScoreData> readFile() throws FileNotFoundException, IOException
    {
        // Reads the scores.txt file and stores the name and score into a list
        
        List<ScoreData> list = new ArrayList<>();
        
        FileReader fr = new FileReader("./resources/scores.txt");
        BufferedReader inputStream = new BufferedReader(fr);
        
        String line = null;
        while((line = inputStream.readLine()) != null)
        {
            String str[] = line.split(" ");
            list.add(new ScoreData(str[0], Integer.parseInt(str[1])));
        }
        
        return list;
    }
    
    public void updateScores(List<ScoreData> records)
    {
        // Stores the contents of the records (name and score) to the scores.txt file
        
        PrintWriter pw = null;
        
        try
        {
            pw = new PrintWriter(new FileOutputStream("./resources/scores.txt"));
            
        } catch (FileNotFoundException e) {
            
            System.out.println(e.getMessage());
        }

        for(ScoreData scoreData : records)
        {
            pw.println(scoreData.getName() + " " + scoreData.getScore());
        }
        
        pw.close();
    }
    
    public void addWin(Player player)
    {
        // Increments the players score and updates this in the records and score.txt file
        
        player.incrementScore();
        
        for(ScoreData data : this.getRecords())
        {
            if(player.getName().equals(data.getName()))
            {
                data.setScore(player.getScore());
            }
        }
        
        this.updateScores(this.getRecords());
    }

    public void printScores() 
    {
        // Prints the player names and scores in order of the most points
        
        System.out.println("\n====== High Scores =====");
        
        Collections.sort(this.getRecords());
        
        for(ScoreData data : this.getRecords())
        {
            String scoreOutput = " " + data.getName() + this.getSpace(data.getName()) + data.getScore();
            System.out.println(scoreOutput);
        }
        
        if(this.isScoreEmpty())
        {
            System.out.println("(empty)");
        }
        
        System.out.println("========================");
    }
    
    public String getSpace(String name)
    {
        // Returns a number of spaces to ensure the score numbers are aligned
        
        int n = 10 - name.length();
        String space = " ";
        return space.repeat(n);
    }
    
    public void clearScoreBoard()
    {
        // Removes all entries from the scoreboard and the score.txt file
        
        this.getRecords().clear();
        this.updateScores(this.getRecords());
        System.out.println("\nScoreboard has been cleard...\n");
    }
    
    public boolean isScoreEmpty()
    {
        // Checks to see if the scoreboard is empty
        
        return this.getRecords().isEmpty();
    }
}


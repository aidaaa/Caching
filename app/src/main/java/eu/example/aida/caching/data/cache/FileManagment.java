package eu.example.aida.caching.data.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by Aida on 1/20/2019.
 */

public class FileManagment
{
    //read
    //write

    //last read
    //last write

    //exist


    public FileManagment() {
    }

    public void writeJsonDataMovie(File name, String s)
    {
        if (isExist(name))
        {
            FileWriter writer = null;
            try
            {
                //append=false --->write from first
                //append=true --->write from last

                writer = new FileWriter(name, false);
                writer.write(s);
                writer.flush();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (writer != null)
                {
                    try
                    {
                        writer.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String readJsonDataMovie(File name)
    {
        StringBuilder builder=new StringBuilder();
        if (isExist(name))
        {
            try
            {
                String read;
                FileReader fileReader = new FileReader(name);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                read = bufferedReader.readLine();
                while (read != null)
                {
                    builder.append(read);
                }
                fileReader.close();
                bufferedReader.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    public void lastWrite(File name)
    {
        FileWriter writer=null;
        if (isExist(name))
        {
        try
        {
            writer=new FileWriter(name);
            long currentTime=System.currentTimeMillis();
            writer.write(String.valueOf(currentTime));
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        }
    }

    public long lastRead(File name)
    {
        StringBuilder builder=new StringBuilder();
        long currentTime=0;
        if (isExist(name))
        {
            try
            {
                String read;
                FileReader fileReader = new FileReader(name);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                try
                {
                    read = bufferedReader.readLine();
                    while (read != null)
                    {
                        builder.append(read);
                    }
                    currentTime = Long.parseLong(builder.toString());
                    fileReader.close();
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return currentTime;
    }

    public boolean isExist(File name)
    {
        return name.exists();
    }
}

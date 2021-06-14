package com.example.SAdemo;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  
import java.io.*;
import java.lang.*;
import java.util.*;
@RestController  
public class SampleJavaController {
    String line;
    ArrayList <String> list = new ArrayList<String>();
    @RequestMapping(method=RequestMethod.GET, path="/abc")  
    public ArrayList <String> scservernameslist()  
    {  
        String[] command ={"cmd.exe", "/c", "sc", "query", "|", "find",  "\"SERVICE_NAME\""};
       
        try 
        {
            Process process = new ProcessBuilder(command).start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) 
            {
                list.add(bufferedReader.readLine());
            }
             
            	System.out.println(list);
        }
        catch(Exception ex) {
            System.out.println("Exception : "+ex);
        }
        return list;
        
    } 
}  

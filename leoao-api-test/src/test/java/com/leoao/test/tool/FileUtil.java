package com.leoao.test.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    
    private static int EXT_Other = 0;
    private static int EXT_Photo = 1;
    private static int EXT_Video = 5;
    private static int EXT_Music = 6;
    
    public static int getFileType (String filePath) throws Exception {       
        String ext = filePath.substring(filePath.lastIndexOf(".")+1,filePath.length()); //get the extentions of file
        //System.out.println(ext);
        int fileType = EXT_Other;
        if (ext.equalsIgnoreCase("mp4") | ext.equalsIgnoreCase("m4v")|ext.equalsIgnoreCase("3gpp")|
                ext.equalsIgnoreCase("3gp")|ext.equalsIgnoreCase("3g2")|ext.equalsIgnoreCase("wmv")|
                ext.equalsIgnoreCase("mkv")|ext.equalsIgnoreCase("3gpp2"))      
            fileType = EXT_Video ;
            
            
        else if (ext.equalsIgnoreCase("jpg") | ext.equalsIgnoreCase("jpeg")|ext.equalsIgnoreCase("gif")|
                ext.equalsIgnoreCase("png")|ext.equalsIgnoreCase("bmp")|ext.equalsIgnoreCase("wbmp"))
            fileType = EXT_Photo ;
    
        else if (ext.equalsIgnoreCase("mp3") | ext.equalsIgnoreCase("m4a")|ext.equalsIgnoreCase("wav")|
                ext.equalsIgnoreCase("amr")|ext.equalsIgnoreCase("awb")|ext.equalsIgnoreCase("wma")|
                ext.equalsIgnoreCase("ogg")|ext.equalsIgnoreCase("mid")|ext.equalsIgnoreCase("xmf")|
                ext.equalsIgnoreCase("rtttl")|ext.equalsIgnoreCase("smf")|ext.equalsIgnoreCase("imy"))
            fileType = EXT_Music ;
        return fileType;
    }
    
    public static Map<Integer, String> readfile(String filepath, Map<Integer, String> pathMap) 
            throws Exception {
        if (pathMap==null)
            pathMap = new HashMap <Integer,String>();
        
        File file = new File(filepath);
        if (!file.isDirectory()&!file.isHidden()) {         
               pathMap.put(pathMap.size(), file.getPath());
        } else if (file.isDirectory()) { // 
            String[] filelist = file.list(); 
            for (int i = 0; i < filelist.length; i++) { 
                File readfile = new File(filepath + "/" + filelist[i]); 
                if (!readfile.isDirectory()&!readfile.isHidden()) {
                        pathMap.put(pathMap.size(), readfile.getPath());
                } else if (readfile.isDirectory()) { //
                    readfile(filepath + "/" + filelist[i], pathMap); 
                } 
            } 
        } 
        return pathMap;
    }   
    
    public static void cutFile(String filepath,long blockSize) throws Exception {
        File file = new File(filepath);
        long fileSize = file.length();
        long writeTotal = 0 ;
        long writeSize = 0;
        //String fileName = file.getName();
        //System.out.println(fileSize);
        //System.out.println(fileName);
        long blockNum = fileSize / blockSize + 1;
        //System.out.println(blockNum);
        for (int i = 1 ; i <= blockNum ; i++){
            String blockName = filepath.substring(0, filepath.lastIndexOf("."))+".part"+ String.valueOf(i);
            //System.out.println(blockName);
        
            if (i < blockNum)
                writeSize = blockSize;
            else 
                writeSize = fileSize - writeTotal;
            writeFile(filepath,blockName,writeSize,writeTotal);
            File blockfile = new File(blockName);
            String sets = "attrib +H \"" + blockfile.getAbsolutePath() + "\""; 
             
            //System.out.println(sets); 
             //  
            Runtime.getRuntime().exec(sets);
        
            writeTotal = writeTotal + writeSize;
            //System.out.println(writeTotal);
        }
        
    }
    public static boolean writeFile(String filepath,String blockName,long blockSize,long beginPos)
    throws Exception {

        RandomAccessFile raf=null;
        FileOutputStream fos=null;
        byte[] bt=new byte[1024];
        long writeByte=0;
        int len=0;
        try{
            raf = new RandomAccessFile(filepath,"r");
            raf.seek(beginPos);
            fos = new FileOutputStream(blockName);
            while((len=raf.read(bt))>0){       
                if(writeByte<blockSize){    //
                    writeByte=writeByte+len;
                    if(writeByte<=blockSize)
                        fos.write(bt,0,len);
                    else{
                        len=len-(int)(writeByte-blockSize);
                        fos.write(bt,0,len);
                    }
                }          
            }
            fos.close();
            raf.close();
        }
        catch (Exception e){
            e.printStackTrace();
            try{
                if(fos!=null)
                    fos.close();
                if(raf!=null)
                    raf.close();
            }
            catch(Exception f){
                f.printStackTrace();
            }
            return false;
        }
        return true;
    }
    
    public static void getBlock(String filepath,long blockSize,long blockIndex) throws Exception {
        File file = new File(filepath);
        long fileSize = file.length();
        long writeTotal = blockSize*(blockIndex-1) ;
        long writeSize = 0;
        //String fileName = file.getName();
        //System.out.println(fileSize);
        //System.out.println(fileName);
        long blockNum = fileSize / blockSize + 1;
        //System.out.println(blockNum);

        String blockName = filepath + ".part" + String.valueOf(blockIndex);
    //  System.out.println(blockName);
        
        if (blockIndex < blockNum)
            writeSize = blockSize;
        else 
            writeSize = fileSize - writeTotal;
        writeFile(filepath,blockName,writeSize,writeTotal);
        File blockfile = new File(blockName);
        String sets = "attrib +H \"" + blockfile.getAbsolutePath() + "\""; 
             
        //System.out.println(sets); 
         //  
        Runtime.getRuntime().exec(sets);
        
    }
}
        

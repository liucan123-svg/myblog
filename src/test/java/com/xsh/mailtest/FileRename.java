//package com.xsh.mailtest;
//
//import java.io.File;
//
///**
//public class FileRename {
//    public static String [] getFileName(String path) {
//        File file = new File(path);
//        String [] fileName = file.list();
//        return fileName;
//    }
//    public static void renameFile(String path,String oldname,String newname){
//        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名
//            File oldfile=new File(path+"\\"+oldname);
//            File newfile=new File(path+"\\"+newname);
//            if(!oldfile.exists()){
//                return;//重命名文件不存在
//            }
//            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
//                System.out.println(newname+"已经存在！");
//            else{
//                oldfile.renameTo(newfile);
//            }
//        }else{
//            System.out.println("新文件名和旧文件名相同...");
//        }
//    }
///*    public static void main(String[] args) {
//        String filePath="E:\\学习\\java\\代码\\springBoot\\myblog\\src\\main\\resources\\static\\images\\emoji\\bilibili";
//        String [] fileName = getFileName(filePath);
//        for (int i = 0; i < fileName.length; i++) {
//            String oldName=fileName[i];
//            String newName1=fileName[i].replace("[","");
//            String newName2=newName1.replace("]","");
//            System.out.println(newName2);
//            renameFile(filePath, fileName[i], newName2);
//        }
//    }*/
//
//    public static void main(String[] args) {
//        String filePath="C:\\Users\\Administrator\\Desktop\\rename";
//        String [] fileName = getFileName(filePath);
//        for (int i = 0; i < fileName.length; i++) {
//            String oldName=fileName[i];
//            String newName1="emoji_yier_11_"+(i+1)+".gif";
//            //String newName2=newName1.replace("]","");
//            System.out.println(newName1);
//            renameFile(filePath, fileName[i], newName1);
//        }
//    }
//}
//

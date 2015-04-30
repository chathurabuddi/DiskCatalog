/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diskcatalog.helpers;

/**
 *
 * @author CHATHURA
 */
public class Validate {
    public static boolean isValid(CompactDisk compactDisk){
        return !"".equals(compactDisk.getDiskTitle().replaceAll("\\s+","")) &&
                !"".equals(compactDisk.getDiskArtist().replaceAll("\\s+","")) &&
                compactDisk.getDiskArtist().matches("(?i)[a-z]+(\\s+[a-z]+)*") &&
                !"".equals(compactDisk.getDiskCountry().replaceAll("\\s+","")) &&
                !"".equals(compactDisk.getDiskPrice().replaceAll("\\s+","")) &&
                compactDisk.getDiskPrice().matches("[0-9]+(\\.[0-9][0-9]?)?") &&
                !"".equals(compactDisk.getDiskYear().replaceAll("\\s+","")) &&
                compactDisk.getDiskPrice().matches("^\\d+$");
    }
    
    public static String getValidationMessage(CompactDisk compactDisk){
        if("".equals(compactDisk.getDiskTitle().replaceAll("\\s+",""))) return "Title Cannot be Empty";
        if("".equals(compactDisk.getDiskArtist().replaceAll("\\s+",""))) return "Artist Cannot be Empty";
        if(!compactDisk.getDiskArtist().matches("(?i)[a-z]+(\\s+[a-z]+)*")) return "Invalid Artist Name";
        if("".equals(compactDisk.getDiskCountry().replaceAll("\\s+",""))) return "Country Cannot be Empty";
        if("".equals(compactDisk.getDiskPrice().replaceAll("\\s+",""))) return "Price Cannot be Empty";
        if(!compactDisk.getDiskPrice().matches("[0-9]+(\\.[0-9][0-9]?)?")) return "Invalid Price";
        if("".equals(compactDisk.getDiskYear().replaceAll("\\s+",""))) return "Year Cannot be Empty";
        if(!compactDisk.getDiskPrice().matches("^\\d+$")) return "Invalid Year";
        return "Valid Disk!";
    }
}

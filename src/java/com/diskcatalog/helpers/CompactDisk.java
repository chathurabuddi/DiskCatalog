package com.diskcatalog.helpers;

/**
 * @author CHATHURA
 * 
 * Represent a Compact Disk
 */
public class CompactDisk {
    private int disk_id;
    private String disk_title = "";
    private String disk_artist = "";
    private String disk_country ="";
    private String disk_price = ""; 
    private String disk_year = "";
    
    /**
     * @return the disk_id
     */
    public int getDiskId() {
        return disk_id;
    }
    
    /**
     * @param disk_id the disk_id to set
     */
    public void setDiskId(int disk_id) {
        this.disk_id = disk_id;
    }

    /**
     * @return the disk_title
     */
    public String getDiskTitle() {
        return disk_title;
    }

    /**
     * @param disk_title the disk_title to set
     */
    public void setDiskTitle(String disk_title) {
        this.disk_title = disk_title;
    }

    /**
     * @return the disk_artist
     */
    public String getDiskArtist() {
        return disk_artist;
    }

    /**
     * @param disk_artist the disk_artist to set
     */
    public void setDiskArtist(String disk_artist) {
        this.disk_artist = disk_artist;
    }

    /**
     * @return the disk_country
     */
    public String getDiskCountry() {
        return disk_country;
    }

    /**
     * @param disk_country the disk_country to set
     */
    public void setDiskCountry(String disk_country) {
        this.disk_country = disk_country;
    }

    /**
     * @return the disk_price
     */
    public String getDiskPrice() {
        return disk_price;
    }

    /**
     * @param disk_price the disk_price to set
     */
    public void setDiskPrice(String disk_price) {
        this.disk_price = disk_price;
    }

    /**
     * @return the disk_year
     */
    public String getDiskYear() {
        return disk_year;
    }

    /**
     * @param disk_year the disk_year to set
     */
    public void setDiskYear(String disk_year) {
        this.disk_year = disk_year;
    }
}

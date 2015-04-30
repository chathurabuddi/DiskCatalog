package com.diskcatalog.helpers;

import java.util.ArrayList;

/**
 * 
 * @author CHATHURA
 */
public interface CompactDiskDAO {
    
    /**
     * Returns all Compact Disks currently available
     * @return ArrayList containing all CompactDisks
     */
    public ArrayList<CompactDisk> getAll();
    
    /**
     * Returns the CompactDisk that matches with given ID
     * @param id Disk ID of the CompactDisk
     * @return CompactDisk that matches with given ID
     */
    public CompactDisk getByID(int id);
    
    /**
     * Returns all CompactDisks that matches with given values
     * @param compact_disk CompactDisk that contains search values
     * @return ArrayList containing all CompactDisks that matches with search values
     */
    public ArrayList<CompactDisk> searchCD(CompactDisk compact_disk);
    
    /**
     * Add new CompactDisk
     * @param compact_disk CompactDisk to be added
     * @return true if CompactDisk was successfully added, otherwise false
     */
    public boolean addCompactDisk(CompactDisk compact_disk);
    
    /**
     * Update existing CompactDisk
     * @param compact_disk CompactDisk to be updated
     * @return true if CompactDisk was successfully updated, otherwise false
     */
    public boolean updateCompactDisk(CompactDisk compact_disk);
    
    /**
     * Delete existing CompactDisk
     * @param disk_id Disk ID of the CompactDisk to be deleted
     * @return true if CompactDisk was successfully deleted, otherwise false
     */
    public boolean deleteCompactDisk(int disk_id);
}

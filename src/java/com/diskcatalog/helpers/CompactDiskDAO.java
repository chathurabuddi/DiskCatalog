/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diskcatalog.helpers;

import java.util.ArrayList;

/**
 *
 * @author CHATHURA
 */
public interface CompactDiskDAO {
    public ArrayList<CompactDisk> getAll();
    public CompactDisk getByID(int id);
    public boolean addCompactDisk(CompactDisk compact_disk);
    public boolean updateCompactDisk(CompactDisk compact_disk);
    public boolean deleteCompactDisk(int disk_id);
}

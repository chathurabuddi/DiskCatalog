/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diskcatalog.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHATHURA
 */
public class CompactDiskJavaDBDAO implements CompactDiskDAO {

    @Override
    public ArrayList<CompactDisk> getAll() {
        ArrayList compact_disk_set = new ArrayList();
        String query = "SELECT * FROM COMPACTDISK";
        ResultSet result_set = executeFetchQuery(query);

        try {
            while (result_set.next()) {
                CompactDisk compact_disk = new CompactDisk();
                compact_disk.setDiskId(result_set.getInt("DISK_ID"));
                compact_disk.setDiskTitle(result_set.getString("DISK_TITLE"));
                compact_disk.setDiskArtist(result_set.getString("DISK_ARTIST"));
                compact_disk.setDiskCountry(result_set.getString("DISK_COUNTRY"));
                compact_disk.setDiskPrice(result_set.getString("DISK_PRICE"));
                compact_disk.setDiskYear(result_set.getString("DISK_YEAR"));
                compact_disk_set.add(compact_disk);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return compact_disk_set;
    }

    @Override
    public boolean addCompactDisk(CompactDisk compact_disk) {
        String query = "INSERT INTO COMPACTDISK(DISK_TITLE,DISK_ARTIST,DISK_COUNTRY,DISK_PRICE,DISK_YEAR) "
                + "VALUES('" + compact_disk.getDiskTitle() + "','" + compact_disk.getDiskArtist() + "','"
                + compact_disk.getDiskCountry() + "','" + compact_disk.getDiskPrice() + "','"
                + compact_disk.getDiskYear() + "')";
        return executeModifyQuery(query);
    }

    @Override
    public boolean updateCompactDisk(CompactDisk compact_disk) {
        String query = "UPDATE COMPACTDISK SET DISK_TITLE='" + compact_disk.getDiskTitle() + "',DISK_ARTIST='"
                + compact_disk.getDiskArtist() + "',DISK_COUNTRY='" + compact_disk.getDiskCountry() + "',DISK_PRICE="
                + compact_disk.getDiskPrice() + ",DISK_YEAR=" + compact_disk.getDiskPrice();
        return executeModifyQuery(query);
    }

    @Override
    public boolean deleteCompactDisk(int disk_id) {
        String query = "DELETE FROM COMPACTDISK WHERE DISK_ID="+disk_id;
        return executeModifyQuery(query);
    }

    private boolean executeModifyQuery(String query) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CD_DATABASE", "app", "app");
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            ps.close();
            con.close();
            return i > 0;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    private ResultSet executeFetchQuery(String query) {
        ResultSet resultset = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CD_DATABASE", "app", "app");
            PreparedStatement ps = con.prepareStatement(query);
            resultset = ps.executeQuery();
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return resultset;
    }

}

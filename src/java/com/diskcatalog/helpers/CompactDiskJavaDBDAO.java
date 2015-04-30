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

/**
 *
 * @author CHATHURA
 */
public class CompactDiskJavaDBDAO implements CompactDiskDAO {

    String connectionURL = "jdbc:derby://localhost:1527/CD_DATABASE";
    String connectionUsername = "app";
    String connectionPassword = "app";

    @Override
    public ArrayList<CompactDisk> getAll() {
        String query = "SELECT * FROM COMPACTDISK";
        return executeFetchQuery(query);
    }

    @Override
    public CompactDisk getByID(int id) {
        ArrayList<CompactDisk> compact_disk_set = new ArrayList<>();
        String query = "SELECT * FROM COMPACTDISK WHERE DISK_ID=" + id;
        return executeFetchQuery(query).get(0);
    }

    @Override
    public ArrayList<CompactDisk> searchCD(CompactDisk compact_disk) {
        
        // Since price and year are numbers we cant use as same way other fields doese.
        // Only if it is empty, the string will be repacced with %%.
        // Otherwise search with exact number rather than a part of number.
        String price = "".equals(compact_disk.getDiskPrice().replaceAll("\\s+",""))?"%%":compact_disk.getDiskPrice();
        String year = "".equals(compact_disk.getDiskYear().replaceAll("\\s+",""))?"%%":compact_disk.getDiskYear();
        
        String query = "SELECT * FROM COMPACTDISK WHERE "
                + "DISK_TITLE LIKE '%" + compact_disk.getDiskTitle() + "%' AND "
                + "DISK_ARTIST LIKE '%" + compact_disk.getDiskArtist() + "%' AND "
                + "DISK_COUNTRY LIKE '%" + compact_disk.getDiskCountry() + "%' AND "
                + "DISK_PRICE LIKE '" + price+ "' AND "
                + "DISK_YEAR LIKE '" + year+ "'";
        return executeFetchQuery(query);
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
                + compact_disk.getDiskArtist() + "',DISK_COUNTRY='" + compact_disk.getDiskCountry() + "',DISK_PRICE='"
                + compact_disk.getDiskPrice() + "',DISK_YEAR='" + compact_disk.getDiskYear()
                + "' WHERE DISK_ID=" + compact_disk.getDiskId();
        return executeModifyQuery(query);
    }

    @Override
    public boolean deleteCompactDisk(int disk_id) {
        String query = "DELETE FROM COMPACTDISK WHERE DISK_ID=" + disk_id;
        return executeModifyQuery(query);
    }

    private boolean executeModifyQuery(String query) {
        try {
            Connection con = DriverManager.getConnection(connectionURL, connectionUsername, connectionPassword);
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

    private ArrayList<CompactDisk> executeFetchQuery(String query) {
        ResultSet result_set = null;
        ArrayList<CompactDisk> compact_disk_set = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(connectionURL, connectionUsername, connectionPassword);
            PreparedStatement ps = con.prepareStatement(query);
            result_set = ps.executeQuery();

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
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return compact_disk_set;
    }

}

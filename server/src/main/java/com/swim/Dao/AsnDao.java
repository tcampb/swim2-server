package com.swim.Dao;

import com.swim.model.Asn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AsnDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /*METHODS FOR CRUD ARE LISTED BELOW*/

    //Creates an Asn in the DB
    public void createAsn(Asn asn) {
        try {
            SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(asn);
            jdbcTemplate.update("insert into asns values (:asn, :vendorId, :expectedArrivalDate,:expectedArrivalTime, :status, '[]', :dockDoor)", parameterSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create an Asn method to GET the AsnByID
    public Asn getAsnById(int id) {
        RowMapper<Asn> rw = new RowMapper<Asn>() {
            @Override
            public Asn mapRow(ResultSet resultSet, int i) throws SQLException {
                Asn asn = new Asn();
                asn.setAsn(resultSet.getInt(1));
                asn.setVendorId(resultSet.getString(2));
                asn.setExpectedArrivalDate(resultSet.getString(3));
                asn.setExpectedArrivalTime(resultSet.getString(4));
                asn.setStatus(resultSet.getString(5));
                asn.setSerials(new ArrayList<>());
                asn.setDockDoor(resultSet.getString(7));
                return asn;
            }
        };
        List<Asn> asnList = jdbcTemplate.query("SELECT * FROM asns WHERE asn = " + id, rw);
        return asnList.get(0);
    }


    // Create an Asn method to Delete an AsnById
    public void deleteAnsById(int id) {
        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("id", id);
        jdbcTemplate.update("DELETE FROM asns WHERE asn = :id ", testMap);


    }

    public List<Asn> getAllAsn(){
        RowMapper<Asn> rw = new RowMapper<Asn>() {
            @Override
            public Asn mapRow(ResultSet resultSet, int i) throws SQLException {
                Asn asn = new Asn();
                asn.setAsn(resultSet.getInt(1));
                asn.setVendorId(resultSet.getString(2));
                asn.setExpectedArrivalDate(resultSet.getString(3));
                asn.setExpectedArrivalTime(resultSet.getString(4));
                asn.setStatus(resultSet.getString(5));
                asn.setSerials(new ArrayList<>());
                asn.setDockDoor(resultSet.getString(7));
                return asn;
            }
        };
        List<Asn> asnList = jdbcTemplate.query("SELECT * FROM asns", rw);
        System.out.println(asnList.size());

        return asnList;
    }

}

package com.swim.Dao;

import com.swim.model.Asn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

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
            asn.setSerials(null);
            SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(asn);
            jdbcTemplate.update("insert into asns values (:asn, :vendorId, :expectedArrivalDate,:expectedArrivalTime, :status, :serials, :dockDoor)", parameterSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create an Asn method to GET the AsnByID
    public Asn getAsnById(int id) {
        List<Asn> asnList = jdbcTemplate.query("SELECT * FROM asns WHERE asn = " + id, new BeanPropertyRowMapper<Asn>(Asn.class));
        return asnList.get(0);
    }


    // Create an Asn method to Delete an AsnById
    public void deleteAnsById(int id) {
        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("id", id);
        jdbcTemplate.update("DELETE FROM asns WHERE asn = :id ", testMap);


    }

    public List<Asn> getAllAsn(){
        List<Asn> asnList = jdbcTemplate.query("SELECT * FROM asns", new BeanPropertyRowMapper<>(Asn.class));
        System.out.println(asnList.size());

        return asnList;
    }

}

package com.swim.DaoSpecs;

import com.swim.Dao.AsnDao;
import com.swim.model.Asn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AsnSpec {

    @Autowired
    AsnDao asnDao;

    Asn asn = new Asn();

    List<Asn> asnList = new ArrayList<>();

    @Before
    public void setup() {
        // Create the Asn object
        for (int i=1; i < 6; i++) {
            Asn asn = new Asn();
            // Create data to be tested
            asn.setAsn(i);
            asn.setExpectedArrivalDate("2018-06-15");
            asn.setExpectedArrivalTime("10:00");
            asn.setVendorId("13");
            asn.setStatus("In-Transit");
            this.asnList.add(asn);
            asnDao.createAsn(asn);
        }
    }


    @Test
    public void getAsnById() {
        //Create an Asn object from Data in the DB
        Asn asn = asnDao.getAsnById(1);
        Assert.assertEquals(asn.getAsn(), 1);
    }

    @Test
    public void getAllAsn() {
        List<Asn> asnList = asnDao.getAllAsn();
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        Iterator item = num.iterator();

        for(Asn asn : asnList){
            int idOfAsn = asn.getAsn();
            Assert.assertEquals(item.next(), idOfAsn);
        }
    }

    @Test
    public void createAsn() {
        // Call the method for the new asn object
        this.asn.setAsn(12);
        this.asn.setExpectedArrivalDate("2018-06-15");
        this.asn.setExpectedArrivalTime("10:00");
        this.asn.setVendorId("13");
        this.asn.setStatus("In-Transit");
        asnDao.createAsn(this.asn);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteAsn() {
        asnDao.deleteAnsById(1);
        asnDao.getAsnById(1);
    }


    @Test
    public void updateAsn() {


    }

    @After
    public void cleanUp() {
        asnDao.deleteAnsById(1);
        asnDao.deleteAnsById(2);
        asnDao.deleteAnsById(3);
        asnDao.deleteAnsById(4);
        asnDao.deleteAnsById(5);
        asnDao.deleteAnsById(12);
    }

}

package com.swim.controller;

import com.swim.model.Asn;
import com.swim.service.AsnService;
import com.swim.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AsnController {

    @Autowired
    Environment env;

    @Autowired
    AsnService asnService;

    @Autowired
    ProductService productService;

    @PostMapping("/api/receive/asn")
    public void receiveAsn(@RequestBody Asn asn) {
        asn.setStatus("in-transit");
        asn.setDockDoor("Not assigned");
        String[] updatedDateArr = asn.getExpectedArrivalDate().split("/");
        String updatedDate = updatedDateArr[2] + "-" + updatedDateArr[0] + "-" + updatedDateArr[1];
        asn.setExpectedArrivalDate(updatedDate);
        asnService.insertAsn(asn);
        asn.getSerials().stream()
                .forEach(product -> {
                    product.getSerial();
                    product.setAsn(asn.getAsn());
                    product.setDelivered(false);
                    product.setReceived(false);
                    productService.insertProduct(product);
                });
    }

    @GetMapping("/api/asns")
    public List<Asn> getAllAsns() {
        return asnService.getAllAsns();
    }

    @PostMapping("/api/update/product/received/{asnId}")
    public void updateProductStatusReceived(@RequestBody ArrayList<Integer> serialList, @PathVariable int asnId) {
        asnService.updateToReceived(serialList, asnId);
    }

    @PostMapping("/api/update/product/delivered/{asnId}")
    public void updateProductStatusDelivered(@RequestBody ArrayList<Integer> serialList, @PathVariable int asnId) {
        asnService.updateToDelivered(serialList, asnId);
    }

    @PostMapping("/api/submit/received/{asnId}/{dockdoor}")
    public void productReceivedForm(@RequestBody ArrayList<Integer> serialList, @PathVariable int asnId, @PathVariable int dockdoor) {
        productService.updateReceivedItems(serialList, asnId, dockdoor);
    }

    @PostMapping("/api/submit/delivered/{asnId}/{dockdoor}")
    public void productDeliveredForm(@RequestBody ArrayList<Integer> serialList, @PathVariable int asnId, @PathVariable int dockdoor) {
        productService.updateDeliveredItems(serialList, asnId, dockdoor);
    }

}


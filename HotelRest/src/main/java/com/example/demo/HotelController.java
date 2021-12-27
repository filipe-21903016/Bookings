package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

@RestController
public class HotelController {

    @RequestMapping("/ping")
    public String ping() {
        try {
            System.setSecurityManager(new RMISecurityManager());
            String serverURL = "rmi://172.22.146.208/HotelServer";
            HotelServerIntf HotelServerIntf = (HotelServerIntf) Naming.lookup(serverURL);
            return HotelServerIntf.ping();
        }
        catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping("/availableRooms")
    public void listAvailableRooms() {
        try {
            String serverURL = "rmi://172.22.146.208/HotelServer";
            HotelServerIntf HotelServerIntf = (HotelServerIntf) Naming.lookup(serverURL);
            String[] res = HotelServerIntf.listAvailableRooms();
            for (String s : res) {
                System.out.println(s);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return ;
        }
    }
}

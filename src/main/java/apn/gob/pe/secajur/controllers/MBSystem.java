/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eshupingahua
 */
@ManagedBean(name = "msystem")
public class MBSystem implements Serializable {

    /**
     * Creates a new instance of MBSystem
     */
    private String myOS, myOSArchmy, myOSVersion, myJavaVendor, myJavaVersion, myUser;

    public String getMyOS() {
        myOS = System.getProperty("os.name");
        return myOS;
    }

    public void setMyOS(String myOS) {
        this.myOS = myOS;
    }

    public String getMyOSArchmy() {
        myOSArchmy = System.getProperty("os.arch");
        return myOSArchmy;
    }

    public void setMyOSArchmy(String myOSArchmy) {
        this.myOSArchmy = myOSArchmy;
    }

    public String getMyOSVersion() {
        myOSVersion = System.getProperty("os.version");

        return myOSVersion;
    }

    public void setMyOSVersion(String myOSVersion) {

        this.myOSVersion = myOSVersion;
    }

    public String getMyJavaVendor() {
        myJavaVendor = System.getProperty("java.vendor");
        return myJavaVendor;
    }

    public void setMyJavaVendor(String myJavaVendor) {
        this.myJavaVendor = myJavaVendor;
    }

    public String getMyJavaVersion() {
        myJavaVersion = System.getProperty("java.version");
        return myJavaVersion;
    }

    public void setMyJavaVersion(String myJavaVersion) {
        this.myJavaVersion = myJavaVersion;
    }

    public String getMyUser() {
        myUser = System.getProperty("user.name");
        return myUser;
    }

    public void setMyUser(String myUser) {
        this.myUser = myUser;
    }

}
